package homework_2023_12_06.task4;

import homework_2023_12_06.task3.User;

import java.util.Comparator;

public class NameComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
