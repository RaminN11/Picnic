package hw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Picnic {

    public static void main(String[] args) {
        String fileName = "C:\\Users\\Ramin\\IdeaProjects\\Picnic\\src\\hw\\input.txt";

        countWords(fileName);

        String longestWord = findLongestWord(fileName);
        System.out.println("Самое длинное слово в файле " + longestWord);

        wordFrequency(fileName);
    }




    public static void countWords(String fileName) {
        try {
            File file = new File(fileName);
            Scanner iscanner = new Scanner(file);
            int wordCount = 0;

            while(iscanner.hasNext()){
                iscanner.next();
                wordCount+=1;

            }

            System.out.println("Количество слов в файле: " + wordCount);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    public static String findLongestWord(String fileName) {
        String longestWord = "";
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String word = scanner.next();
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return longestWord;
    }



    public static void wordFrequency(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            Map<String, Integer> frequencyMap = new HashMap<>();

            while (scanner.hasNext()) {
                String word = scanner.next();
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }

            System.out.println("Частота слов в файле:");
            for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
