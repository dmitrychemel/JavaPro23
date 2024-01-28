package homework_2024_01_22;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskThree {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("f.txt"));
             FileWriter writer = new FileWriter("MapCountStream.txt")) {
            Map<String, Long> map = reader.lines()
                    .collect(Collectors.groupingBy(e -> e.split("[\\[\\]]")[1], Collectors.counting()));
            for(Map.Entry<String, Long> entry : map.entrySet()) {
                writer.write(entry.getKey() + " count: " + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
