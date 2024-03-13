package homework_2024_01_22;

import java.io.*;

public class TaskTwo {
    public static void main(String[] args) {
        filterAndWriteStreams("task_2024_01_22.txt", 4.5);
    }

    public static void filterAndWriteStreams(String fileName, double threshold) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter("filterStreamsByRate", true))) {

            reader.lines()
                    .filter(currentLine -> Double.parseDouble(currentLine.split(", ")[1]) > threshold)
                    .forEach(currentLine -> {
                        try {
                            writer.write(currentLine + "\n");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
