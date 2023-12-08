package UserDataForFlight;	

import java.io.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SaveFlightData {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the city you want to go to: ");
        String keyword = scan.nextLine().trim().toLowerCase();  
        String file = "departure.xlsx";

        BufferedReader reader = null;
        String line = "";
        ArrayList<String> matchingRows = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                boolean keywordFound = false;

                for (String data : row) {
                    if (data.trim().toLowerCase().contains(keyword)) {
                        keywordFound = true;
                        break;
                    }
                }
                if (keywordFound) {
                    matchingRows.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (matchingRows.isEmpty()) {
            System.out.println("No matching data found.");
        } else {
            for (String row : matchingRows) {
                System.out.println(row);
            }
        }
    }
}
