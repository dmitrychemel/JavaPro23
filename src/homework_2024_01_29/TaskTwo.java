package homework_2024_01_29;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TaskTwo {
    public static void main(String[] args) {
        findTxtFilesInDirectory(new File("D:\\"), ".txt");
    }

    public static void findTxtFilesInDirectory(File root, String format) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("filesTxt"))) {
            if (root.isDirectory()) {
                File[] directoryFiles = root.listFiles();
                if (directoryFiles != null) {
                    for (File file : directoryFiles) {
                        if (file.isDirectory()) {
                            findTxtFilesInDirectory(file, format);
                        } else {
                            if (file.getName().toLowerCase().endsWith(format)) {
                                writer.write(file.getAbsoluteFile() + "\n");
                            }
                        }
                    }
                }
            } else {
                if (root.getName().toLowerCase().endsWith(format)) {
                    writer.write(root.getAbsoluteFile() + "\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
