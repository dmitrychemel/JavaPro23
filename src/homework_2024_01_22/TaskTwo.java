package homework_2024_01_22;

import java.io.*;
import java.util.List;

public class TaskTwo {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("f.txt"));
             FileWriter writer = new FileWriter("filterByValue.txt")) {
            List<String> list = reader.lines()
                    .filter(line -> Double.parseDouble(line.split(", ")[1]) > 4.5)
                    .toList();
            for(String str : list) {
                writer.write(str + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
