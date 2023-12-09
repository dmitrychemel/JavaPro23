package olga;

public class Test {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 7, "Good");
        Dog dog = new Dog("Bobik", 10, "Bad");

//        dog.sound();
//        cat.sound();
//
//        dog.run();
//        cat.run();

        dog.swim();
        cat.eat();

        Bank bank = new Bank("Bank", new Client("Olga"));
    }
}
