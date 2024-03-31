package homework_2024_03_04;

public class WN3 {
    public static void main(String[] args) {
        Shop shop = new Shop();

        Buyer buyer = new Buyer(shop);
        Transfer transfer = new Transfer(shop);
        Stock stock = new Stock(shop);
        Worker worker = new Worker(shop);
        Miner miner = new Miner(shop);

        Thread buyerThread = new Thread(buyer);
        Thread transferThread = new Thread(transfer);
        Thread stockThread = new Thread(stock);
        Thread workerThread = new Thread(worker);
        Thread minerThread = new Thread(miner);

        stockThread.start();
        transferThread.start();
        buyerThread.start();
        workerThread.start();
        minerThread.start();
    }
}

class Shop {

    private int materials = 0;

    private int makeItem = 0;

    private int itemOnStock = 0;

    private int itemOnShop = 0;


    public synchronized void productionMaterial() {
        while (materials >= 5 || makeItem >= 5 || itemOnStock >= 5 || itemOnShop > 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        materials++;
        System.out.println("The material was extracted.Quantity:" + materials);
        notifyAll();
    }
    public synchronized void makeItem() {
        while (makeItem >= 5 || itemOnStock >= 5 || itemOnShop > 1 || materials < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        materials--;
        makeItem++;
        System.out.println("Finished items.Quantity:" + makeItem);
        System.out.println("Quantity MATERIALS:" + materials);
        notifyAll();
    }

    public synchronized void putOnStock() {
        while (itemOnStock >= 5 || makeItem < 1 || itemOnShop > 1 ) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        makeItem--;
        itemOnStock++;
        System.out.println("Delivery brought one item to the STOCK. Quantity:" + itemOnStock);
        System.out.println("Quantity MAKE ITEMS:" + makeItem);
        notifyAll();
    }

    public synchronized void transferStore() {
        while (itemOnShop >= 5 || itemOnStock < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        itemOnShop++;
        itemOnStock--;
        System.out.println("Transferred one item to the SHOP. Quantity on the SHOP:" + itemOnShop);
        System.out.println("Quantity on the STOCK:" + itemOnStock);
        notifyAll();
    }

    public synchronized void buyItem() {
        while (itemOnShop < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        itemOnShop--;
        System.out.println("Customer has bought one item. Quantity on the SHOP: " + itemOnShop);
        notifyAll();
    }

}

class Stock implements Runnable {
    Shop shop;

    public Stock(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            shop.putOnStock();
        }
    }
}

class Transfer implements Runnable {

    Shop shop;

    public Transfer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            shop.transferStore();
        }
    }
}

class Buyer implements Runnable {

    Shop shop;

    public Buyer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            shop.buyItem();
        }
    }
}

class Worker implements Runnable {

    Shop shop;

    public Worker(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            shop.makeItem();
        }
    }
}

class Miner implements Runnable {
    Shop shop;

    public Miner(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            shop.productionMaterial();
        }
    }
}


