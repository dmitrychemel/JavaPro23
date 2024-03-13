package homework_2024_02_14;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentRegistryTest {

    private static final StudentRegistry STUDENT_REGISTRY = new StudentRegistry();
    private static final Student STUDENT_1 = new Student(1, "Jack", "Jack", "jack@gmail.com", 8.2, Major.BUSINESS, 2, true);
    private static final Student STUDENT_2 = new Student(2, "Dan", "Dan", "dan@gmail.com", 7.8, Major.BIOLOGY, 1, true);
    private static final Student STUDENT_3 = new Student(3, "Kim", "Kim", "kim@gmail.com", 8.6, Major.BIOLOGY, 3, false);
    private static final Student STUDENT_4 = new Student(4, "Mel", "Mel", "mel@gmail.com", 6.7, Major.COMPUTER_SCIENCE, 4, false);
    private static final Student STUDENT_5 = new Student(5, "Don", "Don", "don@gmail.com", 7.4, Major.MATHEMATICS, 2, true);

    @BeforeEach
    public void setUp() {
        STUDENT_REGISTRY.getDateBaseStudent().clear();
        STUDENT_REGISTRY.addStudent(STUDENT_1);
        STUDENT_REGISTRY.addStudent(STUDENT_2);
        STUDENT_REGISTRY.addStudent(STUDENT_3);
        STUDENT_REGISTRY.addStudent(STUDENT_4);
        STUDENT_REGISTRY.addStudent(STUDENT_5);
    }
    @Test
    void addStudentTest() {
        Assertions.assertEquals(5, STUDENT_REGISTRY.getDateBaseStudent().size());
    }

    @Test
    void removeStudentTest() {
        STUDENT_REGISTRY.removeStudent(1);
        Assertions.assertEquals(4, STUDENT_REGISTRY.getDateBaseStudent().size());
    }

    @Test
    void findStudentsByMajorTest() {
        List<Student> actual = STUDENT_REGISTRY.findStudentsByMajor("COMPUTER_SCIENCE");
        Assertions.assertEquals(1, actual.size());
    }

    @Test
    void calculateAverageGradeTest() {
        Assertions.assertEquals(7.74, STUDENT_REGISTRY.calculateAverageGrade(), 0.001);
    }

    @Test
    void listStudentsByYearTest() {
        List<Student> actual = STUDENT_REGISTRY.listStudentsByYear(2);
        Assertions.assertEquals(2, actual.size());
    }

    @Test
    void getStudentTest() {
        Assertions.assertEquals(Student.class, STUDENT_REGISTRY.getStudent(1).getClass());
    }

    @Test
    void getTotalNumberOfStudentsTest() {
        Assertions.assertEquals(5, STUDENT_REGISTRY.getDateBaseStudent().size());
    }

    @Test
    void getStudentsWithGradeAboveTest() {
        List<Student> actual = STUDENT_REGISTRY.getStudentsWithGradeAbove(7.5);
        Assertions.assertEquals(3, actual.size());
    }

    @Test
    void getAverageGradeByMajorTest() {
        Assertions.assertEquals(8.2, STUDENT_REGISTRY.getAverageGradeByMajor("BIOLOGY"));
    }

    @Test
    void isStudentPresentTest() {
        Assertions.assertTrue(STUDENT_REGISTRY.isStudentPresent("jack@gmail.com"));
        Assertions.assertFalse(STUDENT_REGISTRY.isStudentPresent("jack1@gmail.com"));
    }
}