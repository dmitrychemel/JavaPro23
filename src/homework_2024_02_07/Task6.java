package homework_2024_02_07;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task6 {
    public static void main(String[] args) {
        String html = "<a href=\"https://www.example.com\">Example</a> " +
                "<a href=\"https://www.google.com\">Google</a>";
        List<String> extractedLinks = extractLinks(html);
        for (String link : extractedLinks) {
            System.out.println(link);
        }
    }

    public static List<String> extractLinks(String html) {
        List<String> links = new ArrayList<>();
        String regex = "<a\\s+href=\"([^\"]*)\"[^>]*>";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(html);

        while (matcher.find()) {
            links.add(matcher.group(1));
        }

        return links;
    }
}
