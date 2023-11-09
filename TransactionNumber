package thisisanewtest;

import java.util.Random;
import java.util.Scanner;

public class testanotherway {

	  public static String generateReferenceNum() {
	        Random rand = new Random();
	        int refNum = rand.nextInt(999999);
	        return String.format("%06d", refNum);
	    }

	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);

	        int transNum;
	        int control;

	        System.out.println("Type 0 to start and 1 to exit?");
	        control = scan.nextInt();

	      
	        String[] referenceNumbers = new String[10]; 

	        int index = 0;

	        while (control == 0) {
	            System.out.println("Thank you, enter your payment number:");
	            transNum = scan.nextInt();

	            while (String.valueOf(transNum).length() != 6) {
	                System.out.println("Payment number must be at least 6 digits. Please try again.");
	                transNum = scan.nextInt();
	            }

	            System.out.println("Thank you, your payment number is " + transNum + " and your reference number is listed below:");
	            String refNum = generateReferenceNum();
	            referenceNumbers[index] = refNum;
	            index++;

	            System.out.println(refNum);

	            System.out.println("Press 0 to continue, 1 to exit the program:");
	            control = scan.nextInt();
	        }

	    
	        System.out.println("Generated Reference Numbers:");
	        for (int i = 0; i < index; i++) {
	            System.out.println(referenceNumbers[i]);
	        }
	    }
	}
	}
