package homework_2023_12_20.exception;

public class EmptyHistoryMatchesException extends RuntimeException {
    public EmptyHistoryMatchesException(String message) {
        super(message);
    }
}
