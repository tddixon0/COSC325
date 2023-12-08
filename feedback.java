
	import java.util.Scanner;

class feedback {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        
        // Welcome message for the Flight Tracking and Booking Website
        System.out.println("Welcome to the Flight Tracking and Booking Website!");
        System.out.println("Please provide your feedback:");

        // Ask the user for their name, email, and feedback
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Feedback: ");
        String feedback = scanner.nextLine();

        // Display a thank you message along with the received feedback
        System.out.println("\nThank you for your feedback, " + name + "!");
        System.out.println("Feedback received: ");
        System.out.println("Email: " + email);
        System.out.println("Feedback: " + feedback);

        // You can add code here to save the feedback to a database or file
        // This is where you'd typically store the feedback for future analysis
    }
}