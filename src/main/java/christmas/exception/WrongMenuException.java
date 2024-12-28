package christmas.exception;

public class WrongMenuException extends ChristmasException{

    public WrongMenuException() {
        super("유효하지 않은 주문입니다. 다시 입력해주세요");
    }
}
