/**
Driver file & Main
/**
Public class Main {
  int a = 001; //set user ID number
  int b = 002;
  int c = 003;
  int d = 004;
  int e = 005;

  public static voic main(String[] args) {
    Main user1 = new Main();  //creates user1 object
    Main user2 = new Main();
    Main user3 = new Main();
    Main user4 = new Main();
    Main user5 = new Main();
    System.out.println(user1.a);  //returns user ID#
    System.out.println(user2.b);
    System.out.println(user3.c);
    System.out.println(user4.d);
    System.out.println(user5.e);

/////SEAT SELECTION EXAMPLE

   //creating an array of seats (change the number according to flight seats)
		//change base price
		
		userSeatSelection[] seats = new userSeatSelection[25];
		double basePrice = 5.0;
		userSeatSelection.setSeats(seats);
			
		
		//calculating price according to seat
		for(int i=0; i<seats.length; i++) {
			seats[i] = new userSeatSelection(i + 1, basePrice *(i+1));
		}
	
		
		//examples
		seats[8].occupy();
		seats[8].display();
		
		//group seat example
		seats[1].occupy();
                seats[2].occupy();
                seats[3].occupy();
                seats[1].addtoGroup(seats[2].getseatNum());
                seats[1].addtoGroup(seats[3].getseatNum());
                seats[1].display();
        
        
                ///example of seat not being occupied
                seats[10].display();
        
        
                ///display of all available seats
		for (userSeatSelection seat : seats) {
                seat.displaySetting();
               }


  } //end main
}//end Main
