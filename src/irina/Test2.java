package irina;

import java.util.HashSet;
import java.util.Set;

public class Test2 {
    public static void main(String[] args) {
        Set<Integer> first = new HashSet<>();
        Set<Integer> second = new HashSet<>();

        for (int i = 0; i < 4; i++) {
            first.add(i);
            second.add(i);
        }

        for(Integer num : first) {
            for(Integer num1 : second) {
                if (num.equals(num1)) {
                    continue;
                }

                System.out.println(num + " - " + num1);
            }
            second.remove(num);
        }
    }
}
