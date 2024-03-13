package homework_2024_01_22;

import java.io.*;

public class TaskEight {
//    Отфильтруйте стримы с рейтингом ниже 4.7 и преобразуйте их названия, добавив в конец "- Low Rated". Запишите результаты в новый файл.
    public static void main(String[] args) {
        filterAndWriteLowRateStream("task_2024_01_22.txt", 4.7);

    }

    public static void filterAndWriteLowRateStream(String fileName, double threshold) {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter("filterLowRate"))) {

            reader.lines()
                    .filter(currentLine -> Double.parseDouble(currentLine.split(", ")[1]) < threshold)
                    .map(currentLine -> currentLine.split(", "))
                    .map(parts -> String.join(", ", parts))
                    .map(newLine -> newLine + " - Low Rated")
                    .forEach(currentLine -> {
                        try {
                            writer.write(currentLine +"\n");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
