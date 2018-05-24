import java.util.*;

public class CaeserCipher {
	static ArrayList<String> alphabets = new ArrayList<String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		populateAlpha();
		String test = "aesz";
		int key = 4;
		System.out.println("original message: " + test);
		test = encoding(test, key);
		System.out.println("encoded message: " + test);
		test = decoding(test, key);
		System.out.println("decoded message: " + test);
	}
	
	public static void populateAlpha() {
		//populate the alphabets array for global use
		int k = 0;
		for(int i = 0; i < 26; i++) {
			alphabets.add(Character.toString((char)(97 + (k++))));
		}
	}
	
	public static String encoding(String message, int key) {
		//split message elements into an array
		String[] messageSplit = message.split("");
		for(int i = 0; i < messageSplit.length; i++) {
			//use brute force, match elements
			for(int j = 0; j < alphabets.size(); j ++) {
				if(messageSplit[i].equals(alphabets.get(j))) {
					//match has been found perform swap of letters
					//perform correction when the new_encode is over the limit
					int new_encode = j + key;
					if(new_encode > alphabets.size()-1) {
						new_encode = (new_encode % (alphabets.size()-1)) - 1;
					}
					messageSplit[i] = alphabets.get(new_encode);
					//break loop when letter has been swapped
					break;
				}
			}
		}
		return String.join("", messageSplit);
	}
	
	public static String decoding(String message, int key) {
		//split message elements into an array
		String[] messageSplit = message.split("");
		for(int i = 0; i < messageSplit.length; i++) {
			//use brute force, match elements
			for(int j = 0; j < alphabets.size(); j ++) {
				if(messageSplit[i].equals(alphabets.get(j))) {
					//match has been found perform decode of letters
					//perform correction when the new_decode is over the limit
					int new_decode = j - key;
					if(new_decode < 0) {
						new_decode = alphabets.size() + new_decode;
					}
					messageSplit[i] = alphabets.get(new_decode);
					//break loop when letter has been swapped
					break;
				}
			}
		}
		return String.join("", messageSplit);
	}
}
