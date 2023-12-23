package homework_2023_11_20.exp_3;

public class Order {
    private static int idCounter = 1;
    private int id;
    private Product[] listProductToOrder;
    private String statusOrder;
    private long totalPrice;

    public Order() {
        this.id = idCounter++;
        listProductToOrder = new Product[0];
        statusOrder = "В обработке";
        totalPrice = 0;
    }

    public int getId() {
        return id;
    }

    public void addProductToOrder(Product product) {
        Product[] newList = new Product[listProductToOrder.length + 1];
        System.arraycopy(listProductToOrder, 0, newList, 0, listProductToOrder.length);
        newList[listProductToOrder.length] = product;
        listProductToOrder = newList;
        calculateTotalPrice(product);
        product.updateStock();
    }

    public void calculateTotalPrice(Product product) {
        totalPrice += product.getPrice();
    }
}
