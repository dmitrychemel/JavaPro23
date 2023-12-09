package olga;

public class Cat extends Animal implements Eating{

    private String tipe;

    public Cat(String name, int age, String tipe) {
        super(name, age);
        this.tipe = tipe;
    }

    @Override
    public void sound() {
        System.out.println("Mяy-Mяу");
    }

    @Override
    public void run() {
        System.out.println("я бегу со скоростью 10 км/ч");
    }

    @Override
    public void eat() {
        System.out.println("Я голоден, дайте мне рыбку");
    }
}
