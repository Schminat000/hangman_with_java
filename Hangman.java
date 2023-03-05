package Java;
// Imports user created libraries.
import java.util.ArrayList;
import java.util.Scanner;

// Creates the public class Hangman.
public class Hangman {
    // Defines more private classes.
    private ArrayList<String> words;
    private String wordToGuess;
    private ArrayList<Character> guessedLetters;
    private int remainingGuesses;

    // Prepares the Hangman function. Deals with the words used in the game.
    public Hangman() {
        words = new ArrayList<String>();
        words.add("programming");
        words.add("gaming");
        words.add("java");
        words.add("rocks");
        words.add("minecraft");
        words.add("galaxy");
        words.add("planet");
        words.add("discord");
        words.add("harmony");
        words.add("religion");
        words.add("variables");
        words.add("conditionals");
        words.add("expressions");
        words.add("loops");
        words.add("functions");
        words.add("classes");
        words.add("data");
        words.add("structures");
        words.add("dungeons");
        words.add("dragons");
        words.add("party");
        wordToGuess = words.get((int) (Math.random() * words.size()));
        guessedLetters = new ArrayList<Character>();
        remainingGuesses = 6;
    }

    // Defines the play function. Deals with the background information of figuring
    // out if the word matches the guessing word. Does the inputs.
    public void play() {
        Scanner scanner = new Scanner(System.in);
        try {
            while (remainingGuesses > 0) {
                displayWord();
                System.out.print("Enter a letter: ");
                char letter = scanner.next().charAt(0);
                if (guessedLetters.contains(letter)) {
                    System.out.println("You already guessed that letter.");
                } else {
                    guessedLetters.add(letter);
                    if (wordToGuess.indexOf(letter) == -1) {
                        remainingGuesses--;
                        System.out.println("Sorry, that letter is not in the word. Remaining guesses: " + remainingGuesses);
                    } else {
                        System.out.println("Good guess!");
                    }
                }
                if (wordToGuess.equals(getDisplayWord())) {
                    System.out.println();
                    System.out.println("Congratulations, you won!");
                    return;
                }
            }
            System.out.println();
            System.out.println("Sorry, you lost. The word was " + wordToGuess);
        } finally {
            scanner.close();
        }
    }

    // Outputs the word to be displayed.
    private void displayWord() {
        for (int i = 0; i < wordToGuess.length(); i++) {
            char letter = wordToGuess.charAt(i);
            if (guessedLetters.contains(letter)) {
                System.out.print(letter);
            } else {
                System.out.print("_");
            }
            System.out.print(" ");
        }
        System.out.println();
    }

    // Updates the word to be displayed.
    private String getDisplayWord() {
        StringBuilder displayWord = new StringBuilder();
        for (int i = 0; i < wordToGuess.length(); i++) {
            char letter = wordToGuess.charAt(i);
            if (guessedLetters.contains(letter)) {
                displayWord.append(letter);
            } else {
                displayWord.append("_");
            }
        }
        return displayWord.toString();
    }

    // Runs the game.
    public static void main(String[] args) {
        Hangman game = new Hangman();
        game.play();
    }
}