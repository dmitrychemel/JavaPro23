package marat.oop;

public class Dog extends Animal implements Move{
    private String type;

    public Dog(String name, int age, String type) {
        super(name, age);
        this.type = type;
    }

    @Override
    public void sound() {
        System.out.println("gav-gav");
    }

    @Override
    public void run() {
        System.out.println("run - 20 km/h");
    }

    @Override
    public void swim() {
        System.out.println("swim - 4 km/h");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "type='" + type + '\'' +
                '}';
    }
}
