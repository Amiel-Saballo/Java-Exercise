package secondexercise;
import firstexercise.BankAccount;

public interface Bank {
    /**
     * Adds a new bank account to the bank.
     * @param account
     * The bank account to be added.
     */
    void addAccount(BankAccount account);
    /**
     * Removes a bank account from the bank by its ID.
     * @param id
     * The ID of the bank account to be removed.
     * @return
     * True if the bank account was successfully removed, false otherwise.
     */
    BankAccount getAccount(int id);

}
