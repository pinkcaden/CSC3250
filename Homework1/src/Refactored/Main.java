
// Caden Pink
// Part 2
package Refactored;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a phrase: ");
        String phrase = scan.nextLine().toLowerCase();

        HashMap<Character, Integer> counts = countCharacters(phrase);
        displayCounts(counts);


        scan.close();
    }

    public static HashMap<Character, Integer> countCharacters(String phrase) {
        HashMap<Character, Integer> counts = new HashMap<>();


        for (int i = 0; i < phrase.length(); i++) {
            char ch = phrase.charAt(i);

            if (isAlphabetic(ch)) {
                counts.put(ch, counts.getOrDefault(ch, 0) + 1);
            }
        }

        return counts;
    }

    public static boolean isAlphabetic(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    public static void displayCounts(HashMap<Character, Integer> counts) {
        System.out.println("\nResults:");

        int totalLetters = 0;

        for (int i = 0; i < 26; i++) {

            char letter = (char) ('a' + i);
            int count = counts.getOrDefault(letter, 0);
            System.out.println(letter + ": " + count);
            totalLetters += count;

        }

        if (totalLetters <= 0) {
            System.out.println("No alphabetic characters found in the phrase.");
        }
    }
}