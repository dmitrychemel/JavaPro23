package homework_2023_11_22.task_1;

public class Department implements DepartmentOperations {
    private String departmentName;
    private Employee[] employees;
    private int currentSize;
    private int maxSize;

    public Department(String departmentName, int currentSize, int maxSize) {
        this.departmentName = departmentName;
        this.currentSize = currentSize;
        this.maxSize = maxSize;
        employees = new Employee[0];
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    @Override
    public void addEmployee(Employee employee) {
        Employee[] newEmployee = new Employee[employees.length + 1];
        System.arraycopy(employees, 0, newEmployee, 0, employees.length);
        newEmployee[employees.length] = employee;
        setEmployees(newEmployee);
    }

    @Override
    public void removeEmployee(String name) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].equals(name)) {
                Employee[] newEmployee = new Employee[employees.length - 1];
                System.arraycopy(employees, 0, newEmployee, 0, i);
                System.arraycopy(employees, i + 1, newEmployee, 0, employees.length - i - 1);
                setEmployees(newEmployee);
            }
        }
    }
}
