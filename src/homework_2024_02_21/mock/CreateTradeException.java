package homework_2024_02_21.mock;

public class CreateTradeException extends RuntimeException {
    public CreateTradeException() {
        super("Cannot create such trade!");
    }
}