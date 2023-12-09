package homework_06_12_2023.task4;

import homework_06_12_2023.task3.User;

import java.util.Comparator;

public class NameComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
