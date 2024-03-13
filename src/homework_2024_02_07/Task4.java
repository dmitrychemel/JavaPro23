package homework_2024_02_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    public static void main(String[] args) {
        String email = "user@example.com";
        boolean isValid = isValidEmail(email);
        System.out.println("Is valid email address: " + isValid);
    }
    public static boolean isValidEmail(String input) {
        String regex = "[a-z]*@[a-z]*\\.(com|ru)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        return matcher.find();
    }
}
