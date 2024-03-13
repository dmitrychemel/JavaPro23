package homework_2024_01_22;

import java.io.*;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskTree {
    public static void main(String[] args) {
        writeMapToFile(groupingStreamsByName("task_2024_01_22.txt"));
    }

    public static Map<String, Long> groupingStreamsByName(String fileName) {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            return reader.lines()
                    .map(currentLine -> currentLine.split("[\\[\\]]")[1])
                    .collect(Collectors.groupingBy(name -> name, Collectors.counting()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeMapToFile(Map<String, Long> map) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("groupingStreamsByName", true))) {
            map.entrySet()
                    .forEach(entry -> {
                        try {
                            writer.write(String.valueOf(entry) + "\n");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
