package util;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Date;

public class SHA256 {
	
	private static final String salt = "감자튀김";
	
	private SHA256() {}
	
	public static String encodeSHA256(String password) {
		String result="";
		
		try {
			byte[] saltByte = salt.getBytes();
			byte[] passwordByte = password.getBytes("utf-8");
			
			
			byte[] saltPassword = new byte[saltByte.length + passwordByte.length];
			
			System.arraycopy(saltByte, 0, saltPassword, 0, saltByte.length);
			System.arraycopy(passwordByte, 0, saltPassword, saltByte.length, passwordByte.length);
			
			//Digest 요약임 -> 암호화를 한다는것  - 요약 
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			
			md.update(saltPassword);
			
			byte[] saltPasswordDigest=md.digest();
			
			StringBuffer sb = new StringBuffer();
			
			for(int i=0 ; i<saltPasswordDigest.length ; i++) {
				sb.append(Integer.toString((saltPasswordDigest[i]&0xFF)+0x100,16).substring(1));
			}
			
			result = sb.toString();
		}catch(Exception e) {
			System.out.println("[SHA256] 오류 encodeSHA256" + e);
		}
		
		System.out.println("[SHA256] 오류 encodeSHA256" + result);
		
		return result;
	}
	
	public static String getRandomPassword(int size) {
		
		char[] charSet = {
				
		};
		
		StringBuffer sb = new StringBuffer();
		
		SecureRandom sr = new SecureRandom();
		sr.setSeed(new Date().getTime());
		
		int len = charSet.length;
		int idx = 0;
		for (int i = 0 ; i<size ; i++) {
			
			idx = sr.nextInt(charSet.length);
			sb.append(charSet[idx]);
		}
		
		return sb.toString();
	}
}
