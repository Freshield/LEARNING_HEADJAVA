package chp15_5;

public class BankAccount {
	
	private int balance = 90;
	
	public int getBalance(){
		return balance;
	}
	
	public void withdraw(int amount){
		balance = balance - amount;
	}

}
