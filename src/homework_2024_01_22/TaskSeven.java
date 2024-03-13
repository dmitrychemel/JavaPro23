package homework_2024_01_22;

import java.io.*;

public class TaskSeven {
//    Измените названия всех стримов, добавив к ним префикс "Stream-" и запишите обновленные названия в новый файл.
    public static void main(String[] args) {
        changeNameStreams("task_2024_01_22.txt");
    }

    public static void changeNameStreams(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter("changeNameStreams"))) {

            reader.lines()
                    .map(currentLine -> currentLine.replaceAll("Стрим","Stream -"))
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
