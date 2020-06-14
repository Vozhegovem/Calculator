package ru.vozhegov;

import ru.vozhegov.exception.ValidException;

import java.util.regex.Pattern;

public class Valid {

    public boolean isValid(String expression) throws ValidException {
        expression = expression.replaceAll("\\s+", "");

        if (expression.isEmpty()) {
            throw new ValidException("Необходимо ввести математиеское выражение!");
        }

        Pattern badEnd = Pattern.compile("[\\D]$");
        if (badEnd.matcher(expression).find()) {
            throw new ValidException("Необходимо, чтобы математическое выражение заканчивалось числом");
        }

        Pattern hasLetter = Pattern.compile("[a-zA-Zа-яА-Я]");
        if (hasLetter.matcher(expression).find()) {
            throw new ValidException("Необходимо, чтобы математическое выражение не содержало букв!");
        }

        Pattern hasNotOperation = Pattern.compile("(\\+)|(\\-)|(\\*)|(\\/)");
        if (!hasNotOperation.matcher(expression).find()) {
            throw new ValidException("Необходимо, чтобы математическое выражение содержало математические операторы!");
        }

        Pattern hasRepeatOperation = Pattern.compile("(\\+\\+)+|(\\-\\-)+|(\\*\\*)+|(\\/\\/)+");
        if (hasRepeatOperation.matcher(expression).find()) {
            throw new ValidException("Необходимо, чтобы математическое выражение не содержало повторяющихся операторов!");
        }
        return true;
    }
}
