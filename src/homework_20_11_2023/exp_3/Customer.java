package homework_20_11_2023.exp_3;

import homework_20_11_2023.exp_2.Book;

public class Customer {
    private String name;
    private String email;
    private Order[] historyOrder;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        historyOrder = new Order[0];
    }

    public void doOrder (Product product,OrderManager orderManager) {
        // Проверка наличия продукта
        // обновления кол=во на складе
        // добавить в историю заказов
        // Order добавить заказ в список продуктов
        Order order = new Order();
        if(orderManager.AvailabilityProduct(product)) {
            order.addProductToOrder(product);
            Order[] newHistory = new Order[historyOrder.length + 1];
            System.arraycopy(historyOrder, 0, newHistory, 0, historyOrder.length);
            newHistory[historyOrder.length] = order;
            historyOrder = newHistory;
        }
    }

    public void cancelOrder(int idOrder) {
        for (int i = 0; i < historyOrder.length ; i++) {
            if(historyOrder[i].getId() == idOrder){
                Order[] newHistory = new Order[historyOrder.length - 1];
                System.arraycopy(historyOrder, 0, newHistory, 0, i);
                System.arraycopy(historyOrder, i + 1, newHistory, 0, historyOrder.length - i - 1);
                historyOrder = newHistory;
            }
        }
    }

    public void payOrders() {
        // посчитать сумму
        // Очистить историю заказов
    }
}
