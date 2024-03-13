package homework_2024_02_12;

import java.util.List;

public class Order {
    private List<Item> items;

    public void addItem(Item item) {
        items.add(item);
    }

    public void calculateTotal() {
        items.stream()
                .map(Item::getPrice)
                .reduce(0.0, Double::sum);
    }

    public void printInvoice() {
        items.forEach(item -> System.out.println("Item - " + item.getName() + " | Price: " + item.getPrice()));
    }
}

class Item {
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
