package homework_2024_01_17;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class TaskTwo {
    public static void main(String[] args) {

    }

    public List<Item> getItemsByCustomerName(List<Order> orders, String customerName) {
        return orders.stream()
                .filter(order -> customerName.equals(order.getCustomerName()))
                .flatMap(order -> order.getItems().stream())
                .toList();
    }

    public double getTotalSalaryByDepartment(List<DepartmentCom> departments, String departmentName) {
        return departments.stream()
                .filter(department -> departmentName.equals(department.getName()))
                .flatMap(department -> department.getEmployees().stream())
                .map(EmployeeSalary::getSalary)
                .reduce(0.0, Double::sum);
    }

    public static List<String> combineAndTransformComplex(List<Integer> integers, List<String> strings, List<Double> doubles) {
        return Stream.of(integers.stream().map(Object::toString), strings.stream(), doubles.stream().map(Objects::toString))
                .flatMap(s -> s)
                .toList();
    }

}

class Order {
    private String customerName;
    private List<Item> items;

    public String getCustomerName() {
        return customerName;
    }

    public List<Item> getItems() {
        return items;
    }
}

class Item {
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Department {
    private String name;
    private List<EmployeeSalary> employees;

    public String getName() {
        return name;
    }

    public List<EmployeeSalary> getEmployees() {
        return employees;
    }
}

class EmployeeSalary {
    private String name;
    private double salary;

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
