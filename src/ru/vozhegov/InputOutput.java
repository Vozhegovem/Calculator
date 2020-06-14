package ru.vozhegov;

import ru.vozhegov.exception.ValidException;

import java.util.Scanner;

public class InputOutput {
    private Valid valid = new Valid();

    public String input() throws ValidException {
        Scanner scannerMathExpression = new Scanner(System.in);
        System.out.println("Введите математическое выражение (каждый знак и число вводится через пробел):");
        String mathExpression = scannerMathExpression.nextLine();
        valid.isValid(mathExpression);
        return mathExpression;
    }

    public void output(String answer) {
        System.out.println(answer);
    }
}
