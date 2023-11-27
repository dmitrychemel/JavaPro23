package homework_20_11_2023.exp_3;

public class Product {
    private String name;
    private long price;
    private int count;

    public Product(String name, long price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public boolean checkAvailability(Product product) {
        if(product.count < 0) {
            return false;
        }
        return true;
    }

    public void updateStock() {
        count--;
    }
}
