package testing;

import java.util.List;

public class Cart {
	
	private String usersFlight;
	private List<String> usersSeats;
	private String referenceNumber;
	private int paymentNumber;
	
	public Cart(String userFlight, List<String> userSeats, String referenceNumber, int paymentNumber) {
		
		this.usersFlight = usersFlight;
		this.usersSeats = usersSeats;
		this.referenceNumber = referenceNumber;
		this.paymentNumber = paymentNumber;
				
	}
	
	///setters and getters
		
	public String getUsersFlight() {
	    return usersFlight;
	}

	public List<String> getUsersSeats() {
	    return usersSeats;
	}

	public String getReferenceNumber() {
	    return referenceNumber;
	}

	public int getPaymentNumber() {
	    return paymentNumber;
	}
	
	public void setUsersFlight(String usersFlight) {
	    this.usersFlight = usersFlight;
	}

	public void setUsersSeats(List<String> userSeats) {
	    this.usersSeats = userSeats;
	}

	public void setReferenceNumber(String referenceNumber) {
	    this.referenceNumber = referenceNumber;
	}

	public void setPaymentNumber(int paymentNumber) {
	     this.paymentNumber = paymentNumber;
	}
		
	
	
	

}
