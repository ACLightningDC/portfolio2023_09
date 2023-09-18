package action.user.LoginCheck;

import java.util.Arrays;
import java.util.Random;

import org.apache.commons.codec.binary.Base32;

import vo.login.OTP;

public class OTPLoginCheck {

	public OTP CreateKey(String id, String ipAddress) {
		 // Allocating the buffer
//      byte[] buffer = new byte[secretSize + numOfScratchCodes * scratchCodeSize];
        byte[] buffer = new byte[10 + 10 * 10];
         
        // Filling the buffer with random numbers.
        // Notice: you want to reuse the same random generator
        // while generating larger random number sequences.
        new Random().nextBytes(buffer);
 
        // Getting the key and converting it to Base32
        Base32 codec = new Base32();
//      byte[] secretKey = Arrays.copyOf(buffer, secretSize);
        byte[] secretKey = Arrays.copyOf(buffer, 10);
        byte[] bEncodedKey = codec.encode(secretKey);
         
        // 생성된 Key!
        String encodedKey = new String(bEncodedKey);
         
        System.out.println("encodedKey : " + encodedKey);
         
//      String url = getQRBarcodeURL(userName, hostName, secretKeyStr);
        // userName과 S은 변수로 받아서 넣어야 하지만, 여기선 테스트를 위해 하드코딩 해줬다.

        String url = getQRBarcodeURL(id, ipAddress, encodedKey); // 생성된 바코드 주소!
        System.out.println("URL : " + url);
        
        OTP otp = new OTP(encodedKey , url);
         
        return otp ;
	}

	public String getQRBarcodeURL(String user, String host, String secret) {
       String format = "http://chart.apis.google.com/chart?cht=qr&amp;chs=300x300&amp;chl=otpauth://totp/%s@%s%%3Fsecret%%3D%s&amp;chld=H|0";
         
        return String.format(format, user, host, secret);
	}
}
