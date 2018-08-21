package atm;

public class Account {
	private int balance;
	private int depositSlot = 0;
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public boolean checkPIN(int PIN) {
		if(PIN % 4 == 0) return true;
		else return false;
	}
	
	public void withdraw(int amount) {
		if(balance >= amount) {
			balance -= amount;
			depositSlot = amount;
		}
	}
	
	public int getDepositSlot() {
		return depositSlot;
	}
	
	public int getBalance() {
		return balance;
	}
}
