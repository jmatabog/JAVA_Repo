package za.co.wethinkcode.mastermind;

import java.io.InputStream;
import java.util.Scanner;

public class Player {
    private final Scanner inputScanner;

    public Player() {
        this.inputScanner = new Scanner(System.in);
    }

    public Player(InputStream inputStream) {
        this.inputScanner = new Scanner(inputStream);
    }

    /**
     * Gets a guess from user via text console.
     * This must prompt the user to re-enter a guess until a valid 4-digit string is entered, or until the user enters `exit` or `quit`.
     *
     * @return the value entered by the user
     */

    public String getGuess() {

        while (true) {

            String userInput = "";
            System.out.println("Input 4 digit code:");
            userInput = this.inputScanner.nextLine();

            if (inputCheckNumbers(userInput) && userInput.length() == 4 && 
            !(userInput.contains("0") || userInput.contains("9"))) {
                return userInput;

            } else if (userInput.equalsIgnoreCase("quit") || userInput.equalsIgnoreCase("exit")) {
                break;

            } else {
                System.out.println("Please enter exactly 4 digits (each from 1 to 8).");
            }
        }
        return "";
    }

    private boolean inputCheckNumbers(String s){
        try{
            Integer.parseInt(s);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}