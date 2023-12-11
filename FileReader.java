

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

	/**
	 * Reads file and returns something
	 * 
	 * @param fname
	 * @return
	 */
	public String[] readCSV(String fname) {

		File myFile = new File(fname);
		try {
			Scanner scanner = new Scanner(myFile);

			String[][] data = new String[1000][1000];
			int i = 0;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				System.out.println(line);
				String[] line1 = scanner.nextLine().split(",");
				data[i] = line1;
				i += 1;

			}

		} catch (FileNotFoundException e) {

//			e.printStackTrace();
			System.err.println("Hello error");

		} catch (Exception e) { // this is very bad form

		}

		return null;

	}
}
