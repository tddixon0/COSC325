package flightbookingsystem;

import java.util.*;
class FlightBooking {
    private String bookingId;
    private String flightNumber;
    private String departureDate;

    public FlightBooking(String bookingId, String flightNumber, String departureDate) {
        this.bookingId = bookingId;
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
    }

    public String getBookingDetails() {
        return "Booking ID: " + bookingId + ", Flight Number: " + flightNumber + ", Departure Date: " + departureDate;
    }
}

class UserAccount {
    private String accountId;
    private List<FlightBooking> bookingHistory;

    public UserAccount(String accountId) {
        this.accountId = accountId;
        this.bookingHistory = new ArrayList<>();
    }

    public void addBookingToHistory(FlightBooking booking) {
        this.bookingHistory.add(booking);
    }

    public List<FlightBooking> getBookingHistory() {
        return bookingHistory;
    }

    public String getAccountId() {
        return accountId;
    }
}

public class savehistory {
    public static void main(String[] args) {
        // Example usage
        UserAccount userAccount = new UserAccount("user123");
        FlightBooking booking1 = new FlightBooking("B001", "ABC123", "2023-01-15");
        FlightBooking booking2 = new FlightBooking("B002", "XYZ789", "2023-02-20");

        userAccount.addBookingToHistory(booking1);
        userAccount.addBookingToHistory(booking2);

        List<FlightBooking> bookingHistory = userAccount.getBookingHistory();
        System.out.println("Booking History for User ID " + userAccount.getAccountId() + ":");
        for (FlightBooking booking : bookingHistory) {
            System.out.println(booking.getBookingDetails());
        }
    }
}
