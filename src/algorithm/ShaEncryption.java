package algorithm;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Hashtable;

public class ShaEncryption {
	private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
	
	public static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for (int j = 0; j < bytes.length; j++) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = HEX_ARRAY[v >>> 4];
	        hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
	    }
	    return new String(hexChars).toLowerCase();
	}
	
	public static String sha256(String base) {
	    try{
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hash = digest.digest(base.getBytes("UTF-8"));
	        return bytesToHex(hash);
	    } catch(Exception ex){
	       throw new RuntimeException(ex);
	    }
	}
	
	
	
	public static String sha256Decription(String code, Hashtable<String, String> codeTable) {
		if(codeTable.containsKey(code)) {
			return codeTable.get(code);
		}
		else
		{return null;}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(ShaEncryption.sha256("foo"));

	}

}