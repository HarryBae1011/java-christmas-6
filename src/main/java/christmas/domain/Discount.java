package christmas.domain;

import christmas.domain.menu.MenuType;

import java.util.List;

public class Discount {
    private final VisitingDay visitingDay;
    private final Order order;
    private int totalDiscount = 0;
    private int dDayDiscount = 0;
    private int dailyDiscount = 0;
    private final int eventDiscount = 25000;
    private final int starDiscount = 1000;
    private final int DEFAULT_DISCOUNT = 1000;
    private final int INCREASING_DISCOUNT = 100;
    private final int DAY_DISCOUNT = 2023;
    private boolean holiday;
    private boolean star = false;
    private boolean event = false;

    public Discount(VisitingDay visitingDay, Order order) {
        this.visitingDay = visitingDay;
        this.order = order;
    }

    public int getdDayDiscount() {
        return dDayDiscount;
    }

    public int getDailyDiscount() {
        return dailyDiscount;
    }

    public int getEventDiscount() {
        return eventDiscount;
    }

    public int getStarDiscount() {
        return starDiscount;
    }

    public boolean isHoliday() {
        return holiday;
    }

    public boolean isStar() {
        return star;
    }

    public boolean isEvent() {
        return event;
    }

    public int calculateTotalDiscountPrice() {
        int day = visitingDay.getDay();
        int totalPriceBeforeDiscount = order.getTotalPrice();
        List<Enum> orderedMenuType = order.getOrderedMenuType();
        List<Integer> orderedQuantity = order.getOrderedQuantity();
        int size = orderedMenuType.size();

        checkChampagne(totalPriceBeforeDiscount);

        checkDdayDiscount(day);

        checkStardayDiscount();

        checkHolidayDiscount(size, orderedMenuType, orderedQuantity);

        return totalDiscount;
    }

    private void checkChampagne(int totalPriceBeforeDiscount) {
        if(totalPriceBeforeDiscount > 120000) {
            event = true;
            totalDiscount += eventDiscount;
        }
    }

    private void checkDdayDiscount(int day) {
        if (day <= 25) {
            dDayDiscount = DEFAULT_DISCOUNT + (INCREASING_DISCOUNT * (day - 1));
            totalDiscount += dDayDiscount;
        }
    }

    private void checkStardayDiscount() {
        if (visitingDay.isStar()) {
            star = true;
            totalDiscount += 1000;
        }
    }

    private void checkHolidayDiscount(int size, List<Enum> orderedMenuType, List<Integer> orderedQuantity) {
        if (visitingDay.isHoliday()) {
            holiday = true;
            discountMainMenu(size, orderedMenuType, orderedQuantity);
            return;
        }

        holiday = false;
        discountDessertMenu(size, orderedMenuType, orderedQuantity);
    }

    private void discountDessertMenu(int size, List<Enum> orderedMenuType, List<Integer> orderedQuantity) {
        for (int i = 0; i < size; i++) {
            if (orderedMenuType.get(i).equals(MenuType.DESSERT)) {
                dailyDiscount += DAY_DISCOUNT * orderedQuantity.get(i);
                totalDiscount += dailyDiscount;
            }
        }
    }

    private void discountMainMenu(int size, List<Enum> orderedMenuType, List<Integer> orderedQuantity) {
        for (int i = 0; i < size; i++) {
            if (orderedMenuType.get(i).equals(MenuType.MAIN)) {
                dailyDiscount += DAY_DISCOUNT * orderedQuantity.get(i);
                totalDiscount += dailyDiscount;
            }
        }
    }

}
