package secondexercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import firstexercise.BankAccount;
import firstexercise.SavingsAccount;
import thirdexercise.FilterTransactions;
import thirdexercise.SortTransactions;

public class BankAccountManager implements Bank,
                                FilterTransactions, SortTransactions {

    /**
     * A map that stores the bank accounts with their corresponding IDs.
     */
    private Map<Integer, BankAccount> accounts;
    /**
     * The ID of the next bank account to be added.
     */
    private int id;

    /**
     *  Constructs a new BankAccountManager object
     *  with an empty accounts map and initializes the ID to 0.
     */
    public BankAccountManager() {
        accounts = new java.util.HashMap<>();
        id = 0;
    }

    @Override
    public final void addAccount(final BankAccount account) {
        accounts.put(id, account);
        System.out.printf("Account successfully "
                + "added with ID: %d%n", id);
        id++;
    }

    @Override
    public final BankAccount getAccount(final int accountID) {
        return accounts.get(accountID);
    }

    /**
     * Prints the list of all bank accounts with their IDs, names, and balances.
     */
    public void listAccounts() {
        for (Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
            System.out.printf("Account ID: %d, Account Name: %s, "
                    + "Balance: %.2f%n", entry.getKey(),
                    ((SavingsAccount) entry.getValue()).getOwnerName(),
                    entry.getValue().getBalance());
        }
    }

    @Override
    public final List<Transaction> filterTransactionsAtOrAbove(
        final double amount, final List<Transaction> txList) {
        FilterTransactions filter = (amountToCheck, transactionList) -> {
            List<Transaction> filtered = new ArrayList<>();
            for (Transaction tx : transactionList) {
                if (tx.getAmount() >= amountToCheck) {
                    filtered.add(tx);
                }
            }
            return filtered;
        };
        return filter.filterTransactionsAtOrAbove(amount, txList);
    }

    @Override
    public final List<Transaction> sortTransactionsByAmount(
            final List<Transaction> txList) {
        SortTransactions sort = (transactionList) -> {
            List<Transaction> sortedTransactions =
                    new ArrayList<>(transactionList);
            sortedTransactions.sort(
                    (tx1, tx2) -> Double.compare(tx1.getAmount(),
                            tx2.getAmount()));
            return sortedTransactions;
        };
        return sort.sortTransactionsByAmount(txList);
    }
}
