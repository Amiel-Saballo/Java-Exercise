package secondexercise;

import java.time.LocalDateTime;

public class Transaction {
	private String type;
	private double amount;
	private LocalDateTime timestamp;
	
	public Transaction(String type, double amount) {
		this.type = type;
		this.amount = amount;
		this.timestamp = LocalDateTime.now();
	}
	
	public String toString() {
        return String.format("%s: %.2f at %s", type, amount, timestamp);
    }

}
