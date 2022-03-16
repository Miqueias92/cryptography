package cryptography.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import cryptography.algorithms.CryptographyAES;
import cryptography.algorithms.CryptographyCamellia;
import cryptography.algorithms.CryptographyDES;
import cryptography.algorithms.CryptographyRCA;
import cryptography.domain.Beneficiary;
import cryptography.repository.Repository;

public class Service {
	
	private Repository repository;
	
	public Service() {
		this.repository = new Repository();
	}
	
	public List<Beneficiary> findAll() {
		return this.repository.findAll();
	}
	
	public List<Beneficiary> encriptyAES(List<Beneficiary> list) throws NoSuchAlgorithmException {
		return CryptographyAES.encrypt(list);
	}
	
	public List<Beneficiary> decriptyAES(List<Beneficiary> list) throws NoSuchAlgorithmException {
		return CryptographyAES.decrypt(list);
	}
	
	public List<Beneficiary> encriptyDES(List<Beneficiary> list) throws NoSuchAlgorithmException {
		return CryptographyDES.encrypt(list);
	}
	
	public List<Beneficiary> decriptyDES(List<Beneficiary> list) throws NoSuchAlgorithmException {
		return CryptographyDES.decrypt(list);
	}
	
	public List<Beneficiary> encriptyRCA(List<Beneficiary> list) throws NoSuchAlgorithmException {
		return CryptographyRCA.encrypt(list);
	}
	
	public List<Beneficiary> decriptyRCA(List<Beneficiary> list) throws NoSuchAlgorithmException {
		return CryptographyRCA.decrypt(list);
	}
	
	public List<Beneficiary> encriptyCamellia(List<Beneficiary> list) throws NoSuchAlgorithmException {
		return CryptographyCamellia.encrypt(list);
	}
	
	public List<Beneficiary> decriptyCamellia(List<Beneficiary> list) throws NoSuchAlgorithmException {
		return CryptographyCamellia.decrypt(list);
	}
}
