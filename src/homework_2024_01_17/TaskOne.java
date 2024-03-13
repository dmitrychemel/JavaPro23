package homework_2024_01_17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public class TaskOne {
    Function<Number, String> function = Object::toString;
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>(List.of(new User("Qwerty", new ArrayList<>(List.of("speed","power"))), new User("Qwerty1", new ArrayList<>(List.of("speed1","power1")))));
        System.out.println(getAllSkills(userList));
    }

    public static List<Integer> flattenListOfLists(List<List<Integer>> listOfLists) {
        return listOfLists.stream()
                .flatMap(List::stream)
                .toList();
    }

    public static List<String> getAllSkills(List<User> users) {
        return users.stream()
                .flatMap(user -> user.getSkills().stream())
                .toList();
    }

    public static List<String> getAuthorsTitles(List<Book> books) {
        return books.stream()
                .flatMap(book -> book.getAuthors().stream())
                .toList();
    }
    public List<String> flattenMap(Map<String, List<String>> map) {
        return map.values().stream()
                .flatMap(List::stream)
                .toList();
    }

    public List<Integer> processAndFilter(List<List<Integer>> listOfLists) {
        return listOfLists.stream()
                .flatMap(List::stream)
                .filter(number -> number % 2 == 0)
                .map(number -> number * 2)
                .toList();
    }

    public List<String> getLanguagesFromDepartment(List<Employee> employees, String department) {
        return  employees.stream()
                .filter(employee -> department.equals(employee.getDepartment()))
                .flatMap(employee -> employee.getLanguages().stream())
                .toList();
    }

    public List<Integer> flattenDeepListOfLists(List<List<List<Integer>>> deepList) {
        return deepList.stream()
                .flatMap(List::stream)
                .flatMap(List::stream)
                .toList();
    }

    public List<String> getSortedTasks(List<Project> projects) {
        return projects.stream()
                .flatMap(project -> project.getTasks().stream())
                .sorted()
                .toList();
    }

    public List<String> getUniqueProductNames(Map<String, List<Product>> categoryMap) {
        return categoryMap.values().stream()
                .flatMap(List::stream)
                .map(Product::getName)
                .distinct()
                .toList();
    }

    public List<String> combineAndTransform(List<Integer> list1, List<Double> list2, Function<Number, String> transformer) {
        return Stream.concat(list1.stream().map(transformer), list2.stream().map(transformer))
                .toList();
    }

}

class User {
    private String name;
    private List<String> skills;

    public User(String name, List<String> skills) {
        this.name = name;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public List<String> getSkills() {
        return skills;
    }
}

class Book {
    private String title;
    private List<String> authors;

    public Book(String title, List<String> authors) {
        this.title = title;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }
}

class Employee {
    private String department;
    private List<String> languages;

    public Employee(String department, List<String> languages) {
        this.department = department;
        this.languages = languages;
    }

    public String getDepartment() {
        return department;
    }

    public List<String> getLanguages() {
        return languages;
    }
}

class Project {
    private String name;
    private List<String> tasks;

    public Project(String name, List<String> tasks) {
        this.name = name;
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public List<String> getTasks() {
        return tasks;
    }

    class Product {
        private String category;
        private String name;

        public Product(String category, String name) {
            this.category = category;
            this.name = name;
        }

        public String getCategory() {
            return category;
        }

        public String getName() {
            return name;
        }
    }
}

class Product {
    private String category;
    private String name;

    public Product(String category, String name) {
        this.category = category;
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
}
