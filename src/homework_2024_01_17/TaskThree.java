package homework_2024_01_17;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskThree {
    public static void main(String[] args) {

    }

    public Map<String, Double> averageSalaryByCompany(List<Company> companies) {
        return companies.stream()
                .collect(Collectors.toMap(Company::getName,
                        company -> {
                            return company.getDepartments().stream()
                                    .flatMap(departmentCom -> departmentCom.getEmployees().stream())
                                    .mapToDouble(EmployeeSalary::getSalary)
                                    .average()
                                    .orElse(0.0);
                        }
                ));
    }

    public Map<String, List<String>> highValueProductsByCustomer(List<Order1> orders, double threshold) {
        return orders.stream()
                .collect(Collectors.toMap(Order1::getCustomerName,
                        product -> product.getProducts().stream()
                                .filter(price -> price.getPrice() > threshold )
                                .map(Product1::getCategory)
                                .toList()));
    }
}

class Company {
    private String name;
    private List<DepartmentCom> departments;

    public String getName() {
        return name;
    }

    public List<DepartmentCom> getDepartments() {
        return departments;
    }
}

class DepartmentCom {
    private String name;
    private List<EmployeeSalary> employees;

    public String getName() {
        return name;
    }

    public List<EmployeeSalary> getEmployees() {
        return employees;
    }
}

class Product1 {
    private String category;
    private double price;

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}

class Order1 {
    private String customerName;
    private List<Product1> products;

    public String getCustomerName() {
        return customerName;
    }

    public List<Product1> getProducts() {
        return products;
    }
}
