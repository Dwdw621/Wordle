import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Wordle
{
    private int lives = 6;
    
    public void check(String input, String[] ans){
        if(input.length() == 5 && ifInList(input, "words.txt")){
            String[] guess = input.split("");

            for(int i = 0; i < guess.length; i++){
                if(guess[i].equals(ans[i])){
                    guess[i] = guess[i] + "#";
                }else{
                    for(int a = 0; a < guess.length; a++){
                        if(guess[i].equals(ans[a]) && i != a)
                            guess[i] = guess[i] + "@";
                    }
                }
            }

            lives--;
            System.out.println(toString(guess) + "    LIVES: " + lives);
        } else {
            System.out.println("INVALID WORD LENGTH OR WORD NOT FOUND");
        }
    }

    public String toString(String[] x){
        String str = "";
        for(int i = 0; i < x.length; i++){
            str += x[i] + " ";
        }
        return str;
    }

    public int returnLives(){
        return lives;
    }

    public void loadWords(String filename, ArrayList<String> x){
        File wordfile = new File(filename);
        try {
            Scanner fileScanner = new Scanner(wordfile);
            while(fileScanner.hasNext()){
                String w = fileScanner.nextLine();
                if(w.length() == 5 && !Character.isUpperCase(w.charAt(0))){
                    x.add(w);
                }
            }
        } catch(FileNotFoundException e){
            System.out.println(e);
        }
    }
    
    public boolean ifInList(String x, String filename){
        File wordfile = new File(filename);
        try {
            Scanner fileScanner = new Scanner(wordfile);
            while(fileScanner.hasNext()){
                String w = fileScanner.nextLine();
                if(w.toLowerCase().equals(x)){
                    return true;
                }
            }
        } catch(FileNotFoundException e){
            System.out.println(e);
        }
        return false;
    }
}
