package homework_2024_02_12;

public class Employee {
    public static final String SPACE = " ";
    public static final String POINT = ".";
    private String firstName;
    private String lastName;
    
    public String getFullName() {
        return firstName + SPACE + lastName;
    }
    
    public String getInitials() {
        return firstName.charAt(0) + POINT + lastName.charAt(0) + POINT;
    }

    // Дублирование кода формирования email
    public String getEmail() {
//        return (firstName + POINT + lastName + "@company.com").toLowerCase();
        return (getFullName().replace(SPACE, POINT) + "@company.com").toLowerCase();
    }
}

