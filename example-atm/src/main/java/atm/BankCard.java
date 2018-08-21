package atm;

import java.time.LocalDate;

public class BankCard {
	
	private String validBanks[] = {"Deutsche Bank", "American bank", "White bank"};
	
	public boolean checkName(String bankName) {
		for(int i=0; i<validBanks.length; i++) {
			if(validBanks[i] == bankName) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkExpiryDate(LocalDate expiryDate) {
		if(expiryDate.compareTo(LocalDate.now()) >= 0) return true;
		else return false;
	}
}
