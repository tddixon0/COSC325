

import java.util.Scanner;

class changeflight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isBookingComplete = false;
        String bookedFlight = ""; // Placeholder for the booked flight

        System.out.println("Welcome to the Flight Tracking and Booking Website!");

        // Loop to display the menu until the user chooses to exit
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Book a Flight");
            System.out.println("2. Change Flight");
            System.out.println("3. Cancel Flight");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left by nextInt()

            // Switch case to handle user choices
            switch (choice) {
                case 1:
                    // Book a new flight
                    System.out.print("Enter the flight you want to book: ");
                    bookedFlight = scanner.nextLine();
                    System.out.println("Flight booked successfully: " + bookedFlight);
                    isBookingComplete = true;
                    break;
                case 2:
                    // Change booked flight if already booked
                    if (isBookingComplete) {
                        System.out.print("Enter the new flight you want to change to: ");
                        bookedFlight = scanner.nextLine();
                        System.out.println("Flight changed successfully to: " + bookedFlight);
                    } else {
                        System.out.println("No flight booked yet. Please book a flight first.");
                    }
                    break;
                case 3:
                    // Cancel booked flight if already booked
                    if (isBookingComplete) {
                        System.out.println("Flight cancelled: " + bookedFlight);
                        bookedFlight = ""; // Reset booked flight
                        isBookingComplete = false;
                    } else {
                        System.out.println("No flight booked yet. Please book a flight first.");
                    }
                    break;
                case 4:
                    // Exit the system
                    System.out.println("Thank you for using our Flight Tracking and Booking System!");
                    return;
                default:
                    // For invalid input
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
