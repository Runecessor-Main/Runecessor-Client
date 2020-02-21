package Runecessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class CreateUID {

	public static String getWMIValue(String wmiQueryStr, String wmiCommaSeparatedFieldName) throws Exception {
		String vbScript = getVBScript(wmiQueryStr, wmiCommaSeparatedFieldName);
		String tmpDirName = getEnvVar("TEMP").trim();
		String tmpFileName = tmpDirName + File.separator + "jwmi.vbs";
		writeStrToFile(tmpFileName, vbScript);
		String output = execute(new String[]
		{"cmd.exe", "/C", "cscript.exe", tmpFileName});
		new File(tmpFileName).delete();

		return output.trim();
	}

	private static final String CRLF = "\r\n";

	private static String getVBScript(String wmiQueryStr, String wmiCommaSeparatedFieldName) {
		String vbs = "Dim oWMI : Set oWMI = GetObject(\"winmgmts:\")" + CRLF;
		vbs += "Dim classComponent : Set classComponent = oWMI.ExecQuery(\"" + wmiQueryStr + "\")" + CRLF;
		vbs += "Dim obj, strData" + CRLF;
		vbs += "For Each obj in classComponent" + CRLF;
		String[] wmiFieldNameArray = wmiCommaSeparatedFieldName.split(",");
		for (int i = 0; i < wmiFieldNameArray.length; i++) {
			vbs += "  strData = strData & obj." + wmiFieldNameArray[i] + " & VBCrLf" + CRLF;
		}
		vbs += "Next" + CRLF;
		vbs += "wscript.echo strData" + CRLF;
		return vbs;
	}

	private static String getEnvVar(String envVarName) throws Exception {
		String varName = "%" + envVarName + "%";
		String envVarValue =  execute(new String[]
		{"cmd.exe", "/C", "echo " + varName});
		if (envVarValue.equals(varName)) {
			throw new Exception("Environment variable '" + envVarName + "' does not exist!");
		}
		return envVarValue;
	}

	private static void writeStrToFile(String filename, String data) throws Exception {
		FileWriter output = new FileWriter(filename);
		output.write(data);
		output.flush();
		output.close();
		output = null;
	}

	private static String execute(String[] cmdArray) throws Exception {
		Process process = Runtime.getRuntime().exec(cmdArray);
		BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String output = "";
		String line = "";
		while ((line = input.readLine()) != null) {
			//need to filter out lines that don't contain our desired output
			if (!line.contains("Microsoft") && !line.equals("")) {
				output += line + CRLF;
			}
		}
		process.destroy();
		process = null;
		return output.trim();
	}

	public final static boolean DEBUG_UID = false;

	public static String generateUID() throws Exception {
		if (Client.osName.toLowerCase().contains("mac")) {
			String macUid = getAppleSN();
			if (macUid.length() > 60) {
				macUid = macUid.substring(0, 60);
			}
			return macUid;
		}

		String windowsUid = getWindowsUidBasic();
		if (windowsUid.equals("invalid")) {
			windowsUid = Client.identifierSet.baseBoardSerialId;
			if (windowsUid.equals("invalid")) {
				windowsUid = getWindowsSnDifferent();
			}
		}

		if (DEBUG_UID) {
			String error = "";
			Object[] options =
			{"Open website", "Continue"};
			int input = JOptionPane.showOptionDialog(null, error, "Debug_1", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null);
		}


		return windowsUid;
	}

	public static String getWindowsHardDriveUid(String hardDriveLetter) {
		if (Client.osName.toLowerCase().contains("mac")) {
			return "invalid";
		}
		String uid = "invalid";
		try {
			uid = getHardDriveUniqueNumber(hardDriveLetter);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return formatUid(uid);

	}


	public static String getHardDriveUniqueNumber(String drive) {
		String result = "";
		try {
			File file = File.createTempFile("realhowto", ".vbs");
			file.deleteOnExit();
			FileWriter fw = new java.io.FileWriter(file);

			String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\n" + "Set colDrives = objFSO.Drives\n" + "Set objDrive = colDrives.item(\"" + drive + "\")\n" + "Wscript.Echo objDrive.SerialNumber"; // see note
			fw.write(vbs);
			fw.close();
			Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = input.readLine()) != null) {
				result += line;
			}
			input.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result.trim();
	}

	public static String getWindowsUidBasic() {
		if (Client.osName.toLowerCase().contains("mac")) {
			return "invalid";
		}
		String finalString = "invalid";
		try {
			String serial = getWMIValue("SELECT SerialNumber FROM Win32_BIOS", "SerialNumber");
			//serial = serial.replaceAll("[^\\d]", "");
			String idate = getWMIValue("Select InstallDate from Win32_OperatingSystem", "InstallDate");
			//idate = idate.replaceAll("[^\\d]", "");
			finalString = (serial.concat(idate));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return formatUid(finalString);
	}

	private final static String[] incorrectUidEquals = {
			"windows_sn",
			"0",
			"unknown",
			"1",
			".",
			"0a",
			"*",
			"...",
			"00000000",
			"............",
			"ffffffff",
			"standard",
			"n/a",
			"na",
			"type2-boardserialnumber",
			"ffffffff",
			"null",
			"oem",
			"none",
			"baseboardserialnumber",
			"invalid",
			"system",
			"null",
			"default",
			"tobefilledbyo.e.m.",
			"defaultstring",
			"cscripterror",
			"to", 
			"not",
			"notapplicable",
			"0",
			"1",
			"gxxxxxxxxxxxx",
			"123490en400015",
	};

	private final static String[] incorrectUidContains = {
			"inputerror:",
			"cscripterror:",
			"123456789",
	};
	public static String formatUid(String uid) {
		uid = uid.toLowerCase();
		uid = uid.trim();
		uid = uid.replaceAll("\\s", "");
		for (int index = 0; index < incorrectUidEquals.length; index++) {
			if (uid.equals(incorrectUidEquals[index])) {
				return "invalid";
			}
		}
		for (int index = 0; index < incorrectUidContains.length; index++) {
			if (uid.contains(incorrectUidContains[index])) {
				return "invalid";
			}
		}
		if (uid.length() > 60) {
			uid = uid.substring(0, 60);
		}
		if (uid.isEmpty()) {
			return "invalid";
		}
		return uid;
	}

	public static final String CLASS_Win32_BIOS = "Win32_BIOS";

	public static final String CLASS_Win32_OperatingSystem = "Win32_OperatingSystem";

	public static String getAppleSN() {
		ProcessBuilder pb = new ProcessBuilder("bash", "-c", "ioreg -l | awk '/IOPlatformSerialNumber/ { print $4;}'");
		pb.redirectErrorStream(true);
		String result = "invalid";
		try {
			Process p = pb.start();
			String s;
			BufferedReader stdout = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((s = stdout.readLine()) != null) {
				result = s.replaceAll("\"", "");
			}
			p.getInputStream().close();
			p.getOutputStream().close();
			p.getErrorStream().close();

			if (result.isEmpty()) {
				return "invalid";
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

		return result.trim();
	}

	public static final String getWindowsSnDifferent() {
		if (Client.osName.toLowerCase().contains("mac")) {
			return "invalid";
		}
		String sn = "invalid";

		try {
			OutputStream os = null;
			InputStream is = null;

			Runtime runtime = Runtime.getRuntime();
			Process process = null;
			try {
				process = runtime.exec(new String[]
				{"wmic", "bios", "get", "serialnumber"});
			}
			catch (IOException e) {
				e.printStackTrace();
				return "invalid";
			}

			os = process.getOutputStream();
			is = process.getInputStream();

			try {
				os.close();
			}
			catch (IOException e) {
			}

			Scanner sc = new Scanner(is);
			try {
				while (sc.hasNext()) {
					String next = sc.next();
					if ("SerialNumber".equals(next)) {
						sn = sc.next().trim();
						break;
					}
				}
			}
			finally {
				try {
					is.close();
					sc.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (sn.isEmpty()) {
				return "invalid";
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return formatUid(sn);
	}

}
