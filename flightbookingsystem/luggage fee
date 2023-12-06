package flight;
import java.util.Scanner;

public class LuggageChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Welcome message and input prompt
        System.out.println("Welcome to the Flight Tracking and Booking website!");
        System.out.print("Please enter the weight of your luggage in pounds: ");
        
        double luggageWeight = scanner.nextDouble(); // Reading user input for luggage weight

        if (luggageWeight > 50) { // Checking if luggage weight exceeds 50 pounds
            double extraWeight = luggageWeight - 50; // Calculating extra weight
            double extraFee = 25.0; // Setting extra fee
            
            // Displaying information about extra weight and charge
            System.out.println("Your luggage weight exceeds 50 pounds.");
            System.out.println("You have an extra weight of " + extraWeight + " pounds.");
            System.out.println("You will be charged an extra fee of $" + extraFee + ".");
        } else {
            // Displaying message if luggage weight is within the limit
            System.out.println("Your luggage is within the weight limit. No extra charges apply.");
        }

        scanner.close(); // Closing scanner
    }
}
