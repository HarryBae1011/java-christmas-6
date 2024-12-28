package christmas.exception;

public class ChristmasException extends IllegalArgumentException{

    private static final String ERROR_PREFIX = "[ERROR] ";

    public ChristmasException(String m) {
        super(ERROR_PREFIX + m);
    }
}
