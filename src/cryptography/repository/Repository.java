package cryptography.repository;

import java.util.List;

import cryptography.database.DatabaseMemory;
import cryptography.domain.Beneficiary;

public class Repository {

	public Repository() {
		this.addAll();
	}
	
	public void addAll(){
		
		for (int i=0; i<1; i++) {
			var beneficiary1 = new Beneficiary("Miqueias Santos", "Eliete", "712378123");
			DatabaseMemory.beneficiaryList.add(beneficiary1);
			
			var beneficiary2 = new Beneficiary("Miqueias Santos Sousa Assad"+(i+1), "Eliete", "712378123");
			DatabaseMemory.beneficiaryList.add(beneficiary2);
			// var beneficiary = new Beneficiary("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."+(i+1), "Eliete", "712378123");
			// DatabaseMemory.beneficiaryList.add(beneficiary);
		}
	}
	
	public List<Beneficiary> findAll() {
		return DatabaseMemory.beneficiaryList;
	}
}
