package homework_2023_11_27.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,3,1,2));
        System.out.println(UniqueList(list));
    }

    public static List<Integer> UniqueList(List<Integer> list) {
        List<Integer> integerList = new ArrayList<>();

        for(Integer num: list){
            if(integerList.contains(num)){
                break;
            } else {
                integerList.add(num);
            }
        }
        return integerList;
    }
}
