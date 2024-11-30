package game;

import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        hangman();
    }
    
    static void hangman() {
        Scanner input = new Scanner(System.in);
        
        String word = generateWord();
        String hiddenWord = hideWord(word);
        
        int misses = 0;
        
        while (!hiddenWord.equals(word)) {
            System.out.print("(Guess) Enter a letter in word " + hiddenWord + " > ");
        
            char guess = input.nextLine().charAt(0);
        
            if (hiddenWord.contains(guess + ""))
                System.out.println("\t" + guess + " is already in the word");
        
            else if (word.contains(guess + "")) {
                hiddenWord = updateHiddenWord(word, hiddenWord, guess);
            }
            else {
                System.out.println("\t" + guess + " is not in the word");
                misses++;
            }
        
        }
        
        System.out.println("The word is " + word + ". You missed " + misses +
            (misses != 1? " times" : " time"));
        
        System.out.print("Do you want to guess another word? Enter y or n > ");
        char sentinelValue = Character.toUpperCase(input.nextLine().charAt(0));
        
        if (sentinelValue == 'Y')
            hangman();
        else 
            System.out.println("Thank you for playing ;)");
    }
    
    static String generateWord() {
        String[] words = {"apple", "mango", "banana", "strawberry", "coconut", "peach"};
        
        return words[(int)(Math.random() * words.length)];
    }
    
    static String hideWord(String word) {
        String hiddenWord = "";
        
        for (int i = 0; i < word.length(); i++) {
            hiddenWord += "*";
        }
        
        return hiddenWord;
    }
    
    static String updateHiddenWord(String word, String hiddenWord, char guess) {
        String update = "";
        char ch;
        
        for (int i = 0; i < word.length(); i++) {
            ch = word.charAt(i);
            
            if (hiddenWord.charAt(i) != '*')
                update += hiddenWord.charAt(i);
            else {
                if (ch == guess)
                    update += ch;
                else
                    update += '*';
            }
            
        }
        
        return update;
        
    }
}
