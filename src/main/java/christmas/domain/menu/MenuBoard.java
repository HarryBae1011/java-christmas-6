package christmas.domain.menu;

import java.util.ArrayList;
import java.util.List;

public class MenuBoard {
    private final List<Menu> board= new ArrayList<>();

    private List<Menu> makeMenuBoard() {
        board.add(new Menu(MenuType.APPETIZER, "양송이수프", 6000));
        board.add(new Menu(MenuType.APPETIZER, "타파스", 5500));
        board.add(new Menu(MenuType.APPETIZER, "시저샐러드", 8000));
        board.add(new Menu(MenuType.MAIN, "티본스테이크", 55000));
        board.add(new Menu(MenuType.MAIN, "바비큐립", 54000));
        board.add(new Menu(MenuType.MAIN, "해산물파스타", 35000));
        board.add(new Menu(MenuType.MAIN, "크리스마스파스타", 25000));
        board.add(new Menu(MenuType.DESSERT, "초코케이크", 15000));
        board.add(new Menu(MenuType.DESSERT, "아이스크림", 5000));
        board.add(new Menu(MenuType.DRINK, "제로콜라", 3000));
        board.add(new Menu(MenuType.DRINK, "레드와인", 60000));
        board.add(new Menu(MenuType.DRINK, "샴페인", 25000));

        return board;
    }

    public List<Menu> getBoard() {
        return makeMenuBoard();
    }

}
