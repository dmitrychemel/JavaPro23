package homework_27_11_2023.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class task1 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(Arrays.asList("ddd", "dddd", "dd", "ddddd", "ddd", "d", "ddddd", "dddd", "ddd"));
        System.out.println(deleteByLength(stringList, 3));
    }

    public static List<String> deleteByLength(List<String> list, int length) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).length() < length){
                list.remove(i);
                i--;
            }
        }

        return list;
    }
}
