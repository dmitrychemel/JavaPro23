package homework_2023_11_20.exp_3;

public class OrderManager {
    private Product[] listAvailability;
    private Order[] listOrders;

    public OrderManager() {
        listAvailability = new Product[0];
        listOrders = new Order[0];
    }

    public void addProductAvailability(Product product){
        if(product.checkAvailability(product)) {
            Product[] newListAvailability = new Product[listAvailability.length + 1];
            System.arraycopy(listAvailability, 0, newListAvailability, 0, listAvailability.length);
            newListAvailability[listAvailability.length] = product;
            listAvailability = newListAvailability;
        }
    }

    public boolean AvailabilityProduct(Product product) {
        for (int i = 0; i < listAvailability.length; i++) {
            if(listAvailability[i].equals(product)) {
                if(product.getCount() == 0) {
                    deleteProductAvailability(product);
                    System.out.println("К сожалению, забрали последнюю пару");
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public void deleteProductAvailability(Product product) {

        for (int i = 0; i < listAvailability.length; i++) {
            if(listAvailability[i].equals(product)){
                Product[] newList = new Product[listAvailability.length - 1];
                System.arraycopy(listAvailability, 0, newList, 0, i);
                System.arraycopy(listAvailability, i + 1, newList, 0, listAvailability.length - i - 1);
                listAvailability = newList;
            }
        }

    }

}
