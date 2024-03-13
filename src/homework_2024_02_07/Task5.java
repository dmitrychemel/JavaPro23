package homework_2024_02_07;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {
    public static void main(String[] args) {
        String text = "The price is $10.99, and the weight is 3.5 kg.";
        List<String> floatingPointNumbers = findFloatingPointNumbers(text);
        for (String number : floatingPointNumbers) {
            System.out.println(number);
        }
    }

    public static List<String> findFloatingPointNumbers(String input) {
        List<String> numbers = new ArrayList<>();
        String regex = "\\b[0-9]*\\.[0-9]*\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            numbers.add(matcher.group());
        }
        return numbers;
    }
}
