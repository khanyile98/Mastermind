package first.iteration;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;


public class TestGame {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream origionalOut = System.out;
    private final PrintStream origionalErr = System.out;
    private LinkedList<Integer> code = new LinkedList<Integer>();
    private Game game;


    @Before
    public void setUp(){
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

        for (int i = 1; i < 5; i++){
            code.add(i);
        }
        this.game = new Game(code);
    }

    @After
    public void restore(){
        System.setOut(origionalOut);
        System.setErr(origionalErr);
    }

    @Test
    public void testEvaluateInputFull(){
        Integer[] arr = {1, 2, 3, 4};
        LinkedList<Integer> guess = new LinkedList<Integer>(Arrays.asList(arr));

        game.EvaluateInput(guess);
        assertEquals(4, game.correctInCorrectPlace);
    }

    @Test
    public void testEvaluateInputFull2(){
        Integer[] arr = {1, 2, 3, 4};
        LinkedList<Integer> guess = new LinkedList<Integer>(Arrays.asList(arr));

        game.EvaluateInput(guess);
        assertEquals(0, game.correctOnly);
    }

    @Test
    public void testEvaluateInputHalf(){
        Integer[] arr = {2, 8, 3, 4};
        LinkedList<Integer> guess = new LinkedList<Integer>(Arrays.asList(arr));

        game.EvaluateInput(guess);
        assertEquals(1, game.correctOnly);
    }

    @Test
    public void testEvaluateInputHalf2(){
        Integer[] arr = {2, 8, 3, 4};
        LinkedList<Integer> guess = new LinkedList<Integer>(Arrays.asList(arr));

        game.EvaluateInput(guess);
        assertEquals(2, game.correctInCorrectPlace);
    }


}
