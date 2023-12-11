
import java.io.*;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import testing.LuggageRefNum.Luggage;


public class LuggageRefNum {
	
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
	    
	    public String getReferenceNumber() {
	        return referenceNumber;
	    }
	    public String toString() {
	        return "Luggage [size=" + size + ", color=" + color + ", brand=" + brand + ", referenceNumber=" + referenceNumber + "]";
	    }
	}
    private Luggage[] luggageList;
    private int index;
    private static LuggageRefNum instance = null;

    private LuggageRefNum() {
        luggageList = new Luggage[10];
        index = 0;
    }

    public static LuggageRefNum getInstance() {
        if (instance == null) {
            instance = new LuggageRefNum();
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

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the city you want to go to: ");
        String keyword = scan.nextLine().trim().toLowerCase();  
        String file = "C:\\Users\\gavin\\eclipse-workspace\\flightt\\src\\flightt\\DepartureFlights.csv";

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

    public void processTransactions(int generatedPaymentNum) {
        Scanner scan = new Scanner(System.in);

        int enteredPaymentNum;
        int size;
        String color = "";
        String brand;
        int control;

        System.out.println("Hello! This is luggage check-in would you like to start? (0 = Yes, 1 = No)");
        control = scan.nextInt();

        while (control == 0) {
            System.out.println("Your payment number is: " + generatedPaymentNum);
            System.out.println("Please enter your payment number:");
            enteredPaymentNum = scan.nextInt();

            while (enteredPaymentNum != generatedPaymentNum || String.valueOf(enteredPaymentNum).length() != 6) {
                System.out.println("Invalid payment number. Please enter the correct 6-digit payment number:");
                enteredPaymentNum = scan.nextInt();
            }

            System.out.println("Enter luggage details - Weight(Lbs),Color,Brand:");
            System.out.println("Enter the weight of the luggage");
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
                
            System.out.println("Color of luggage?");
            color = scan.next();
            System.out.println("Brand of luggage?");
            brand = scan.next();

            Luggage luggage = new Luggage(size,color,brand, generateReferenceNum());
            luggageList[index] = luggage;
            index++;

            System.out.println("Thank you, your reference number is: " + luggage.referenceNumber);

            System.out.println("If you would like to register another bag press 0, if not press 1");
            control = scan.nextInt();
        }

        System.out.println("User Luggage Information:");
        for (int i = 0; i < index; i++) {
            System.out.println(luggageList[i]);
            System.out.println("Thank you! Your luggage is being loaded onto the plane");
        }


        searchLuggageByReferenceNumber(); }

        public void searchLuggageByReferenceNumber() {
            Scanner scan = new Scanner(System.in);
            System.out.println("If you would like to see the luggage you have brought type in your reference number:");
            int refNum = scan.nextInt();
            String refNumStr = Integer.toString(refNum);  

            for (Luggage luggage : luggageList) {
                if (luggage.getReferenceNumber().equals(refNumStr)) {  
                    System.out.println(luggage);
                    return;
                }

        System.out.println("No luggage found with the provided reference number.");
    }
            

            }
<<<<<<< HEAD:flightt/LuggageRefNum.java

        
=======
    
>>>>>>> a879be3d0e31612dca5d5428d5209031a29f9392:LuggageRefNum.java
}
       




