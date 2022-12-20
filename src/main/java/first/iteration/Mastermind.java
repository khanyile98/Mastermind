package first.iteration;

import java.util.LinkedList;
import java.util.Random;

public class Mastermind {
    public static LinkedList<Integer> getcode(){
        LinkedList<Integer> code = new LinkedList<Integer>();
        Random random = new Random();

        while (code.size() < 4){
            int number = random.nextInt(9);

            if (number != 0 && !code.contains(number)){
                code.add(number);
            }
        }
        System.out.println("4-digit Code has been set. Digits in range 1 to 8. You have 12 turns to break it.");
        return code;
    }

    public static void main(String[] args) {
        LinkedList<Integer> code = getcode();
        Game game = new Game(code);
        game.runGame();
    }
}
