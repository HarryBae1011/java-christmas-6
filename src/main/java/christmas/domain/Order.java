package christmas.domain;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuBoard;
import christmas.domain.menu.MenuType;
import christmas.exception.TooManyOrderException;
import christmas.exception.WrongMenuException;
import christmas.exception.WrongQuantityException;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private final List<String> OrderedMenu = new ArrayList<String>();
    private final List<Enum> OrderedMenuType = new ArrayList<Enum>();
    private final List<Integer> OrderedMenuPrice = new ArrayList<Integer>();
    private final List<Integer> OrderedQuantity = new ArrayList<Integer>();
    private final int totalPrice;
    private int totalQuantity = 0;
    private int temp = 0;
    private boolean check = false;

    public Order(String input) {
        String[] original = input.split(",");
        OneOrder(original);
        validateOnlyDrink();
        totalPrice = calculateTotalPrice();
    }

    public List<String> getOrderedMenu() {
        return OrderedMenu;
    }

    public List<Enum> getOrderedMenuType() {
        return OrderedMenuType;
    }

    public List<Integer> getOrderedQuantity() {
        return OrderedQuantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    private void OneOrder(String[] input) {
        for (String s : input) {
            String[] MenuAndQuantity = s.split("-");

            Menu menu = validateMenuName(MenuAndQuantity[0]);
            validateDuplicateMenu(menu);

            if (menu.type.equals(MenuType.APPETIZER) || menu.type.equals(MenuType.MAIN) || menu.type.equals(MenuType.DESSERT))
                check = true;

            int quantity = validateMenuQuantity(MenuAndQuantity[1]);
            totalQuantity += quantity;

            if (totalQuantity > 20) {
                throw new TooManyOrderException();
            }

            OrderedMenu.add(menu.name);
            OrderedMenuType.add(menu.type);
            OrderedMenuPrice.add(menu.price);
            OrderedQuantity.add(quantity);
        }
    }

    private int calculateTotalPrice() {
        int size = OrderedMenu.size();

        for (int i = 0 ; i < size ; i++) {
            temp += (OrderedMenuPrice.get(i) * OrderedQuantity.get(i));
        }
        return temp;
    }

    private Menu validateMenuName(String name) {
        MenuBoard menuBoard = new MenuBoard();
        List<Menu> board = menuBoard.getBoard();

        for (Menu menu : board) {
            if (menu.name.equals(name)) {
                return menu;
            }
        }

        throw new WrongMenuException();
    }

    private void validateDuplicateMenu(Menu menu) {
        for (String name : OrderedMenu) {
            if (name.equals(menu.name)) {
                throw new WrongMenuException();
            }
        }
    }

    private int validateMenuQuantity(String input) {

        try {
            int Quantity = Integer.parseInt(input);

            if (Quantity < 1) {
                throw new WrongQuantityException();
            }

            return Quantity;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateOnlyDrink() {
        if (!check) {
            throw new WrongMenuException();
        }
    }

}
