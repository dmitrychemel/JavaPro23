package marat.oop;

public class Cat extends Animal implements Move{
    private String type;

    public Cat(String name, int age, String type) {
        super(name, age);
        this.type = type;
    }

    @Override
    public void sound() {
        System.out.println("muy-muy");
    }

    @Override
    public void run() {
        System.out.println("run - 10 km/h");
    }

    @Override
    public void swim() {
        System.out.println("I can't swim");
    }

    @Override
    public String toString() {
        return "Cat{" +
                " \"name=\" " + getName() +
                " age= " + getAge() +
        " type='" + type + '\'' +
                '}';
    }
}
