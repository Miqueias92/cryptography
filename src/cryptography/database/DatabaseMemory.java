package cryptography.database;

import java.util.ArrayList;
import java.util.List;

import cryptography.domain.Beneficiary;

public class DatabaseMemory {
	
	public static List<Beneficiary> beneficiaryList;
	
	static {
		beneficiaryList = new ArrayList<>();
	}
}
