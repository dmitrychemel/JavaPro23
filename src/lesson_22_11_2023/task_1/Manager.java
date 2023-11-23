package lesson_22_11_2023.task_1;

public class Manager extends Employee implements EmployeeActions{
    private int teamSize;
    private Employee[] teamMembers;

    public Manager(String name, int age, String department, long salary, int teamSize, Employee[] teamMembers) {
        super(name, age, department, salary);
        this.teamSize = teamSize;
        this.teamMembers = teamMembers;
    }

    @Override
    public void work() {
        System.out.println("work 8 hour");

    }

    @Override
    public void takeBreak() {
        System.out.println("break 1,15 hour");
    }
}
