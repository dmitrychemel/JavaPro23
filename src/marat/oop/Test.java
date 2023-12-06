package marat.oop;

public class Test {

    public static void main(String[] args) {
        Dog dog = new Dog("Dog", 12, "tipDog");
        Cat cat = new Cat("Cat", 12, "tipCat");

        dog.sound();
        cat.sound();

        dog.swim();
        cat.swim();

        System.out.println(cat);
    }
}
