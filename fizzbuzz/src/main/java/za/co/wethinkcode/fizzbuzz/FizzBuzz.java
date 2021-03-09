package za.co.wethinkcode.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static String checkNumber(int number) {
        boolean divisibleBy3 = number % 3 == 0;
        boolean divisibleBy5 = number % 5 == 0;

        if (divisibleBy3 && divisibleBy5) {
            return "FizzBuzz";
        } else if (divisibleBy3) {
            return "Fizz";
        } else if (divisibleBy5) {
            return "Buzz";
        }
        return String.valueOf(number);
    }

    public static String countTo(int number) {
        List<String> list = new ArrayList<>();
        for (int num = 1; num <= number; num++) {
            list.add(checkNumber(num));
        }
        System.out.println(list);
        return list.toString();
    }

    public static void main(String[] args) {
        countTo(16);
    }
}