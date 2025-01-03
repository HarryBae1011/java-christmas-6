package christmas.io;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Order;
import christmas.domain.VisitingDay;

public class InputView {

    public VisitingDay inputVisitingDay() {
        while (true) {
            try {
                return new VisitingDay(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.flush();
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }
    }

    public Order inputOrder() {
        while (true) {
            try {
                return new Order(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.flush();
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }
}
