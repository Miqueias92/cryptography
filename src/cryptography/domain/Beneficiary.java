package cryptography.domain;

// encapusulamento
// public
// protected
// private

public class Beneficiary {
	private String name;
	private String motherName;
	private String cpf;
	
	public Beneficiary(String name, String motherName, String cpf) {
		this.name = name;
		this.motherName = motherName;
		this.cpf = cpf;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public String getMotherName() {
		return motherName;
	}

	public String getCpf() {
		return cpf;
	}
}
