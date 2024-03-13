package homework_2024_02_14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRegistry {
    private Map<Integer, Student> dateBaseStudent;

    public StudentRegistry() {
        this.dateBaseStudent = new HashMap<>();
    }

    public Map<Integer, Student> getDateBaseStudent() {
        return dateBaseStudent;
    }

    public void addStudent(Student student) {
        dateBaseStudent.put(student.getId(), student);
    }

    public void removeStudent(int id) {
        dateBaseStudent.remove(id);
    }

    public List<Student> findStudentsByMajor(String major) {
        return dateBaseStudent.values().stream()
                .filter(student -> major.equals(student.getMajor().toString())).
                toList();
    }

    public double calculateAverageGrade() {
        return dateBaseStudent.values().stream()
                .mapToDouble(Student::getGrade)
                .average()
                .orElse(0.0);
    }

    public List<Student> listStudentsByYear(int year) {
        return dateBaseStudent.values().stream()
                .filter(student -> year == student.getYear())
                .toList();
    }

    public Student getStudent(int id) {
        return dateBaseStudent.get(id);
    }

    public int getTotalNumberOfStudents() {
        return dateBaseStudent.size();
    }

    public List<Student> getStudentsWithGradeAbove(double grade) {
        double averageGrade = calculateAverageGrade();
        return dateBaseStudent.values().stream()
                .filter(student -> student.getGrade() > averageGrade)
                .toList();
    }

    public double getAverageGradeByMajor(String major) {
        return dateBaseStudent.values().stream()
                .filter(student -> major.equals(student.getMajor().toString()))
                .mapToDouble(Student::getGrade)
                .average()
                .orElse(0.0);
    }

    public boolean isStudentPresent(String email) {
        return dateBaseStudent.values().stream()
                .anyMatch(student -> email.equals(student.getEmail()));
    }
}
