package za.co.wethinkcode.mastermind;

import org.junit.jupiter.api.Test;

import java.io.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    public void testGetGuessLengthCorrect() {
        InputStream inputStream = new ByteArrayInputStream("1234\n".getBytes());
        System.setIn(inputStream);
        Player player = new Player(inputStream);

        assertEquals("1234", player.getGuess());
    }

    @Test
    public void testGetGuessLengthWrong() {
        InputStream inputStream = new ByteArrayInputStream("123\n1234\n".getBytes());
        System.setIn(inputStream);
        Player player = new Player();
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        player.getGuess();

        assertEquals("Input 4 digit code:\nPlease enter exactly 4 digits (each from 1 to 8).\nInput 4 digit code:", outputStream.toString().trim());
    }

    @Test
    public void testGetGuessQuit() {
        InputStream inputStream = new ByteArrayInputStream("123\nquit\n".getBytes());
        System.setIn(inputStream);
        Player player = new Player();
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        player.getGuess();

        assertEquals("Input 4 digit code:\nPlease enter exactly 4 digits (each from 1 to 8).\nInput 4 digit code:", outputStream.toString().trim());

    }

    @Test
    public void testGetGuessContainZero() {
        InputStream inputStream = new ByteArrayInputStream("123\n0123\n1234\n".getBytes());
        System.setIn(inputStream);
        Player player = new Player();
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        player.getGuess();

        assertEquals("Input 4 digit code:\nPlease enter exactly 4 digits (each from 1 to 8).\nInput 4 digit code:\nPlease enter exactly 4 digits (each from 1 to 8).\nInput 4 digit code:", outputStream.toString().trim());
    }

    @Test
    public void testGetGuessContainNine() {
        InputStream inputStream = new ByteArrayInputStream("123\n6789\n1234\n".getBytes());
        System.setIn(inputStream);
        Player player = new Player();
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        player.getGuess();

        assertEquals("Input 4 digit code:\nPlease enter exactly 4 digits (each from 1 to 8).\nInput 4 digit code:\nPlease enter exactly 4 digits (each from 1 to 8).\nInput 4 digit code:", outputStream.toString().trim());
    }
}
