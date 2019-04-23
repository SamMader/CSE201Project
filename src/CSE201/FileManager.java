package CSE201;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
	
	//to-do, implement default save path
	public static final String DEFAULT_SAVE_PATH = "";

	/***/
	
	public static void clearFile(String path) {
		write(path, "");
	}

	/***/
	
	public static boolean createFile(String path) {
		File file = new File(path);

		try {
			return file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/***/

	public static String read(String path) {
		return null;
	}
	
	/***/

	public static String readLine(String path, int i) {
		return null;
	}
	
	/***/

	public static void write(String path, String data) {
		BufferedWriter writer;

		try {
			writer = new BufferedWriter(new FileWriter(path));
			writer.write(data);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/***/

	public static void writeLine(String path, String data) {
		BufferedWriter writer;

		try {
			writer = new BufferedWriter(new FileWriter(path, true));
			writer.write(data);
			writer.newLine();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Loads data into a catalog
	public static void loadAppData(String path, Catalog loadInto) {
		BufferedReader reader;
		String data;
		
		try {
			reader = new BufferedReader(new FileReader(path));
			
			//will read each line
			while((data = reader.readLine()) != null) {
				if(data.equals("") || data.equals(" ")) {
					continue;
				}else {
					//splits the string using the "-" delimiter
					String[] temp = data.split("-");
					//Loads the data
					loadInto.add(temp[0], temp[1], temp[2], Double.parseDouble(temp[3]), Integer.parseInt(temp[4]));
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void addAppData(String path, String name, String author, String genre, double price, int downloads) {
		FileManager.writeLine("applications.txt", name + "-" + author + "-" + genre + "-" + price + "-" + downloads);
	}
	
	public static void loadUserData(ArrayList<User> loadInto, String path) {
		
	}
}
