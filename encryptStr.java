package testing;

public class encryptStr {

	public static void encrypterStr(String message) {
	
		int secretKey = 23; //we can change if needed
		
		char[] chars = message.toCharArray();  // adding each character into an array
		
		for(char newMessage : chars) {
			newMessage += secretKey; //shifting by key
			System.out.println(newMessage);  //encrypted message
		
			
		}
		
	}
	
	
	public static void decrypterStr(String encMessage) {
		
		int secretKey = 23; //has to be the same as encrypted key
		
		char[] chars = encMessage.toCharArray();
		
		for(char newMessage : chars) {
			newMessage -= secretKey;  //reversing the shift
			System.out.println(newMessage);
		
			
		}
		
	}
	
}
