package firstexercise;

import java.util.List;

import secondexercise.BankAccountManager;
import secondexercise.Transaction;

public class BankAccount {

	private double balance;
	private boolean isFrozen;
	private List<Transaction> transactionHistory; //Exercise 2
	
	//Exercise 2
	public BankAccount() {
		transactionHistory = new java.util.ArrayList<>();
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isFrozen() {
		return isFrozen;
	}

	public void setFrozen(boolean isFrozen) {
		this.isFrozen = isFrozen;
	}
	
	public void getTransactionHistory() {
		if (transactionHistory.isEmpty()) {
			System.out.println("No transactions found.");
		} else {
			System.out.println("Transaction History:");
			for (Transaction transaction : transactionHistory) {
				System.out.println(transaction);
			}
		}
	}

	public void deposit(double amount) {
		if (isFrozen()) {
			System.out.println("Account is FROZEN. Unable to transact.");
			return;
		} else if (amount > 0) {
			setBalance(getBalance() + amount);
			System.out.printf("Amount Deposited: %.2f%n", amount);
			System.out.printf("Current Balance: %.2f%n", getBalance());
			transactionHistory.add(new Transaction("Deposit", amount)); //Exercise 2
		} else {
			System.out.printf("Amount Deposited: %.2f%n", amount);
			System.out.println("Invalid deposit amount. Must be greater than 0.");
		}
	}
	
	public void withdraw(double amount) {
		if (isFrozen()) {
			System.out.println("Account is FROZEN. Unable to transact.");
			return;
		} else if (amount > 0 && amount <= getBalance()) {
			setBalance(getBalance() - amount);
			System.out.printf("Amount Withdrawn: %.2f%n", amount);
			System.out.printf("Current Balance: %.2f%n", getBalance());
			transactionHistory.add(new Transaction("Withdraw", amount)); //Exercise 2
		} else if (amount > getBalance()) {
			System.out.printf("Amount Withdrawn: %.2f%n", amount);
			System.out.printf("Insufficient funds. Current Balance: %.2f%n", getBalance());
		} else {
			System.out.printf("Amount Withdrawn: %.2f%n", amount);
			System.out.println("Invalid withdrawal amount. Must be greater than 0.");
			
		}
	}
	
	public void freezeAccount() {
		setFrozen(true);
//		System.out.println("Account has been frozen.");
	}
	
	public void unfreezeAccount() {
		setFrozen(false);
//		System.out.println("Account has been unfrozen.");
	}

 	//Exercise 1 - Test Cases
	public static void main(String[] args) {
		
		//Test Case: 1
		System.out.println("Test Case: 1");
		BankAccount acc1 = new SavingsAccount("Test0");
		System.out.println("Account Owner: " + ((SavingsAccount) acc1).getOwnerName());
		
		//Test Case: 2
		System.out.println("Test Case: 2");
		acc1.deposit(1000.125);
		
		//Test Case: 3
		System.out.println("Test Case: 3");
		acc1.deposit(0);
		
		//Test Case: 4
		System.out.println("Test Case: 4");
		acc1.deposit(-500);
		
		//Test Case: 5
		System.out.println("Test Case: 5");
		acc1.withdraw(500);
		
		//Test Case: 6
		System.out.println("Test Case: 6");
		acc1.withdraw(1500);
		
		//Test Case: 7
		System.out.println("Test Case: 7");
		acc1.withdraw(-100);

		//Test Case: 8
		System.out.println("Test Case: 8");
		acc1.freezeAccount();
		acc1.deposit(11500);
		
		//Test Case: 9
		System.out.println("Test Case: 9");
		acc1.withdraw(500);

		//Test Case: 10
		System.out.println("Test Case: 10");
		acc1.unfreezeAccount();
		acc1.withdraw(100);
		
		
		//Exercise 2
		System.out.println("=============================================");
		//Test Case: 1
		System.out.println("Test Case: 1");
		acc1.getTransactionHistory();
		
		//Test Case: 2
		System.out.println("Test Case: 2");
		BankAccountManager accM1 = new BankAccountManager();
		System.out.println("-");
		
		//Test Case: 3
		System.out.println("Test Case: 3");
		accM1.addAccount(acc1);
		
		//Test Case: 4
		System.out.println("Test Case: 4");
		accM1.addAccount(new SavingsAccount("Test1"));	
		
		//Test Case: 5
		System.out.println("Test Case: 5");
		accM1.listAccounts();

	}

}
