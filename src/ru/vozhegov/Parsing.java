package ru.vozhegov;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.regex.Pattern;

public class Parsing {
    public Parsing(){
    }

    public List<String> conversionString(String expression) {
        Deque<String> stack = new ArrayDeque<>();
        List<String> exitString = new ArrayList<>();
        for (String string: expression.split("\\s+")) {
            if (isNumber(string)) {
                exitString.add(string);
                continue;
            }
            if (string.equals("+") || string.equals("-") || string.equals("*") || string.equals("/")) {
                String prevOperation = stack.peek();
                if (prevOperation != null) {
                    if (getPriority(string) <= getPriority(prevOperation)) {
                        while (!stack.isEmpty()) {
                            exitString.add(stack.poll());
                        }
                    }
                }
                stack.push(string);
            }
        }
        while (!stack.isEmpty()) {
            exitString.add(stack.poll());
        }
        return exitString;
    }

    private boolean isNumber(String string) {
        Pattern isDouble = Pattern.compile("[0-9]+\\.[0-9]+");
        Pattern isInteger = Pattern.compile("[0-9]+");
        if (isInteger.matcher(string).matches() || isDouble.matcher(string).matches()) {
            return true;
        }
        return false;
    }

    private int getPriority(String operation) {
        if (operation.equals("/") || operation.equals("*")) {
            return 3;
        } else if (operation.equals("+") || operation.equals("-")) {
            return 2;
        }
        return 1;
    }
}
