package homework_2024_01_22;

import java.io.*;

public class TaskOne {
    public static void main(String[] args) {
        readAndCreateFileAverageRate("task_2024_01_22.txt");
    }

    public static void readAndCreateFileAverageRate(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter("averageRateStreams"))) {
            
            writer.write(String.valueOf(reader.lines()
                    .mapToDouble(currentLine -> Double.parseDouble(currentLine.split(", ")[1]))
                    .average()
                    .orElse(0)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
