package secondexercise;
import firstexercise.BankAccount;

public interface Bank {
	void addAccount(BankAccount account);
	BankAccount getAccount(int id);

}
