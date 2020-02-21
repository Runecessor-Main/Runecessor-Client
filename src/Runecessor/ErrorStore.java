package Runecessor;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Save client errors to 1 text file.
 * @author Lava, created on 27-11-2017.
 */
public class ErrorStore {

	private final static int ERROR_FULL_FILE_MAXIMUM_SIZE_MB = 8;

	public final static String ERROR_TEMP_LOCATION = ClientConstants.getRunecessorFolderLocation() + "error_temp.txt";

	public final static String ERROR_FULL_LOCATION = ClientConstants.getRunecessorFolderLocation() + "error_full.txt";

	public static void setOutputToFile() {
		if (ClientDebugConfiguration.DEBUG_MODE) {
			return;
		}
		deleteMassiveErrorFullFile();
		File folder = new File(ClientConstants.getRunecessorFolderLocation());
		if (!folder.exists()) {
			folder.mkdir();
		}
		error = Utility.readFile(ERROR_TEMP_LOCATION);
		PrintStream out;
		try {
			out = new PrintStream(new FileOutputStream(ERROR_TEMP_LOCATION));
			System.setOut(out);
			System.setErr(out);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ErrorStore.errorManager();

	}

	private static void deleteMassiveErrorFullFile() {
		File file = new File(ERROR_FULL_LOCATION);
		if (file.exists()) {
			long size = file.length();
			if (size > (long) ERROR_FULL_FILE_MAXIMUM_SIZE_MB * 1000000) {
				file.delete();
			}
		}

		file = new File(ERROR_TEMP_LOCATION);
		if (file.exists()) {
			long size = file.length();
			if (size > (long) ERROR_FULL_FILE_MAXIMUM_SIZE_MB * 1000000) {
				file.delete();
			}
		}
	}

	public static ArrayList<String> error = new ArrayList<String>();

	public static void errorManager() {
		Utility.print("Client version: " + ClientLiveConfiguration.CLIENT_VERSION + "-------------------------------------");
		//Launch client it will wrote to error file the client version.
		// Alll errors get saved to error_temp.txt
		//When i launch client, it reads it and saves it to another file named error_full.txt
		//Then player sends error_full.txt to me

		// if it is more than 1, it means the error_temp.txt file has more than 1 line, which means a line other than the client version got printed.
		if (error.size() > 1) {
			Utility.saveArrayContents(ERROR_FULL_LOCATION, error);
		}
	}
}
