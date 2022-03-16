package cryptography.algorithms;

import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Base64;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import cryptography.domain.Beneficiary;

public class CryptographyAES {	

	public static final String ALGORITHM = "AES/CBC/PKCS5Padding";
	private static SecretKey key;
	private static IvParameterSpec ivParameterSpec;
	
	static {
		try {
			key = generateKey(128);
		} catch (NoSuchAlgorithmException e) {}
		
		ivParameterSpec = generateIv();	
	}
	
	public static List<Beneficiary> encrypt(List<Beneficiary> list) throws NoSuchAlgorithmException {
			
		list.forEach(beneficiary -> {
			try {
				String cipherName = encrypt(ALGORITHM, beneficiary.getName(), key, ivParameterSpec);
				beneficiary.setName(cipherName);
			} catch (InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException
					| InvalidAlgorithmParameterException | BadPaddingException | IllegalBlockSizeException e) {
				e.printStackTrace();
			}
		});
		return list;
	}
	
	public static List<Beneficiary> decrypt(List<Beneficiary> list) throws NoSuchAlgorithmException {
				
		list.forEach(beneficiary -> {
			try {
				String plainText = decrypt(ALGORITHM, beneficiary.getName(), key, ivParameterSpec);
				beneficiary.setName(plainText);
			} catch (InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException
					| InvalidAlgorithmParameterException | BadPaddingException | IllegalBlockSizeException e) {
				e.printStackTrace();
			}
		});
		return list;
	}
		
	public static String encrypt(String algorithm, String input, SecretKey key, IvParameterSpec iv)
			throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
			InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.ENCRYPT_MODE, key, iv);
		byte[] cipherText = cipher.doFinal(input.getBytes());
		return Base64.getEncoder().encodeToString(cipherText);
	}
	
	public static String decrypt(String algorithm, String cipherText, SecretKey key, IvParameterSpec iv)
			throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
			InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.DECRYPT_MODE, key, iv);
		byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(cipherText));
		return new String(plainText);
	}
	
	public static IvParameterSpec generateIv() {
	    byte[] iv = new byte[16];
	    new SecureRandom().nextBytes(iv);
	    return new IvParameterSpec(iv);
	}
	
	public static SecretKey generateKey(int n) throws NoSuchAlgorithmException {
	    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
	    keyGenerator.init(n);
	    SecretKey key = keyGenerator.generateKey();
	    return key;
	}
}