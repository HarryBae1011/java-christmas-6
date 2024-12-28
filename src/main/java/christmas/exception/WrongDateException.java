package christmas.exception;

public class WrongDateException extends ChristmasException{

    public WrongDateException() {
        super("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }
}
