package homework_2024_02_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task8 {
    public static void main(String[] args) {
        String ipAddress = "192.168.0.1.txt";
        boolean isValid = isValidIPv4(ipAddress);
        System.out.println("Is valid IPv4 address: " + isValid);
    }

    public static boolean isValidIPv4(String input) {
        String regex = "\\b[0-9]{3}\\.[0-9]{3}\\.[0-9]\\.[0-9]\\.\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        return matcher.find();
    }
}
