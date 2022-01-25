import java.util.ArrayList;
import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;

public class WordleGame {
    public static void main (String[] args) {
        System.out.print("Guess the WORDLE in 6 tries. \n" +
        "Each guess must be a valid 5 letter word. \n" + 
        "Hit the enter button to submit. \n" +
        "The @ symbol indicates the letter is in the word \n" +
        "The # symbol indicates the letter is in the right place \n\n");

        boolean win = false;
        Scanner scanner = new Scanner(System.in);
        Wordle wordle = new Wordle();
        
        ArrayList<String> words = new ArrayList<String>();
        wordle.loadWords("words.txt", words);
        int choose = (int)(Math.random()*words.size());
        
        String ans = words.get(choose);
        String[] ansArr = words.get(choose).split("");

        while(wordle.returnLives() > 0 && !win){
            String guess = scanner.nextLine();
            wordle.check(guess, ansArr);
            if(guess.equals(ans)){
                win = true;
                System.out.println("\nYOU WIN!");
            }
        }
        if(wordle.returnLives() == 0){
            System.out.println("\nYOU LOSE! THE CORRECT WORD IS: " + ans);
        }
    }
}

