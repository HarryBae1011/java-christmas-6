package christmas.domain;

import christmas.config.Calendar;
import christmas.exception.WrongDateException;

public class VisitingDay {

    private final int day;

    public VisitingDay(String day) {
        this.day = validateDay(day);
    }

    private int validateDay(String input) {
        try {
            int d = Integer.parseInt(input);

            if (d < 1 || d > 31) {
                throw new WrongDateException();
            }
            return d;
        } catch (NumberFormatException e) {
            throw new WrongDateException();
        }
    }

    public int getDay() {
        return day;
    }

    public boolean isHoliday() {
        for (Integer i : Calendar.Holiday) {
            if (i.equals(day)) {
                return true;
            }
        }
        return false;
    }

    public boolean isStar() {
        for (Integer i : Calendar.Star) {
            if (i.equals(day)) {
                return true;
            }
        }
        return false;
    }
}
