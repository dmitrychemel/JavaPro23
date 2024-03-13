package homework_2024_01_17;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskFour {
    // под вопросом не могу понять что нуэно собирать и куда
    public static void main(String[] args) {
//        Map<String, Map<String, Double>> 1.String - Студент 2.Предмет 3. балл
    }


    class School {
        private String name;
        private Map<String, List<Student>> studentsByClass;

        public String getName() {
            return name;
        }

        public Map<String, List<Student>> getStudentsByClass() {
            return studentsByClass;
        }
    }

    class Student {
        private String name;
        private List<Subject> subjects;

        public String getName() {
            return name;
        }

        public List<Subject> getSubjects() {
            return subjects;
        }
    }

    class Subject {
        private String name;
        private double score;

        public String getName() {
            return name;
        }

        public double getScore() {
            return score;
        }
    }
}

