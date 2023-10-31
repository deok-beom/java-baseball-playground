package calculator;

public class CalculationFactory {

    public static Calculation getCalculation(String operation) {
        if (operation.equals("+")) return new Addition();
        if (operation.equals("-")) return new Subtraction();
        if (operation.equals("*")) return new Multiplication();
        if (operation.equals("/")) return new Division();

        throw new ArithmeticException("연산자가 아닙니다.");
    }
}