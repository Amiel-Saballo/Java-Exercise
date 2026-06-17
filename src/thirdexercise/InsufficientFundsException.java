package thirdexercise;

public class InsufficientFundsException extends Exception {

    /**
     * Holds the message passed down from the constructor.
     */
    private String message;

    /**
     * Constructs a new InsufficientFundsException object
     * with the specified message.
     * @param messageToSet
     * The message to be set for the exception.
     */
    public InsufficientFundsException(final String messageToSet) {
        this.message = messageToSet;
    }

    /**
     * Returns the message associated with the exception.
     * @return
     * The message associated with the exception.
     */
    public String getMessage() {
        return message;
    }
}
