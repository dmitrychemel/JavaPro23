package homework_2024_01_29;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TaskFour {
    public static void main(String[] args) {

    }

    public static void copyFileUsingFileStreams(String fileName) throws IOException {
        File file = new File(fileName);

        if (file.createNewFile()) {
            try (FileInputStream inputStream = new FileInputStream(fileName);
                 FileOutputStream outputStream = new FileOutputStream("copy_example.txt")) {

                int readByte;
                while ((readByte = inputStream.read()) != -1) {
                    outputStream.write(readByte);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("File was not created");
        }

    }

    public static void copyFileUsingPath(String sourceFileName, String destFileName) {
        Path sourcePath = Paths.get(sourceFileName);
        Path destPath = Paths.get(destFileName);

        if(!Files.exists(sourcePath)) {
            System.out.println("No file");
        }

        try {
            Files.copy(sourcePath, destPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void copyFileUsingRandomAccessFile(String fileName) {
        try(RandomAccessFile file = new RandomAccessFile(fileName, "r");
        FileOutputStream fileOutputStream = new FileOutputStream("copy_file_task3")) {

            byte[] buffer = new byte[20];
            int bytes = file.read(buffer);

            if(bytes != -1) {
                fileOutputStream.write(buffer, 0, bytes);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
