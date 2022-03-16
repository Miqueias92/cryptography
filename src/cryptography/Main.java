package cryptography;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import cryptography.domain.Beneficiary;
import cryptography.service.Service;

public class Main {
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		 
		Service service = new Service();
		List<Beneficiary> list = service.findAll();
		
		System.out.println("ANALISE DE DESEMPENHO EM MILISEGUNDOS PARA: " + list.size() + "\n");
		
		// AES
		cryptographyAES(service, list);
		
		// DES
		cryptographyDES(service, list);
		
		// RCA
		cryptographyRCA(service, list);
		
		// Camellia
		cryptographyCamellia(service, list);
	}
	
	public static void cryptographyAES(Service service, List<Beneficiary> list) throws NoSuchAlgorithmException {
		long encripty = System.currentTimeMillis();
		List<Beneficiary> listEncripty = service.encriptyAES(list); 
		System.out.println("### Tempo de criptografia do AES: " + (System.currentTimeMillis() - encripty));
		
		// printList(listEncripty);
		
		long decripty = System.currentTimeMillis();
		List<Beneficiary> listDencripty = service.decriptyAES(list);
		System.out.println("### Tempo de descriptografia do AES: " + (System.currentTimeMillis() - decripty));
		
		// printList(listDencripty);
		System.out.println("\n");
	}
	
	public static void cryptographyDES(Service service, List<Beneficiary> list) throws NoSuchAlgorithmException {
		long encripty = System.currentTimeMillis();
		List<Beneficiary> listEncripty = service.encriptyDES(list); 
		System.out.println("### Tempo de criptografia do DES: " + (System.currentTimeMillis() - encripty));
		
		// printList(listEncripty);
		
		long decripty = System.currentTimeMillis();
		List<Beneficiary> listDencripty = service.decriptyDES(list);
		System.out.println("### Tempo de descriptografia do DES: " + (System.currentTimeMillis() - decripty));
		
		// printList(listDencripty);
		System.out.println("\n");
	}
	
	public static void cryptographyRCA(Service service, List<Beneficiary> list) throws NoSuchAlgorithmException {
		long encripty = System.currentTimeMillis();
		List<Beneficiary> listEncripty = service.encriptyRCA(list); 
		System.out.println("### Tempo de criptografia do RCA: " + (System.currentTimeMillis() - encripty));
		
		// printList(listEncripty);
		
		long decripty = System.currentTimeMillis();
		List<Beneficiary> listDencripty = service.decriptyRCA(list);
		System.out.println("### Tempo de descriptografia do RCA: " + (System.currentTimeMillis() - decripty));
		
		// printList(listDencripty);
		System.out.println("\n");
	}
	
	public static void cryptographyCamellia(Service service, List<Beneficiary> list) throws NoSuchAlgorithmException {
		long encripty = System.currentTimeMillis();
		List<Beneficiary> listEncripty = service.encriptyCamellia(list); 
		System.out.println("### Tempo de criptografia do Camellia: " + (System.currentTimeMillis() - encripty));
		
		// printList(listEncripty);
		
		long decripty = System.currentTimeMillis();
		List<Beneficiary> listDencripty = service.decriptyCamellia(list);
		System.out.println("### Tempo de descriptografia do Camellia: " + (System.currentTimeMillis() - decripty));
		
		// printList(listDencripty);
		System.out.println("\n");
	}
	
	public static void printList(List<Beneficiary> list) {
		list.forEach(b -> {
			System.out.println("name: " + b.getName());
		});
	}
}
