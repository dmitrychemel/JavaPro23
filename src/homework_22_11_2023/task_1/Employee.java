package homework_22_11_2023.task_1;

public abstract class Employee implements EmployeeActions{
    private String name;
    private int age;
    private String department;
    private long salary;

    public Employee(String name, int age, String department, long salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public void work() {
        System.out.println("work 7 hour");
    }

    @Override
    public void takeBreak() {
        System.out.println("break 1 hour");
    }

}
