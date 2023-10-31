package calculator;

public class StringCalculator {

    public static double calculate(String s) {
        String[] split = s.split(" ");
        String[] operators = new String[split.length / 2];
        int[] numbers = new int[split.length - split.length / 2];
        for (int i = 1; i < split.length; i = i + 2) {
            operators[i / 2] = split[i];
        }

        for (int i = 0; i < split.length; i = i + 2) {
            numbers[i / 2] = Integer.parseInt(split[i]);
        }

        double result = numbers[0];
        for (int i = 0; i < operators.length; i++) {
            if (operators[i].equals("+")) result = result + numbers[i + 1];
            if (operators[i].equals("-")) result = result - numbers[i + 1];
            if (operators[i].equals("/")) result = result / numbers[i + 1];
            if (operators[i].equals("*")) result = result * numbers[i + 1];
        }

        return result;
    }
}

