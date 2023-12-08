
	import java.util.Scanner;

class feedback {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        
        // Welcome message for the Flight Tracking and Booking Website
        System.out.println("Thank you for choosing the Flight Tracking and Booking Website!");
        System.out.println("Please provide your feedback:");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Feedback: ");
        String feedback = scanner.nextLine();

        // Display a thank you message along with the received feedback
        System.out.println("\nThank you for your feedback, " + name + "!");
//        System.out.println("Email: " + email);
        System.out.println("You said: " + feedback);
System.out.println("Your feedback is valued. ");

        // You can add code here to save the feedback to a database or file
        // This is where you'd typically store the feedback for future analysis
    }
}