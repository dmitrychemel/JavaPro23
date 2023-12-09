package olga;

public class Dog extends Animal implements Swim,Eating{
    private String tipe;

    public Dog(String name, int age, String tipe) {
        super(name, age);
        this.tipe = tipe;
    }

    @Override
    public void sound() {
        System.out.println("Gav-gav");
    }

    @Override
    public void run() {
        System.out.println("я бегу со скоростью 15 км/час");
    }

    @Override
    public void swim() {
        System.out.println("Я умею плавать");
    }

    @Override
    public void eat() {
        System.out.println("Я голоден, мне нужна кость");
    }
}
