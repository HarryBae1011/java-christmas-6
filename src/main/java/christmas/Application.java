package christmas;

import christmas.domain.Discount;
import christmas.domain.Order;
import christmas.domain.VisitingDay;
import christmas.io.InputView;
import christmas.io.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView input = new InputView();
        OutputView output = new OutputView();

        output.printAskingVisitingDay();
        VisitingDay visitingDay = input.inputVisitingDay();
        output.printAskingMenu();
        Order order = input.inputOrder();
        output.printOrderedDay(visitingDay.getDay());
        output.printOrderedMenu(order);
        int totalOrderPrice = output.printTotalOrderPrice(order);
        Discount discount = new Discount(visitingDay, order);
        int totalDiscountPrice = output.printTotalDiscountPrice(discount, totalOrderPrice);
        output.printTotalPurchasePrice(discount, totalOrderPrice,totalDiscountPrice);
        output.printEventBadge(totalDiscountPrice);
    }
}
