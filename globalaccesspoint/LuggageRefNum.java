//Gavin

package globalaccesspoint;
import java.util.Random;
import java.util.Scanner;

public class LuggageRefNum {

    private static LuggageRefNum instance;

    private class Luggage {
        private String size;
        private String color;
        private String brand;
        private String referenceNumber;

        public Luggage(String size, String color, String brand, String referenceNumber) {
            this.size = size;
            this.color = color;
            this.brand = brand;
            this.referenceNumber = referenceNumber;
        }

        @Override
        public String toString() {
            return "Size: " + size + ", Color: " + color + ", Brand: " + brand + ", Reference Number: " + referenceNumber;
        }
    }

    private Luggage[] luggageList;
    private int index;

    private LuggageRefNum() {
        luggageList = new Luggage[10];
        index = 0;
    }

    public static LuggageRefNum getInstance() {
        if (instance == null) {
            instance = new LuggageRefNum();
        }
        return instance;
    }

    public String generateReferenceNum() {
        Random rand = new Random();
        int refNum = rand.nextInt(999999);
        return String.format("%06d", refNum);
    }

    public void processTransactions() {
        Scanner scan = new Scanner(System.in);

        int transNum;
        String size, color, brand;
        int control;

        System.out.println("Type 0 to start and 1 to exit?");
        control = scan.nextInt();

        while (control == 0) {
            System.out.println("Thank you, enter your payment number:");
            transNum = scan.nextInt();

            while (String.valueOf(transNum).length() != 6) {
                System.out.println("Payment number must be at least 6 digits. Please try again.");
                transNum = scan.nextInt();
            }

            System.out.println("Enter luggage details - size, color, brand:");
            size = scan.next();
            color = scan.next();
            brand = scan.next();

            Luggage luggage = new Luggage(size, color, brand, generateReferenceNum());
            luggageList[index] = luggage;
            index++;

            System.out.println("Thank you, your payment number is " + transNum + " and your reference number is listed below:");
            System.out.println(luggage.referenceNumber);

            System.out.println("Press 0 to continue, 1 to exit the program:");
            control = scan.nextInt();
        }

        System.out.println("Generated Luggage Information:");
        for (int i = 0; i < index; i++) {
            System.out.println(luggageList[i]);
        }
    }

    public static void main(String[] args) {
        LuggageRefNum globalAccessPoint = LuggageRefNum.getInstance();
        globalAccessPoint.processTransactions();
    }
}
