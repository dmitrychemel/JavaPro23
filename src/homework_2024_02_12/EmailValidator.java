package homework_2024_02_12;
public class EmailValidator {
    public static void main(String[] args) {
        System.out.println(validateEmail("chemel80@gmail.com"));
    }
    public static boolean validateEmail(String email) {
         String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
         return email.matches(emailRegex);
    }
}

