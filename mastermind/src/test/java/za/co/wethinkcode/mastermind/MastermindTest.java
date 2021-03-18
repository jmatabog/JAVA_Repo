package za.co.wethinkcode.mastermind;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.*;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class MastermindTest {

    @Test
    public void testRunGameCorrectDigitInCorrectPosition() {
        Random mockedCode = Mockito.mock(Random.class);
        when(mockedCode.nextInt(anyInt())).thenReturn(1, 2, 3, 4);

        InputStream inputStream = new ByteArrayInputStream("2345\n".getBytes());
        Mastermind mastermind = new Mastermind(new CodeGenerator(mockedCode), new Player(inputStream));
        System.setIn(inputStream);
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        mastermind.runGame();
        assertEquals("4-digit Code has been set. Digits in range 1 to 8. You have 12 turns to break it.\n" +
                "Input 4 digit code:\n" +
                "Number of correct digits in correct place: 4\n" +
                "Number of correct digits not in correct place: 0\n" +
                "Congratulations! You are a codebreaker!\n" +
                "The code was: 2345", outputStream.toString().trim());
    }

    @Test
    public void testRunGameCorrectDigitOnly() {
        Random mockedCode = Mockito.mock(Random.class);
        when(mockedCode.nextInt(anyInt())).thenReturn(1, 2, 3, 4);

        InputStream inputStream = new ByteArrayInputStream("1234\n2345\n".getBytes());
        Mastermind mastermind = new Mastermind(new CodeGenerator(mockedCode), new Player(inputStream));
        System.setIn(inputStream);
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        mastermind.runGame();
        assertEquals("4-digit Code has been set. Digits in range 1 to 8. You have 12 turns to break it.\n" +
                "Input 4 digit code:\n" +
                "Number of correct digits in correct place: 0\n" +
                "Number of correct digits not in correct place: 3\n" +
                "Turns left: 11\n" +
                "Input 4 digit code:\n" +
                "Number of correct digits in correct place: 4\n" +
                "Number of correct digits not in correct place: 0\n" +
                "Congratulations! You are a codebreaker!\n" +
                "The code was: 2345", outputStream.toString().trim());
    }


}

