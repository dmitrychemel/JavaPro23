package artur;

public class Test {
    public static void main(String[] args) {
        Cat cat = new Cat(2);
        cat.getMap().put(1,2);

        System.out.println(cat.getMap());
    }
}
