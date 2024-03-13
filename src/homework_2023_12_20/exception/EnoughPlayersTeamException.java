package homework_2023_12_20.exception;

public class EnoughPlayersTeamException extends RuntimeException{
    public EnoughPlayersTeamException(String message) {
        super(message);
    }
}
