package homework_2024_02_07;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task9 {
    public static void main(String[] args) {
        String code = "String message = \"Hello, world!\";\n" +
                "String path = \"C:\\\\Program Files\\\\Java\";";
        List<String> stringLiterals = findStringLiterals(code);
        for (String literal : stringLiterals) {
            System.out.println(literal);
        }
    }

    public static List<String> findStringLiterals(String input) {
        ArrayList<String> literals = new ArrayList<>();
        String regex = "\"(?:[^\"\\\\]|\\\\.)*\"";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            literals.add(matcher.group());
        }

        return literals;
    }
}
