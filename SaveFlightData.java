
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SaveFlightData {
	
//	public static final String EXCEL_FILE_PATH = "./departures.xlsx./";
	
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the city you want to go to: ");
        String keyword = scan.nextLine().trim().toLowerCase();  
        String file = "C:\\Users\\gavin\\eclipse-workspace\\flightt\\src\\flightt\\DepartureFlights.csv";
//        String file = EXCEL_FILE_PATH;
//        String file = "";

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
            int i = 1;
            for (String row : matchingRows) {
                System.out.println(i + ". " + row);
                i++;
            }
            System.out.println("Choose a flight from the list above (enter the number): ");
            int choice = scan.nextInt();
            if (choice > 0 && choice <= matchingRows.size()) {
                System.out.println("You chose: " + matchingRows.get(choice - 1));
                int paymentNumber = getInstance().generatePaymentNum();
                System.out.println("Your payment number is: " + paymentNumber);
                getInstance().processTransactions(paymentNumber);
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
	public class Luggage {
	    private int size;
	    private String color;
	    private String brand;
	    public String referenceNumber;

	    public Luggage(int size, String color, String brand, String referenceNumber) {
	        this.size = size;
	        this.color = color;
	        this.brand = brand;
	        this.referenceNumber = referenceNumber;
	    }
	    public String toString() {
	        return "Luggage [size=" + size + ", color=" + color + ", brand=" + brand + ", referenceNumber=" + referenceNumber + "]";
	    }
	}
    private Luggage[] luggageList;
    private int index;
    private static SaveFlightData instance = null;

    private SaveFlightData() {
        luggageList = new Luggage[10];
        index = 0;
    }

    public static SaveFlightData getInstance() {
        if (instance == null) {
            instance = new SaveFlightData();
        }
        return instance;
    }

    public int generatePaymentNum() {
        Random rand = new Random();
        return rand.nextInt(900000) + 100000; // Generates a random 6-digit number
    }

    public String generateReferenceNum() {
        Random rand = new Random();
        int refNum = rand.nextInt(999999);
        return String.format("%06d", refNum);
    }
    
    public void processTransactions(int generatedPaymentNum) {
        Scanner scan = new Scanner(System.in);

        int enteredPaymentNum;
        int size;
        String color = "";
        String brand;
        int control;

        System.out.println("Hello! Would you like to enter a Luggage check in? (0 = Yes, 1 = No)");
        control = scan.nextInt();

        while (control == 0) {
            System.out.println("Your generated payment number is: " + generatedPaymentNum);
            System.out.println("Please enter your payment number:");
            enteredPaymentNum = scan.nextInt();

            while (enteredPaymentNum != generatedPaymentNum || String.valueOf(enteredPaymentNum).length() != 6) {
                System.out.println("Invalid payment number. Please enter the correct 6-digit payment number:");
                enteredPaymentNum = scan.nextInt();
            }

            System.out.println("Enter luggage details - Weight(Lbs), Color, Brand:");
            size = scan.nextInt();
            
            if (size > 50) { // Checking if luggage weight exceeds 50 pounds
                double extraWeight = size - 50; // Calculating extra weight
                double extraFee = 25.0; // Setting extra fee
                
                // Displaying information about extra weight and charge
                System.out.println("Your luggage weight exceeds 50 pounds.");
                System.out.println("You have an extra weight of " + extraWeight + " pounds.");
                System.out.println("You will be charged an extra fee of $" + extraFee + ".");
            } else {
                // Displaying message if luggage weight is within the limit
                System.out.println("Your luggage is within the weight limit. No extra charges apply.");
            }
                
            System.out.println(" Color?");
            color = scan.next();
            System.out.println(" Brand?");
            brand = scan.next();

            Luggage luggage = new Luggage(size,color,brand, generateReferenceNum());
            luggageList[index] = luggage;
            index++;

            System.out.println("Thank you, your reference number is: " + luggage.referenceNumber);
        }
    }//end processTransactions
}//end SaveFlightData
