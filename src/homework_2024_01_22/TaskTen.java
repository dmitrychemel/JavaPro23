package homework_2024_01_22;

import java.io.*;

public class TaskTen {
    public static void main(String[] args) {
        writeNewFile("task_2024_01_22.txt");
    }

    public static void writeNewFile(String fileName) {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter("newFileStreams"))) {

            reader.lines()
                    .map(currentLine -> currentLine.split(", "))
                    .forEach(parts -> {
                        String id = parts[0].split(": ")[0];
                        String name = parts[0].split("[\\[\\]]")[1];
                        String rate = parts[1];

                        try {
                            writer.write(id + ": " + name + " - " + rate + "\n");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
