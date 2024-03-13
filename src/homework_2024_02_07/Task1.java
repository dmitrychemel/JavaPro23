package homework_2024_02_07;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    public static void main(String[] args) {
        String text = "This is a Test sentence with Some Capitalized Words.";
        List<String> capitalizedWords = findCapitalizedWords(text);
        for (String word : capitalizedWords) {
            System.out.println(word);
        }
    }
    public static List<String> findCapitalizedWords(String input) {
        List<String> words = new ArrayList<>();
        String regex = "\\b[A-Z][a-z]*\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }
}
