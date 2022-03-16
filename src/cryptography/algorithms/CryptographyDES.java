package cryptography.algorithms;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import cryptography.domain.Beneficiary;

public class CryptographyDES {
	
	public static final String ALGORITHM = "DES/ECB/PKCS5Padding";
	private static SecretKey key;
	
	static {
		try {
			key = generateKey();
		} catch (NoSuchAlgorithmException e) {}	
	}
	
	public static SecretKey generateKey() throws NoSuchAlgorithmException {
	    KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
	    SecretKey key = keyGenerator.generateKey();
	    return key;
	}
	
	public static List<Beneficiary> encrypt(List<Beneficiary> list) throws NoSuchAlgorithmException {
		
		list.forEach(beneficiary -> {
			try {
				String cipherName = encrypt(ALGORITHM, beneficiary.getName(), key);
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
				String plainText = decrypt(ALGORITHM, beneficiary.getName(), key);
				beneficiary.setName(plainText);
			} catch (InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException
					| InvalidAlgorithmParameterException | BadPaddingException | IllegalBlockSizeException e) {
				e.printStackTrace();
			}
		});
		return list;
	}
	
	public static String encrypt(String algorithm, String input, SecretKey key)
			throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
			InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] cipherText = cipher.doFinal(input.getBytes());
		return Base64.getEncoder().encodeToString(cipherText);
	}
	
	public static String decrypt(String algorithm, String cipherText, SecretKey key)
			throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
			InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(cipherText));
		return new String(plainText);
	}
}
