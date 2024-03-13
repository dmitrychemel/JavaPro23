package homework_2024_02_21.taski2;
import lombok.Getter;

public class Transaction {
    @Getter
    private final double amount;
    private final boolean isSuccess;

    public Transaction(double amount, boolean isSuccess) {
        this.amount = amount;
        this.isSuccess = isSuccess;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", isSuccess=" + isSuccess +
                '}';
    }
}
