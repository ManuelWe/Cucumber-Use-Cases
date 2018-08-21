package atm;

public class CreditCard {
	private boolean disabled = true;
	private double disabledCards[] = {568372146, 985647258, 236547100, 253685471};
	
	public boolean checkCard(double cardNumber) {
		for(int i=0; i<disabledCards.length; i++) {
			if(disabledCards[i] == cardNumber) {
				disabled = true;
				return false;
			}
		}
		if(String.format("%.0f", cardNumber).matches("\\d{9}") == false) {
			disabled = false;
			return false;
		}
		disabled = false;
		return true;
	}
	
	public boolean getDisabled() {
		return disabled;
	}
}
