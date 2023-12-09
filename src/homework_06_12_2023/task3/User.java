package homework_06_12_2023.task3;

import java.util.Objects;

public class User implements Comparable<User>{

    private String firstName;
    private int age;
    private String lastName;

    public User(String firstName, int age, String lastName) {
        this.firstName = firstName;
        this.age = age;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, age, lastName);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public int compareTo(User o) {
        return this.age - o.age;
    }
}
