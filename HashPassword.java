

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//import java.util.Scanner;

public class HashPassword {
	
	/**
	 * generate hashing for the password that will be stored in the file
	 * 
	 * @param data input 
	 * @return null
	 */
	public static String generateHash(String data){
		try {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		digest.reset();
		byte[] hash = digest.digest(data.getBytes());
		return bytesToStringHex(hash);
		} catch (NoSuchAlgorithmException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
	
	/**
	 * converts bytes array to string hex
	 * 
	 * @param bytes 
	 * @return string hex 
	 */
	public static String bytesToStringHex(byte[] bytes) {
		char[] hexChars = new char[bytes.length * 2];
		for(int j = 0; j < bytes.length; j++) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}
}
