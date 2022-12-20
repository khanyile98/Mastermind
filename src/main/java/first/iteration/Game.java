package first.iteration;

import java.util.*;
import java.util.regex.*;

public class Game {
    public final LinkedList<Integer> code;
    private Scanner scan = new Scanner(System.in);
    public int correctInCorrectPlace , correctOnly;

    public Game(LinkedList<Integer> code){
        this.code = code;
        this.correctInCorrectPlace = 0;
        this.correctOnly = 0;
    }

    public LinkedList<Integer> getUserGuess(){
        System.out.print("Input 4 digit code: ");
        String guess = this.scan.nextLine();
        LinkedList<Integer> guessList = new LinkedList<Integer>();

        while (!Pattern.matches("[0-9]{4}", guess) || guess.length() != 4){
            System.out.println("Please enter exactly 4 digits.");
            System.out.print("Input 4 digit code: ");

            guess = this.scan.nextLine();
        }

        for (char c: guess.toCharArray()){
            guessList.add(Character.getNumericValue(c));
        }
        return guessList;
    }


    public void EvaluateInput(LinkedList<Integer> guess){

        for (int i=0; i < guess.size(); i++){
            if (guess.get(i) == code.get(i)){
                this.correctInCorrectPlace++;
            }
            else if (guess.get(i) != code.get(i) && code.contains(guess.get(i))){
                this.correctOnly++;
            }
        }
        System.out.println("Number of correct digits in correct place: " + this.correctInCorrectPlace);
        System.out.println("Number of correct digits not in correct place: " + this.correctOnly);
        
    }


    public void runGame(){
        int turns = 12;
        System.out.println(String.valueOf(code));

        while (turns > 0){
            LinkedList<Integer> guess = this.getUserGuess();
            this.EvaluateInput(guess);
            this.correctInCorrectPlace = 0;
            this.correctOnly = 0;

            if (guess.equals(code)){
                System.out.println("Congratulations! You are a codebreaker!");
                break;
            }else{
                turns--;
                System.out.println("Wrong! Guess again.");
                System.out.println("Turns left: " + turns);
            }
        }
        System.out.println("The code was: " + code);
    }


}
