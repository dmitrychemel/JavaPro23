package homework_2024_01_22;

import java.io.*;
import java.util.Comparator;

public class TaskFive {
    public static void main(String[] args) {

    }

    public static void writeMinimalRateStreams(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter("minimalRate"))) {

            double minimalNumber = reader.lines()
                    .map(currentLine -> Double.parseDouble(currentLine.split(", ")[1]))
                    .min(Comparator.naturalOrder())
                    .orElse(0.0);

            reader.lines()
                    .filter(currentLine -> Double.parseDouble(currentLine.split(", ")[1]) == minimalNumber)
                    .forEach(currentLine -> {
                        try {
                            writer.write(currentLine);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
