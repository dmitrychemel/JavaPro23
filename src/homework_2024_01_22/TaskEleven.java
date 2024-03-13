package homework_2024_01_22;

import java.io.*;

public class TaskEleven {
    public static void main(String[] args) {
        writeAllNameStreams("task_2024_01_22.txt");
    }

    public static void writeAllNameStreams(String nameFile) {
        try(BufferedReader reader = new BufferedReader(new FileReader(nameFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter("allNameStreams"))) {

            reader.lines()
                    .map(currentLine -> currentLine.split("[\\[\\]]")[1])
                    .forEach(part -> {
                        try {
                            writer.write(part +", ");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
