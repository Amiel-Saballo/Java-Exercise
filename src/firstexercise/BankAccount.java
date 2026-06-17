package firstexercise;

import java.util.List;

import secondexercise.BankAccountManager;
import secondexercise.Transaction;
import thirdexercise.AccountFrozenException;
import thirdexercise.InsufficientFundsException;
import thirdexercise.InvalidAmountException;

public class BankAccount {

    /**
     * The balance of the bank account.
     */
    private double balance;
    /**
     * A flag to indicate whether the bank account is frozen or not.
     */
    private boolean isFrozen;
    /**
     * The transaction history of the bank account,
     * which stores all the transactions.
     */
    private List<Transaction> transactionHistory; //Exercise 2

    //Exercise 2
    /**
     * Constructs a new BankAccount object with an empty transaction history.
     */
    public BankAccount() {
        transactionHistory = new java.util.ArrayList<>();
    }

    /**
     * Returns the current balance of the bank account.
     * @return
     * The current balance of the bank account.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the balance of the bank account to the specified value.
     * @param balanceToSet
     * The new balance of the bank account.
     */
    public void setBalance(final double balanceToSet) {
        this.balance = balanceToSet;
    }

    /**
     * Returns whether the bank account is frozen or not.
     * @return
     * True if the bank account is frozen, false otherwise.
     */
    public boolean isFrozen() {
        return isFrozen;
    }

    /**
     * Sets the frozen status of the bank account to the specified value.
     * @param freezeStatus
     * The new frozen status of the bank account.
     */
    public void setFrozen(final boolean freezeStatus) {
        this.isFrozen = freezeStatus;
    }

    /**
     * Prints the transaction history of the bank account.
     * If there are no transactions,
     */
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

    /**
     * Deposits the specified amount into the bank account.
     * @param amount
     * The amount to be deposited into the bank account. Must be greater than 0.
     * @throws InvalidAmountException If the amount is less than or equal to 0.
     * @throws AccountFrozenException If the account is frozen.
     */
    public void deposit(final double amount) throws
    InvalidAmountException, AccountFrozenException {
        if (isFrozen()) {
            throw new AccountFrozenException(
                    "Account is FROZEN. " + "Unable to transact.");
//            System.out.println("Account is FROZEN. "
//                    + "Unable to transact.");
        } else if (amount > 0) {
            setBalance(getBalance() + amount);
            System.out.printf("Amount Deposited: %.2f%n", amount);
            System.out.printf("Current Balance: %.2f%n",
                    getBalance());
            transactionHistory.add(new Transaction("Deposit",
                    amount)); //Exercise 2
        } else {
            System.out.printf("Amount Deposited: %.2f%n", amount);
            throw new InvalidAmountException("Invalid deposit amount. "
                    + "Must be greater than 0.");
//            System.out.println("Invalid deposit amount. "
//                    + "Must be greater than 0.");
        }
    }

    /**
     * Withdraws the specified amount from the bank account.
     * @param amount
     * The amount to be withdrawn from the bank account.
     * Must be greater than 0 and less than or equal to the current balance.
     * @throws AccountFrozenException If the account is frozen
     * @throws InvalidAmountException If the amount is less than or equal to 0.
     * @throws InsufficientFundsException If the amount is greater
     * than the current balance.
     */
    public void withdraw(final double amount) throws
    AccountFrozenException, InvalidAmountException, InsufficientFundsException {
        if (isFrozen()) {
            throw new AccountFrozenException(
                    "Account is FROZEN. " + "Unable to transact.");
//            System.out.println("Account is FROZEN. "
//                    + "Unable to transact.");
//            return;
        } else if (amount > 0 && amount <= getBalance()) {
            setBalance(getBalance() - amount);
            System.out.printf("Amount Withdrawn: %.2f%n", amount);
            System.out.printf("Current Balance: %.2f%n",
                    getBalance());
            transactionHistory.add(new Transaction("Withdraw",
                    amount)); //Exercise 2
        } else if (amount > getBalance()) {
            System.out.printf("Amount Withdrawn: %.2f%n", amount);
            throw new InsufficientFundsException(
                    String.format("Insufficient funds. Current Balance: %.2f%n",
                            getBalance()));
//            System.out.printf("Insufficient funds. "
//                    + "Current Balance: %.2f%n", getBalance());
        } else {
            System.out.printf("Amount Withdrawn: %.2f%n", amount);
            throw new InvalidAmountException(
                    "Invalid withdrawal amount. " + "Must be greater than 0.");
//            System.out.println("Invalid withdrawal amount. "
//                    + "Must be greater than 0.");
        }
    }

