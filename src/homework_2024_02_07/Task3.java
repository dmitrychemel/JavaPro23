package homework_2024_02_07;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    public static void main(String[] args) {
        String text = "Visit example.com for more information. Also, check out google.com";
        List<String> domains = findDomains(text);
        for (String domain : domains) {
            System.out.println(domain);
        }

    }

    public static List<String> findDomains(String input) {
        List<String> domains = new ArrayList<>();
        String regex = "[a-z]*\\.(com|ru)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            domains.add(matcher.group());
        }

        return domains;
    }
}
