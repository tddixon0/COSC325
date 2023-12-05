package testing;

import java.io.*;
import java.util.*;

public class TESTclass {

	    public static List<String> readColumn(String filePath, int columnIndex) {
	        List<String> columnData = new ArrayList<>();

	        try (FileInputStream fileInputStream = new FileInputStream(filePath);
	             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
	             BufferedReader reader = new BufferedReader(inputStreamReader)) {

	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] cells = line.split(","); // Use a comma (,) as the delimiter for CSV files
	                if (cells.length > columnIndex) {
	                    String cellValue = cells[columnIndex];
	                    columnData.add(cellValue);
	                }
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return columnData;
	    }

	    public static void main(String[] args) {
	        String filePath = "src/departure.xlsx"; // Replace with the actual path to your CSV file.
	        int columnIndex = 2; // Specify the index of the column you want to read (0 for the first column).

	        List<String> columnData = readColumn(filePath, columnIndex);
	        if (!columnData.isEmpty()) {
	            System.out.println("Column Data:\n" + String.join("\n", columnData));
	        } else {
	            System.out.println("Failed to read the column data.");
	        }
	    }
	}
