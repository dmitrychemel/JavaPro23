package homework_2024_02_07;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task10 {
    public static void main(String[] args) {
        String text = "Apple, orange, and banana are fruits. Dog, cat, and bird are animals.";
        List<String> vowelConsonantWords = findVowelConsonantWords(text);
        for (String word : vowelConsonantWords) {
            System.out.println(word);
        }
    }
    public static List<String> findVowelConsonantWords(String input) {
        ArrayList<String> words = new ArrayList<>();
        String regex = "\\b[aeiouAEIOU][a-zA-Z]*[^aeiouAEIOU]\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            words.add(matcher.group());
        }

        return words;
    }
}
