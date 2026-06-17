package thirdexercise;

import java.util.List;

import secondexercise.Transaction;

public interface FilterTransactions {
    /**
     * Filters a list of transactions and returns a new list containing only the
     * amounts that are greater than or equal to the specified number.
     * @param amount
     * Transactions that have an amount greater than or equal to
     * the specified number.
     * @param txList
     * list of transactions to be filtered.
     * @return
     * A new list containing only the transactions that
     * have an amount greater than
     * or equal to the specified number.
     */
    List<Transaction> filterTransactionsAtOrAbove(double amount,
            List<Transaction> txList);

}
