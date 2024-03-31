package homework_2024_03_06;

import com.github.javafaker.Faker;

import java.util.concurrent.Semaphore;

public class SEM {

    private static final Semaphore SEMAPHORE = new Semaphore(3);
    private static final Faker FAKER = new Faker();

    public static void main(String[] args) {
        new User_2(FAKER.funnyName().name(), SEMAPHORE);
        new User_2(FAKER.funnyName().name(), SEMAPHORE);
        new User_2(FAKER.funnyName().name(), SEMAPHORE);
        new User_2(FAKER.funnyName().name(), SEMAPHORE);
        new User_2(FAKER.funnyName().name(), SEMAPHORE);
        new User_2(FAKER.funnyName().name(), SEMAPHORE);
        new User_2(FAKER.funnyName().name(), SEMAPHORE);
        new User_2(FAKER.funnyName().name(), SEMAPHORE);
        new User_2(FAKER.funnyName().name(), SEMAPHORE);
        new User_2(FAKER.funnyName().name(), SEMAPHORE);
        new User_2(FAKER.funnyName().name(), SEMAPHORE);
    }
}

class User_2 extends Thread {
    private String name;

    private Semaphore semaphore;

    public User_2(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
        this.start();
    }

    @Override
    public void run() {
        try {

            System.out.println("USER: " + name + " : is waiting for . SEMAPHORE: " + semaphore.availablePermits());
            semaphore.acquire();
            Thread.sleep(999);
            System.out.println("USER: " + name + " : is waiting using");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
            System.out.println("SEMAPHORE: OUT" + semaphore.availablePermits());
        }
    }
}
