package com.twd.flutter.android.constant;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import com.google.api.client.util.Base64;

public class SecurityUtil {

	public static String encrypt(String pass, String key){
		String passencrypt = "";
		try {
			Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
			Cipher cipher;
			cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
			byte[] encrypted = cipher.doFinal(pass.getBytes());
			byte[] bytesEncoded = Base64.encodeBase64(encrypted);
			passencrypt = new String(bytesEncoded);
			//System.err.println(new String(encrypted));
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		return passencrypt;
		
	}
	
	public static String dencrypt(String encryptedVal, String key){
		String passdencrypt = "";
		try {
			Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
			Cipher cipher;
			cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, aesKey);
			byte[] bytesEncoded = Base64.decodeBase64(encryptedVal.getBytes());
			byte[] encrypted = cipher.doFinal(bytesEncoded);
			passdencrypt = new String(encrypted);
			//System.err.println(new String(encrypted));
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		return passdencrypt;
		
	}
	
public static void main(String[] args) {
	//System.out.println(encrypt("123456","3wdsoftware@137."));
}


}
