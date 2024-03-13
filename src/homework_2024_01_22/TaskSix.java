package homework_2024_01_22;

import java.io.*;
import java.util.DoubleSummaryStatistics;

public class TaskSix {
//    Соберите статистику по рейтингам (минимальный, максимальный, средний) и запишите ее в новый файл.
    public static void main(String[] args) {
        writeStatisticsAboutRate("task_2024_01_22.txt");
    }

    public static void writeStatisticsAboutRate(String fileName) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("statisticsAboutRate", true))) {
            writer.write("Max rate - " + maxRateStream(fileName) + "\n");
            writer.write("Minimal rate - " + minimalRateStream(fileName) + "\n");
            writer.write("Average rate - " + averageRateStream(fileName) + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static double minimalRateStream(String fileName) {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines()
                    .mapToDouble(currentLine -> Double.parseDouble(currentLine.split(", ")[1]))
                    .min()
                    .orElse(0.0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static double maxRateStream(String fileName) {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines()
                    .mapToDouble(currentLine -> Double.parseDouble(currentLine.split(", ")[1]))
                    .max()
                    .orElse(0.0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static double averageRateStream(String fileName) {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines()
                    .mapToDouble(currentLine -> Double.parseDouble(currentLine.split(", ")[1]))
                    .average()
                    .orElse(0.0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
