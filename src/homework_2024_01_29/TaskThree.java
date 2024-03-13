package homework_2024_01_29;

import java.io.*;

public class TaskThree {
    public static void main(String[] args) {
        copyLastParagraphUsingRandomAccess("story.txt");
    }

    public static void copyLastParagraphUsingRandomAccess(String fileName) {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter("copyLastParagraph"))) {

            long pointer = searchLastParagraph(fileName);
            if(pointer >= 0) {
                for(long i = 0; i < pointer; i++) {
                    reader.read();
                }
            }

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long searchLastParagraph(String fileName) {
        try(RandomAccessFile file = new RandomAccessFile(fileName, "r")) {
            long filePointer = file.length() - 1;

            while (filePointer >= 0) {
                file.seek(filePointer);
                byte currentByte = file.readByte();

                if(currentByte == '\n' || (char) currentByte == '\r') {
                    file.seek(filePointer - 1);
                    byte prevByte = file.readByte();
                    if ((currentByte == '\n' && prevByte == '\r') || prevByte == '\n') {
                        return filePointer;
                    }
                }
                filePointer--;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }
}
