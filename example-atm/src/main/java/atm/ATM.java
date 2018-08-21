package atm;

import java.time.LocalDate;

public class ATM {
	
	private String lastErrorMessage;
	private boolean cardInAtm = false;
	private Account account;

	
	public void bankCardInserted(String bankName, LocalDate expiryDate) {
		cardInAtm = true;
		BankCard bankCard = new BankCard();
		if(!bankCard.checkName(bankName) || !bankCard.checkExpiryDate(expiryDate)) {
			lastErrorMessage = "Error!\n\nInvalid bank or card expired!";
			returnCard();
		}
	}
	
	public void creditCardInserted(double cardNumber) {
		cardInAtm = true;
		CreditCard creditCard = new CreditCard();
		if(!creditCard.checkCard(cardNumber)) {
			if(creditCard.getDisabled() == true) {
				lastErrorMessage = "Error! Card Disabled. Please contact your bank.";
			} else {
				lastErrorMessage = "Error!\n\nYour credit card number is invalid!";
			}
			returnCard();
		}
	}
	
	private void returnCard() {
		cardInAtm = false;
	}
	
	public boolean getCardInAtm() {
		return cardInAtm;
	}
	
	public String getLastErrorMessage() {
		return lastErrorMessage;
	}
	
	public void clearErrorMessages() {
		lastErrorMessage = null;
	}

//############################## Basic Actions ################################
	
	public void newAccount() {
		account = new Account();
	}
	
	public boolean checkPIN(int PIN) {
		return account.checkPIN(PIN);
	}
	
	public void setBalance(int balance) {
		account.setBalance(balance);
	}
	
	public void withdraw(int amount) {
		account.withdraw(amount);
	}
	
	public int getDepositSlot() {
		return account.getDepositSlot();
	}
	
	public int getBalance() {
		return account.getBalance();
	}

}

















