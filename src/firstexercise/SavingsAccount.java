package firstexercise;

public class SavingsAccount extends BankAccount {

    /**
     * The name of the owner of the savings account.
     */
    private String ownerName;

    /**
     * Constructs a new SavingsAccount object with the specified owner name.
     * @param savingsOwnerName
     * The name of the owner of the savings account.
     */
    public SavingsAccount(final String savingsOwnerName) {
        this.ownerName = savingsOwnerName;
    }

    /**
     * Returns the name of the owner of the savings account.
     * @return
     * The name of the owner of the savings account.
     */
    public String getOwnerName() {
        return ownerName;
    }
}