    /**
     * Freezes the bank account, preventing any transactions from being made.
     */
    public void freezeAccount() {
        setFrozen(true);
//        System.out.println("Account has been frozen.");
    }

    /**
     * Unfreezes the bank account, allowing transactions to be made again.
     */
    public void unfreezeAccount() {
        setFrozen(false);
//        System.out.println("Account has been unfrozen.");
    }

    //Exercise 1 - Test Cases
    /**
    * The main method to run the test cases for the BankAccount class.
    * @param args
    * Command line arguments (not used).
     * @throws InsufficientFundsException If a withdrawal
     * amount is greater than the current balance.
    */
    public static void main(final String[] args) throws
    InsufficientFundsException {

        final double testCase2 = 1000.125;
        final double minusFiveHundred = -500;
        final double plusFiveHundred = 500;
        final double plusOneKFive = 1500;
        final double minusOneHundred = -100;
        final double elevenFive = 11500;
        final double plusOneHundred = 100;
        final double twoHundred = 200;

        //Test Case: 1
        System.out.println("Test Case: 1");
        BankAccount acc1 = new SavingsAccount("Test0");
        System.out.println("Account Owner: "
                + ((SavingsAccount) acc1).getOwnerName());

        try {

/*        //Test Case: 2
        System.out.println("Test Case: 2");
        acc1.deposit(testCase2);

        //Test Case: 3
        System.out.println("Test Case: 3");
        acc1.deposit(0);

        //Test Case: 4
        System.out.println("Test Case: 4");
        acc1.deposit(minusFiveHundred);

        //Test Case: 5
        System.out.println("Test Case: 5");
        acc1.withdraw(plusFiveHundred);

        //Test Case: 6
        System.out.println("Test Case: 6");
        acc1.withdraw(plusOneKFive);

        //Test Case: 7
        System.out.println("Test Case: 7");
        acc1.withdraw(minusOneHundred);

        //Test Case: 8
        System.out.println("Test Case: 8");
        acc1.freezeAccount();
        acc1.deposit(elevenFive);

        //Test Case: 9
        System.out.println("Test Case: 9");
        acc1.withdraw(plusFiveHundred);

        //Test Case: 10
        System.out.println("Test Case: 10");
        acc1.unfreezeAccount();
        acc1.withdraw(oneHundred);

*/
        //Exercise 2
        System.out.println("=========================================");
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

        //Exercise 3
        System.out.println("=========================================");
        //Test Case: 1
        System.out.println("Test Case: 1");
        acc1.deposit(plusFiveHundred);

        //Test Case: 2
        System.out.println("Test Case: 2");
        acc1.freezeAccount();
        acc1.deposit(elevenFive);

        //Test Case: 3
        System.out.println("Test Case: 3");
        acc1.withdraw(minusOneHundred);

        //Test Case: 4
        System.out.println("Test Case: 4");
        acc1.withdraw(plusOneKFive);

        //Test Case: 5
        System.out.println("Test Case: 5");
        acc1.freezeAccount();
        acc1.withdraw(plusFiveHundred);

        //Test Case: 6
        System.out.println("Test Case: 6");
        System.out.println(accM1.filterTransactionsAtOrAbove(
                twoHundred, acc1.transactionHistory));

        //Test Case: 7
        System.out.println("Test Case: 7");
        System.out.println(accM1.sortTransactionsByAmount(
                acc1.transactionHistory));

        } catch (InvalidAmountException
                | AccountFrozenException
                | InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

    }

}
