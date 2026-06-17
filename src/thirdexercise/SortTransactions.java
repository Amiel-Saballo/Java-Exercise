package thirdexercise;

import java.util.List;

import secondexercise.Transaction;

public interface SortTransactions {
    /**
     * Sorts a list of transactions in ascending order based on their amount.
     * @param txList The list of transactions to be sorted.
     * @return A new list containing the transactions sorted in ascending order
     *         based on their amount.
     */
    List<Transaction> sortTransactionsByAmount(List<Transaction> txList);
}
