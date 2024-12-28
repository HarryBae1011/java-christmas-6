package christmas.domain.menu;

public class Menu {

    public MenuType type;
    public String name;
    public int price;

    public Menu(MenuType type, String name, int price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
}
