package homework_2023_12_20.exception;

public class EmptyTableGroupException extends RuntimeException{
    public EmptyTableGroupException(String message) {
        super(message);
    }
}
