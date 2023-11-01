package calculator;

import java.util.HashMap;
import java.util.Map;

public class CalculationFactory {

    private final static Map<String, Calculation> calculations = new HashMap<>();

    static {
        calculations.put("+", new Addition());
        calculations.put("-", new Subtraction());
        calculations.put("*", new Multiplication());
        calculations.put("/", new Division());
    }

    public static Calculation getCalculation(String operation) {
        if (calculations.containsKey(operation)) {
            return calculations.get(operation);
        }

        throw new ArithmeticException("연산자가 아닙니다.");
    }
}