package homework_2024_01_29;

import java.io.*;

public class TaskOne {
    public static void main(String[] args) {
        countWordsInFile("task_2024_01_24.txt");
    }

    public static void countWordsInFile(String fileName) {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter("countWordInFile"))) {

            int sum = reader.lines()
                    .mapToInt(line -> line.split("\\s+").length)
                    .sum();

            writer.write("Количество слов - " + sum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


