package Debugged;

// Caden Pink

// Errors:
//
// Error 1: In main method, scanner does not return user input after spaces.
// Ex: user input "John Doe" only returns "John"
//
// Error 2: Capital letters are not being converted after being input.
// "If the user types in a capital letter, it should be converted to lowercase" - Program Description
//
// Error 3: Output does not display counts for all letters (a-z)
// "The program should print every letter of the alphabet in lower case and the letter’s count" - Program Description
//
// Inefficiency: In displayCounts, foundAny = true is redundant after the first execution of the if block.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a phrase: ");
        String phrase = scan.nextLine().toLowerCase();

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
        return ch >= 'a' && ch <= 'z';
    }

    public static void displayCounts(int[] counts) {
        System.out.println("\nResults:");

        int totalLetters = 0;

        for (int i = 0; i < counts.length; i++) {

            char letter = (char) ('a' + i);
            System.out.println(letter + ": " + counts[i]);
            totalLetters += counts[i];

        }

        if (totalLetters <= 0) {
            System.out.println("No alphabetic characters found in the phrase.");
        }
    }
}