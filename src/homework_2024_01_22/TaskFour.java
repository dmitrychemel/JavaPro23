package homework_2024_01_22;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class TaskFour {
    public static void main(String[] args) {
        sortedStreamsByRate("task_2024_01_22.txt");
    }

    public static void sortedStreamsByRate(String fileName) {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter("sortedStreamsByRate", true))) {
            reader.lines()
                    .map(currentLine -> currentLine.split(", "))
                    .sorted(Comparator.comparingDouble((String[] parts) -> Double.parseDouble(parts[1])).reversed())
                    .map(parts -> String.join(", ", parts))
                    .forEach(line -> {
                        try {
                            writer.write(line + "\n");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
