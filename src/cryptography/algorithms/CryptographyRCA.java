package cryptography.algorithms;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import cryptography.domain.Beneficiary;

public class CryptographyRCA {	
	
	private static char[] key;
    private static int[] sbox;
    private static final int SBOX_LENGTH = 256;
    private static final int TAM_MIN_CHAVE = 5;
	
	static {
		try {
			key = generateKey("ARCAuVWDzV");
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} 
	}
	
	public static List<Beneficiary> encrypt(List<Beneficiary> list) throws NoSuchAlgorithmException {
			
		list.forEach(beneficiary -> {
			try {
				char [] cipherName = encrypt(beneficiary.getName());
				beneficiary.setName(new String(cipherName));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return list;
	}
	
	public static List<Beneficiary> decrypt(List<Beneficiary> list) throws NoSuchAlgorithmException {
				
		list.forEach(beneficiary -> {
			try {
				char[] plainText = decrypt(beneficiary.getName());
				beneficiary.setName(new String(plainText));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return list;
	}
		
	public static char[] encrypt(String input){
		final char[] msg = input.toCharArray();
		sbox = initSBox(key);
        char[] code = new char[msg.length];
        int i = 0;
        int j = 0;
        for (int n = 0; n < msg.length; n++) {
            i = (i + 1) % SBOX_LENGTH;
            j = (j + sbox[i]) % SBOX_LENGTH;
            swap(i, j, sbox);
            int rand = sbox[(sbox[i] + sbox[j]) % SBOX_LENGTH];
            code[n] = (char) (rand ^ (int) msg[n]);
        }
        return code;
	}
	
	public static char[] decrypt(String cipherText) {
		return encrypt(cipherText);
	}
	
	private static int[] initSBox(char[] key) {
        int[] sbox = new int[SBOX_LENGTH];
        int j = 0;

        for (int i = 0; i < SBOX_LENGTH; i++) {
            sbox[i] = i;
        }
        for (int i = 0; i < SBOX_LENGTH; i++) {
            j = (j + sbox[i] + key[i % key.length]) % SBOX_LENGTH;
            swap(i, j, sbox);
        }
        return sbox;
    }
	
	private static void swap(int i, int j, int[] sbox) {
        int temp = sbox[i];
        sbox[i] = sbox[j];
        sbox[j] = temp;
    }
	
	public static char[] generateKey(String key) throws InvalidKeyException {
		if (!(key.length() >= TAM_MIN_CHAVE && key.length() < SBOX_LENGTH)) {
            throw new InvalidKeyException("Tamanho da chave deve ser entre "
                    + TAM_MIN_CHAVE + " e " + (SBOX_LENGTH - 1));
        }
        return key.toCharArray();
	}
}