package homework_2023_12_18;

import java.util.*;

public class Task7 {
//    Создайте функциональный интерфейс TextAnalyzer с методом analyze, который принимает текст и анализирует его, возвращая результат анализа.
//    Напишите метод, который принимает строку и TextAnalyzer, и подсчитывает количество уникальных слов в тексте.

    public static void main(String[] args) {
        String text = "Hello world My name is Java Hello Java";
        analyzer(text, text1 -> {
            String[] words = text1.split(" ");
            Set<String> uniqueList = new HashSet<>(Arrays.asList(words));
            return uniqueList.size();
        });
    }

    public static int analyzer(String text, TextAnalyzer textAnalyzer) {
        return textAnalyzer.analyze(text);
    }

}

interface TextAnalyzer {
    int analyze(String str);
}
