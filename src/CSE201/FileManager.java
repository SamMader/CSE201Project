import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

}
