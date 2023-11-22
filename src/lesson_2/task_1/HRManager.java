package lesson_2.task_1;

public class HRManager implements EmployeeActions{
    private int numberOfRecruitments;
    private String [] candidateList;

    public HRManager(int numberOfRecruitments, String[] candidateList) {
        this.numberOfRecruitments = numberOfRecruitments;
        this.candidateList = candidateList;
    }

    @Override
    public void work() {
        System.out.println("work 5 hour");

    }

    @Override
    public void takeBreak() {
        System.out.println("break 1,45 hour");
    }
}
