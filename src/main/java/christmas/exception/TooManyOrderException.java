package christmas.exception;

public class TooManyOrderException extends ChristmasException{

    public TooManyOrderException() {
        super("메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.");
    }
}
