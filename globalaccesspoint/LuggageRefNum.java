//Gavin 
package fulltransactions;

import java.util.Random;
import java.util.Scanner;

public class finaltransactions {

    private static finaltransactions instance;

    private class Luggage {
        private int size;
        private String color;
        private String brand;
        private String referenceNumber;

        public Luggage(int size, String color, String brand, String referenceNumber) {
            this.size = size;
            this.color = color;
            this.brand = brand;
            this.referenceNumber = referenceNumber;
        }

        public String toString() {
            return "Size: " + size + ", Color: " + color + ", Brand: " + brand + ", Reference Number: " + referenceNumber;
        }
    }

    private Luggage[] luggageList;
    private int index;

    private finaltransactions() {
        luggageList = new Luggage[10];
        index = 0;
    }

    public static finaltransactions getInstance() {
        if (instance == null) {
            instance = new finaltransactions();
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

    public void processTransactions() {
        Scanner scan = new Scanner(System.in);

        int generatedPaymentNum = generatePaymentNum();
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

            System.out.println("Thank you, if you would like to register another bag press 0, if not press 1");
            control = scan.nextInt();
        }

        System.out.println("Generated Luggage Information:");
        for (int i = 0; i < index; i++) {
            System.out.println(luggageList[i]);  
          System.out.println("Your luggage is being loaded onto the plane");
        }
    }
  

    public static void main(String[] args) {
        finaltransactions globalAccessPoint = finaltransactions.getInstance();
        globalAccessPoint.processTransactions();
    }
}

