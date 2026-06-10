package secondexercise;

import java.util.Map;

import firstexercise.BankAccount;
import firstexercise.SavingsAccount;

public class BankAccountManager implements Bank {
	
	private Map<Integer, BankAccount> accounts;
	private int id;

	public BankAccountManager() {
		accounts = new java.util.HashMap<>();
		id = 0;
	}
	
	@Override
	public void addAccount(BankAccount account) {
		accounts.put(id, account);
		System.out.printf("Account successfully added with ID: %d%n", id);
		id++;
	}

	@Override
	public BankAccount getAccount(int id) {
		return accounts.get(id);
	}
	
	public void listAccounts() {
        for (Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
            System.out.printf("Account ID: %d, Account Name: %s, Balance: %.2f%n", entry.getKey(), ((SavingsAccount) entry.getValue()).getOwnerName(), entry.getValue().getBalance());
        }
	}

}
