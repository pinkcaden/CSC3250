package Original;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a phrase: ");
        String phrase = scan.next();

        int[] counts = countCharacters(phrase);
        displayCounts(counts);

        scan.close();
    }

    public static int[] countCharacters(String phrase) {
        int[] counts = new int[26];

        for (int i = 0; i < phrase.length(); i++) {
            char ch = phrase.charAt(i);

            if (isAlphabetic(ch)) {
                int index = ch - 'a';
                counts[index]++;
            }
        }

        return counts;
    }

    public static boolean isAlphabetic(char ch) {
        return ch >= 'a' && ch <= 'z'; // ignoring capital letters
    }

    public static void displayCounts(int[] counts) {
        System.out.println("\nResults:");

        boolean foundAny = false;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                char letter = (char) ('a' + i);
                System.out.println(letter + ": " + counts[i]);
                foundAny = true;
            }
        }

        if (!foundAny) {
            System.out.println("No alphabetic characters found in the phrase.");
        }
    }
}