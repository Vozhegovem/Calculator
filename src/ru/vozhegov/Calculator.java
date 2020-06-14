package ru.vozhegov;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Calculator {
    public Calculator() {
    }

    private Deque<String> stack = new ArrayDeque<>();

    public String calculate(List<String> parsingString) throws ArithmeticException {
        MathOperation operation = new MathOperation();
        for (String string: parsingString) {
            if (string.equals("+")) {
                BigDecimal add = operation.add(new BigDecimal(stack.poll()), new BigDecimal(stack.poll()));
                stack.push(add.toString());
                continue;
            }
            if (string.equals("-")) {
                BigDecimal subtract = operation.subtract(new BigDecimal(stack.poll()), new BigDecimal(stack.poll()));
                stack.push(subtract.toString());
                continue;
            }
            if (string.equals("*")) {
                BigDecimal multiply = operation.multiply(new BigDecimal(stack.poll()), new BigDecimal(stack.poll()));
                stack.push(multiply.toString());
                continue;
            }
            if (string.equals("/")) {
                BigDecimal divide = operation.divide(new BigDecimal(stack.poll()), new BigDecimal(stack.poll()));
                stack.push(divide.toString());
                continue;
            }
            stack.push(string);
        }
        return stack.poll();
    }
}
