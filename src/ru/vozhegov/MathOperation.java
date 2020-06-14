package ru.vozhegov;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathOperation {

    public BigDecimal add(BigDecimal first, BigDecimal second) {
        return first.add(second);
    }

    public BigDecimal subtract(BigDecimal second, BigDecimal first) {
        return first.subtract(second);
    }

    public BigDecimal multiply(BigDecimal first, BigDecimal second) {
        return first.multiply(second);
    }

    public BigDecimal divide(BigDecimal second, BigDecimal first){
        return first.divide(second, 10, RoundingMode.HALF_UP);
    }

}
