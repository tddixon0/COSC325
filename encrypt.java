package testing;

public class encrypt {

	public int encrypter(int id) {
		
		int secretKey = 23;  //can changed
		return id ^ secretKey;
		
	}
	
	public int decrypter(int encrypted) {
		
		int secretKey = 23; //has to be the same
		return encrypted ^ secretKey;
	}
	 
	
}
