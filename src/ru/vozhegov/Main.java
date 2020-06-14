package ru.vozhegov;

import ru.vozhegov.exception.ValidException;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	    InputOutput inputOutput = new InputOutput();
        Parsing parsing = new Parsing();
        Calculator calculator = new Calculator();
	    while (true) {
            try {
                List<String> expression = parsing.conversionString(inputOutput.input());
                String answer = calculator.calculate(expression);
                inputOutput.output(answer);
            } catch (ArithmeticException e) {
                System.out.println("Введенная строка содержит ошибку ArithmeticException: скорее всего происходит деление на 0");
            } catch (ValidException e) {
                System.out.println("Введенная строка содержит ошибку ValidException: " + e.getMessage());
            }
        }
    }
}
