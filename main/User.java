package main;
//public class User {
//		int a = 001;
//		int b = 002;
//		int c = 003;
//		int d = 004;
//		int e = 005;
//		
//	public static void main(String[] args) {
//		makeUser();
//	}//end User
//	
//	public static void makeUser() {
//		User user1 = new User();  //creates user1 object
//	    User user2 = new User();
//	    User user3 = new User();
//	    User user4 = new User();
//	    User user5 = new User();
//	    System.out.println(user1.a);  //returns user ID#
//	    System.out.println(user2.b);
//	    System.out.println(user3.c);
//	    System.out.println(user4.d);
//	    System.out.println(user5.e);
//		
//	}//end makeUser
//
//}


 public class User
{
    private double startingMoney;
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    private static int count = 0; // number of objects in memory

    // initialize user, add 1 to static count and
     // output String indicating that constructor was called
     public User( String first, String last )
     {
        firstName = first;
        lastName = last;

        count++; // increment static count of Users
        System.out.printf( "User constructor: %s %s; count = %d\n",
           firstName, lastName, count );
     } // end User constructor

     //another constructor 
     public User( String first, String last, String name, String pass)
     {
        firstName = first;
        lastName = last;
        username = name;
        password = pass;

        count++; // increment static count of Users
        System.out.printf( "User constructor: %s %s; count = %d\n",
           firstName, lastName, count );
     } // end User constructor


     // subtract 1 from static count when garbage
     // collector calls finalize to clean up object;
     // confirm that finalize was called
     protected void finalize()
     {
        count--; // decrement static count of users
        System.out.printf( "User finalizer: %s %s; count = %d\n",
           firstName, lastName, count );
     } // end method finalize






     public String getStartingName()
     {
        return getStartingName();
     } // end method getstartingName


    // get username
     public String getUserName()
     {
        return username;
     } // end method getUserName

     // get password
     public String getPassword()
     {
        return password;
     } // end method getPassword

    // get first name
     public String getFirstName()
     {
        return firstName;
     } // end method getFirstName

     // get last name
     public String getLastName()
     {
        return lastName;
     } // end method getLastName

     // static method to get static count value
     public static int getCount()              
     {                                         
        return count;                          
     } // end method getCount

}