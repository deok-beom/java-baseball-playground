package calculator;

public class StringCalculator {

    public static double calculate(String s) {
        String[] split = s.split(" ");
        String[] operators = getOperators(split);
        int[] numbers = getNumbers(split);

        double result = numbers[0];
        for (int i = 0; i < operators.length; i++) {
            result = CalculationFactory.getCalculation(operators[i])
                    .calculate(result, numbers[i + 1]);
        }

        return result;
    }

    private static String[] getOperators(String[] arr) {
        String[] operators = new String[arr.length / 2];
        for (int i = 1; i < arr.length; i = i + 2) {
            operators[i / 2] = arr[i];
        }
        return operators;
    }

    private static int[] getNumbers(String[] arr) {
        int[] numbers = new int[arr.length - arr.length / 2];
        for (int i = 0; i < arr.length; i = i + 2) {
            numbers[i / 2] = Integer.parseInt(arr[i]);
        }
        return numbers;
    }
}

