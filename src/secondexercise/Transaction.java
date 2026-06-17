package secondexercise;

import java.time.LocalDateTime;

public class Transaction {
    /**
     * The type of the transaction, which can
     * be either "Deposit" or "Withdrawal".
     */
    private String type;
    /**
     * The amount of the transaction.
     */
    private double amount;
    /**
     * The timestamp of the transaction, which indicates when the transaction
     * occurred.
     */
    private LocalDateTime timestamp;

    /**
     * Constructs a new Transaction object with the specified type and amount.
     * The timestamp is set to the current date and time when the transaction is
     * created.
     * @param typeOfTransaction   The type of the transaction,
     * which can be either "Deposit" or "Withdrawal".
     * @param amountTransacted The amount of the transaction.
     */
    public Transaction(final String typeOfTransaction,
            final double amountTransacted) {
        this.type = typeOfTransaction;
        this.amount = amountTransacted;
        this.timestamp = LocalDateTime.now();
    }

    /**
     * Returns the type of the transaction.
     * @return
     * The type of the transaction, which can be
     * either "Deposit" or "Withdrawal".
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Returns a string representation of the transaction, which includes the
     * type, amount, and timestamp.
     * @return A string representation of the transaction.
     */
    public String toString() {
        return String.format("%s: %.2f at %s", type, amount, timestamp);
    }
}
