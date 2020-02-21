package Runecessor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Utility {

	public static void printStackTrace() {
		for (int index = 0; index < Thread.currentThread().getStackTrace().length; index++) {
			print(Thread.currentThread().getStackTrace()[index].getClassName() + "#" + Thread.currentThread().getStackTrace()[index].getMethodName());
		}
	}

	public static void printStackTraceArrayList() {
		ArrayList<String> string = new ArrayList<String>();
		for (int index = 0; index < Thread.currentThread().getStackTrace().length; index++) {
			string.add(Thread.currentThread().getStackTrace()[index].getClassName() + "#" + Thread.currentThread().getStackTrace()[index].getMethodName());
		}
	}

	public static String findRemoteIpAddressOr(String defaultIfNull) {
		Objects.requireNonNull(defaultIfNull, "Default value is null.");
		try {
			final URL url = new URL("https://api.ipify.org");

			try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
				return reader.lines().findFirst().orElse(null);
			} catch (IOException e) {
				e.printStackTrace();
				return defaultIfNull;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return defaultIfNull;
		}
	}

	public static int convertToPositive(int number) {
		return Math.abs(number);
	}

	public static double getDoubleRoundedUp(double doubleNumber) {
		return Math.ceil(doubleNumber);
	}

	public static double getDoubleRoundedDown(double doubleNumber) {
		return (double) ((int) doubleNumber);
	}

	/**
	 * Format number into for example: 357,555
	 */
	public static String formatNumber(long number) {
		// Do not use return NumberFormat.getIntegerInstance().format(number);. It is 9 times slower.
		String string = Long.toString(number);
		if (number < 1000) {
			return string;
		}
		if (number >= 1000 && number < 10000) {
			return string.substring(0, 1) + "," + string.substring(1);
		}
		if (number < 100000) {
			return string.substring(0, 2) + "," + string.substring(2);
		}
		if (number < 1000000) {
			return string.substring(0, 3) + "," + string.substring(3);
		}
		if (number < 10000000) {
			return string.substring(0, 1) + "," + string.substring(1, 4) + "," + string.substring(4, 7);
		}
		if (number < 100000000) {
			return string.substring(0, 2) + "," + string.substring(2, 5) + "," + string.substring(5, 8);
		}
		if (number < 1000000000) {
			return string.substring(0, 3) + "," + string.substring(3, 6) + "," + string.substring(6, 9);
		}
		if (number <= Integer.MAX_VALUE) {
			return string.substring(0, 1) + "," + string.substring(1, 4) + "," + string.substring(4, 7) + "," + string.substring(7, 10);
		}
		return string;
	}

	/**
	 * This one shows 7.2m 15.3 153.6m instead of 150m
	 * @param num
	 * @return
	 */
	public static String formatRunescapeStyle(int num) {
		return formatRunescapeStyle((long) num);
	}

	public static String formatRunescapeStyle(long num) {
		if (num <= 0) {
			return Long.toString(num);
		}
		int length = String.valueOf(num).length();
		String number = Long.toString(num);
		String numberString = number;
		String end = "";
		if (length == 4) {
			numberString = number.substring(0, 1) + "k";
			//6400
			double doubleVersion = 0.0;
			doubleVersion = num / 1000.0;
			if (doubleVersion != getDoubleRoundedUp(doubleVersion)) {
				if (num - (1000 * getDoubleRoundedDown(doubleVersion)) > 100) {
					numberString = number.substring(0, 1) + "." + number.substring(1, 2) + "k";
				}
			}
		}
		else if (length == 5) {
			numberString = number.substring(0, 2) + "k";
		}
		else if (length == 6) {
			numberString = number.substring(0, 3) + "k";
		}
		else if (length == 7) {
			String sub = number.substring(1, 2);
			if (sub.equals("0")) {
				numberString = number.substring(0, 1) + "m";
			}
			else {
				numberString = number.substring(0, 1) + "." + number.substring(1, 2) + "m";
			}
		}
		else if (length == 8) {
			end = "." + number.substring(2, 3);
			if (end.equals(".0")) {
				end = "";
			}
			numberString = number.substring(0, 2) + end + "m";
		}
		else if (length == 9) {
			end = "." + number.substring(3, 4);
			if (end.equals(".0")) {
				end = "";
			}
			numberString = number.substring(0, 3) + end + "m";
		}
		else if (length == 10) {
			numberString = number.substring(0, 4) + "m";
		}
		else if (length == 11) {
			numberString = number.substring(0, 2) + "." + number.substring(2, 5) + "b";
		}
		else if (length == 12) {
			numberString = number.substring(0, 3) + "." + number.substring(3, 6) + "b";
		}
		else if (length == 13) {
			numberString = number.substring(0, 4) + "." + number.substring(4, 7) + "b";
		}

		return numberString;
	}
	public static String getTimeLeft(int seconds) {
		int hours = 0;
		int minutes = 0;
		int secondsLeft = 0;

		String time = "";
		if (seconds > 3600) {
			hours = seconds / 3600;
			time = hours + "h";
		}
		int value1 = 0;
		value1 = seconds - (hours * 3600);
		if (value1 > 0) {
			minutes = value1 / 60;
			if (minutes > 0) {
				if (!time.isEmpty()) {
					time = time + " ";
				}
				time = time + minutes + "m";
			}
		}
		int value2 = value1 - (minutes * 60);
		if (value2 >= 0) {
			secondsLeft = value2;


			if (!time.isEmpty()) {
				time = time + " ";
			}
			time = time + secondsLeft + "s";
		}
		return time;
	}


	public static boolean isIgnored(String name) {
		long nameToLong = TextClass.longForName(name);
		for (int index = 0; index < Client.instance.ignoreCount; index++) {
			if (Client.instance.ignoreListAsLongs[index] != nameToLong) {
				continue;
			}
			return true;
		}
		return false;
	}

	public static boolean isIgnored(long nameToLong) {
		for (int index = 0; index < Client.instance.ignoreCount; index++) {
			if (Client.instance.ignoreListAsLongs[index] != nameToLong) {
				continue;
			}
			return true;
		}
		return false;
	}

	public static ArrayList<String> readFile(String location) {
		ArrayList<String> arraylist = new ArrayList<String>();
		try {
			BufferedReader file = new BufferedReader(new FileReader(location));
			String line;
			while ((line = file.readLine()) != null) {
				if (!line.isEmpty()) {
					arraylist.add(line);
				}
			}
			file.close();
		}
		catch (Exception e) {
			if (ClientDebugConfiguration.PRINT_ALL_EXCEPTION) {
				e.printStackTrace();
			}
		}
		return arraylist;
	}

	public static void print(String text) {
		System.out.println(text);
	}

	public static void print(int text) {
		System.out.println(text);
	}

	public static int random(int min, int max) {
		return min + (int) (Math.random() * ((max - min) + 1));
	}

	public static void addLineOnTxt(String location, String line) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(location, true));
			bw.write(line);
			bw.newLine();
			bw.flush();
			bw.close();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static boolean accountExists(String location) {
		File firstFolder = new File(location);
		if (firstFolder.exists()) {
			return true;
		}
		return false;
	}


	public static void saveArrayContents(String location, ArrayList<?> arraylist) {
		if (arraylist.isEmpty()) {
			return;
		}
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(location, true));

			for (int index = 0; index < arraylist.size(); index++) {
				bw.write("" + arraylist.get(index));
				bw.newLine();
			}

			bw.flush();
			bw.close();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static List<String> readLinesFromHttpURL(URL url) throws IOException {
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
			List<String> lines = new ArrayList<>();

			String next;

			while ((next = reader.readLine()) != null) {
				lines.add(next);
			}

			return lines;
		}
	}

	public static void deleteAllLines(String fileLocation) {
		if (!accountExists(fileLocation)) {
			return;
		}
		try {
			FileOutputStream writer = new FileOutputStream(fileLocation);
			writer.write((new String()).getBytes());
			writer.close();

		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static String getAorAn(String entityName) {
		String string = "a";
		if (entityName.startsWith("a") || entityName.startsWith("e") || entityName.startsWith("i") || entityName.startsWith("o") || entityName.startsWith("u")) {
			string = "an";
		}
		return string;
	}

}
