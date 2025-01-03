package christmas.io;

import christmas.domain.Discount;
import christmas.domain.Order;

import java.util.List;

public class OutputView {

    public void printAskingVisitingDay() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해주세요!)");
    }

    public void printAskingMenu() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
    }

    public void printOrderedDay(int day) {
        System.out.println("12월 " + day + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
    }

    public void printOrderedMenu(Order order) {
        List<String> orderedMenu = order.getOrderedMenu();
        List<Integer> orderedQuantity = order.getOrderedQuantity();
        int size = orderedMenu.size();

        System.out.println("<주문 메뉴>");
        for (int i = 0 ; i < size ; i++) {
            System.out.println(orderedMenu.get(i) + " " +orderedQuantity.get(i) + "개");
        }
        System.out.println();
    }

    public int printTotalOrderPrice(Order order) {
        int totalPrice = order.getTotalPrice();
        System.out.println("<할인 전 총주문 금액>");

        System.out.println(totalPrice + "원");
        System.out.println();

        return totalPrice;
    }

    public int printTotalDiscountPrice(Discount discount, int totalPrice) {
        int totalDiscountPrice = discount.calculateTotalDiscountPrice();

        printChampagne(discount);

        System.out.println();

        System.out.println("<혜택 내역>");

        printBenefit(discount, totalPrice, totalDiscountPrice);

        System.out.println();
        System.out.println("<총혜택 금액>");

        if (totalDiscountPrice == 0 || totalPrice < 10000) {
            System.out.println("0원");
        } else {
            System.out.println("-" + totalDiscountPrice + "원");
        }
        System.out.println();

        return totalDiscountPrice;
    }

    private static void printBenefit(Discount discount, int totalPrice, int totalDiscountPrice) {
        if (totalDiscountPrice == 0 || totalPrice < 10000) {
            System.out.println("없음");
            return;
        }

        System.out.println("크리스마스 디데이 할인: -" + discount.getdDayDiscount() + "원");

        printHolidayDiscount(discount);

        if (discount.isStar()) {
            System.out.println("특별 할인: -" + discount.getStarDiscount() + "원");
        }

        if (discount.isEvent()) {
            System.out.println("증정 이벤트: -" + discount.getEventDiscount() + "원");
        }

    }

    private static void printHolidayDiscount(Discount discount) {

        if (discount.getDailyDiscount() == 0) {
            return;
        }

        if (discount.isHoliday()) {
            System.out.println("주말 할인: -" + discount.getDailyDiscount() + "원");
            return;
        }

        System.out.println("평일 할인: -" + discount.getDailyDiscount() + "원");
    }

    private static void printChampagne(Discount discount) {
        System.out.println("<증정 메뉴>");
        if (discount.isEvent()) {
            System.out.println("샴페인 1개");
            return;
        }
        System.out.println("없음");
    }

    public void printTotalPurchasePrice(Discount discount, int totalOrderPrice, int totalDiscountPrice) {
        int totalPurchasePrice = totalOrderPrice - totalDiscountPrice;
        System.out.println("<할인 후 예상 결제 금액>");
        if (discount.isEvent()) {
            System.out.println((totalPurchasePrice + discount.getEventDiscount()) + "원");
            System.out.println();
            return;
        }

        System.out.println(totalPurchasePrice + "원");
        System.out.println();
    }

    public void printEventBadge(int totalDiscountPrice) {
        System.out.println("<12월 이벤트 배지>");
        
        if (totalDiscountPrice < 5000) {
            System.out.println("없음");
        }

        if (5000 <= totalDiscountPrice && totalDiscountPrice < 10000) {
            System.out.println("별");
        }

        if (10000 <= totalDiscountPrice && totalDiscountPrice < 20000) {
            System.out.println("트리");
        }

        if (totalDiscountPrice > 20000) {
            System.out.println("산타");
        }
    }
}
