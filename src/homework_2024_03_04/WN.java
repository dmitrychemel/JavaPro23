package homework_2024_03_04;

public class WN {
    public static void main(String[] args) {
        Storage storage = new Storage();

        Producer producer = new Producer(storage);
        Consumer consumer = new Consumer(storage);

        Thread prodThread = new Thread(producer);
        Thread consThread = new Thread(consumer);

        prodThread.start();
        consThread.start();
    }
}

class Storage {
    private int item = 0;

    private final Object lock = new Object();

    public void getItem() {
        synchronized (lock) {
            while (item < 1) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            item--;
            System.out.println("Customer has bought one item. Quantity: " + item);
            lock.notify();
        }
    }

    public void putItem() {
        synchronized (lock) {
            while (item >= 5) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            item++;
            System.out.println("Factory put one item into the Storage. Quantity: " + item);
            lock.notify();
        }
    }
}

class Producer implements Runnable {

    Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            storage.putItem();
        }
    }
}

class Consumer implements Runnable {

    Storage storage;

    public Consumer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            storage.getItem();
        }
    }
}
