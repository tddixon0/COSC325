//Tim

package testing;

import java.util.List;
import java.util.ArrayList;

public class userSeatSelection {

	private int seatNum;
	private boolean occupied;
	private double price;
	private List<Integer> groupSeat;
	private static userSeatSelection[] seats;

	
	//constructor
	public userSeatSelection(int seatNum, double price) {
		this.seatNum = seatNum;
		this.occupied = false;
		this.price = price;
		this.groupSeat = new ArrayList<>();
	}
	
	
	public int getseatNum() {
		return seatNum;
	}
	
	public static void setSeats(userSeatSelection[] seatArray) {
        seats = seatArray;
    }
	
	public boolean occupied() {
		return occupied;
	}
	
	//price methods
	
	public double getPrice() {
		return price;
	}
	
	 public double getgroupPrice() {
	        double groupPrice = getPrice();
	        for (int seatNum : groupSeat) {
	            groupPrice += seats[seatNum - 1].getPrice();
	        }
	        return groupPrice;
	    }
	
	
	///letting users select and un-select seats  
	 
	
	public void occupy() {
		occupied = true;
	}
	
	public void vacate() {
		occupied = false;
	}
	
	
	///group selection
	
	public List<Integer> getgroupSeat(){
		return groupSeat;
	}
	
	public void addtoGroup(int seatNum) {
		groupSeat.add(seatNum);
	}
	
	
	//display seat situation
	
	public void displaySetting() {
		System.out.print("Seat " + seatNum +  " availability:");
		if(occupied()) {
			System.out.print("X ");
		} else {
			System.out.print("O ");
		}
		System.out.println();
	}
	
	///current seat display
	
	public void display() {
        System.out.println("Seat " + seatNum + " is occupied: " + (occupied));
        if (!groupSeat.isEmpty()) {
            System.out.println("  Group seats: " + groupSeat);
            System.out.println("Total Price: $ " + getgroupPrice());
        }
        System.out.println("Price for Seat Selected: $ " + getPrice());
        System.out.println();
    }
	
	
	
	
	
	
	
}
