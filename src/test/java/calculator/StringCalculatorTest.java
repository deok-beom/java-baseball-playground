package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "6 + 3:9", "5 + 50:55"}, delimiter = ':')
    void 더하기(String input, String expect) {
        //given, when
        double result = StringCalculator.calculate(input);

        //then
        assertThat(result).isEqualTo(Double.parseDouble(expect));
    }

    @ParameterizedTest
    @CsvSource(value = {"1 - 2:-1", "6 - 3:3", "50 - 50:0"}, delimiter = ':')
    void 빼기(String input, String expect) {
        //given, when
        double result = StringCalculator.calculate(input);

        //then
        assertThat(result).isEqualTo(Double.parseDouble(expect));
    }

    @ParameterizedTest
    @CsvSource(value = {"1 / 2:0.5", "6 / 3:2", "5 / 50:0.1"}, delimiter = ':')
    void 나누기(String input, String expect) {
        //given, when
        double result = StringCalculator.calculate(input);

        //then
        assertThat(result).isEqualTo(Double.parseDouble(expect));
    }

    @ParameterizedTest
    @CsvSource(value = {"2 * 2:4", "4 * 3:12", "6 * 14:84", "88 * 55:4840"}, delimiter = ':')
    void 곱하기(String input, String expect) {
        //given, when
        double result = StringCalculator.calculate(input);

        //then
        assertThat(result).isEqualTo(Double.parseDouble(expect));
    }

    @ParameterizedTest
    @CsvSource(value = {"2 * 2 + 4:8", "4 * 3 / 2:6", "6 + 14 / 5:4", "5 - 1 + 4 / 4 * 2:4"}, delimiter = ':')
    void 복잡한_계산(String input, String expect) {
        //given, when
        double result = StringCalculator.calculate(input);

        //then
        assertThat(result).isEqualTo(Double.parseDouble(expect));
    }
}