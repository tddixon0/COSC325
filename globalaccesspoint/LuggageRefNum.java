//Gavin 

 package globalaccesspoint;
import java.util.Random;
import java.util.Scanner;

public class luggage {

    private static luggage instance;

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

    private luggage() {
        luggageList = new Luggage[10];
        index = 0;
    }

    public static luggage getInstance() {
        if (instance == null) {
            instance = new luggage();
        }
        return instance;
    }

    public String generateReferenceNum() {
        Random rand = new Random();
        int refNum = rand.nextInt(999999);
        return String.format("%06d", refNum);
    }

    public void processTransactions() {
        Scanner scan = new Scanner(System.in);

        int PayNum;
        int size;
        String color, brand;
        int control;

        System.out.println("Hello hope all is well! Would you like to enter a reference number ( 0 = Yes, 1 = No)");
        control = scan.nextInt();

        while (control == 0) {
            System.out.println("Thank you, please enter your payment number:");
            PayNum = scan.nextInt();

            while (String.valueOf(PayNum).length() != 6) {
                System.out.println("Payment number must be at least 6 digits. Please try again.");
                PayNum = scan.nextInt();
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
            color = scan.next();
            brand = scan.next();

            Luggage luggage = new Luggage(size, color, brand, generateReferenceNum());
            luggageList[index] = luggage;
            index++;

            System.out.println("Thank you, the payment number entered was " + PayNum + " your reference number is listed below:");
            System.out.println(luggage.referenceNumber);

            System.out.println(" Thank you, if you would like to register another bag press 0 if not press 1");
            control = scan.nextInt();
        }

        System.out.println("Generated Luggage Information:");
        for (int i = 0; i < index; i++) {
            System.out.println(luggageList[i]);
        }
    }

    public static void main(String[] args) {
        luggage globalAccessPoint = luggage.getInstance();
        globalAccessPoint.processTransactions();
    }
}
