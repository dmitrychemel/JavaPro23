package lesson_20_11_2023.exp_3;

public class Power {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        System.out.println(power(a,b));
    }

    private static int power(int a, int b) {
        int power = 1;
        for (int i = 0; i < b; i++) {
            power *=a;
        }

        return power;
    }
}
