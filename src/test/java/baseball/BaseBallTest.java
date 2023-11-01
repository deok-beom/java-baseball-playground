package baseball;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BaseBallTest {

    @Test
    void 컴퓨터가_세_개의_숫자를_선택() {
        // given
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.setNewGame();

        // when
        Number base = baseballGame.getTargetNumber();

        // then
        assertThat(base.get().length).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"135:218", "135:241", "248:435", "248:134", "123:389", "123:739"}, delimiter = ':')
    void one_ball(String targetNumber, String input) {
        // given
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.setTargetNumber(new Number(Integer.parseInt(targetNumber)));
        int compare = Integer.parseInt(input);

        // when
        Discrimination result = baseballGame.discriminate(compare);

        // then
        assertThat(result.getBall()).isEqualTo(1);
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getOut()).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource(value = {"135:213", "135:251", "248:452", "248:854", "123:219", "123:319"}, delimiter = ':')
    void two_ball(String targetNumber, String input) {
        // given
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.setTargetNumber(new Number(Integer.parseInt(targetNumber)));
        int compare = Integer.parseInt(input);

        // when
        Discrimination result = baseballGame.discriminate(compare);

        // then
        assertThat(result.getBall()).isEqualTo(2);
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getOut()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"135:513", "135:351"}, delimiter = ':')
    void three_ball(String targetNumber, String input) {
        // given
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.setTargetNumber(new Number(Integer.parseInt(targetNumber)));
        int compare = Integer.parseInt(input);

        // when
        Discrimination result = baseballGame.discriminate(compare);

        // then
        assertThat(result.getBall()).isEqualTo(3);
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getOut()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"135:148", "135:238", "135:245"}, delimiter = ':')
    void one_strike(String targetNumber, String input) {
        // given
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.setTargetNumber(new Number(Integer.parseInt(targetNumber)));
        int compare = Integer.parseInt(input);

        // when
        Discrimination result = baseballGame.discriminate(compare);

        // then
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getOut()).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource(value = {"135:138", "135:235", "135:145"}, delimiter = ':')
    void two_strike(String targetNumber, String input) {
        // given
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.setTargetNumber(new Number(Integer.parseInt(targetNumber)));
        int compare = Integer.parseInt(input);

        // when
        Discrimination result = baseballGame.discriminate(compare);

        // then
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.getStrike()).isEqualTo(2);
        assertThat(result.getOut()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"135:215", "135:231", "248:438", "248:234", "123:329", "123:139"}, delimiter = ':')
    void one_ball_one_strike(String targetNumber, String input) {
        // given
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.setTargetNumber(new Number(Integer.parseInt(targetNumber)));
        int compare = Integer.parseInt(input);

        // when
        Discrimination result = baseballGame.discriminate(compare);

        // then
        assertThat(result.getBall()).isEqualTo(1);
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getOut()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"135:135", "248:248", "123:123"}, delimiter = ':')
    void three_strike(String targetNumber, String input) {
        // given
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.setTargetNumber(new Number(Integer.parseInt(targetNumber)));
        int compare = Integer.parseInt(input);

        // when
        Discrimination result = baseballGame.discriminate(compare);

        // then
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getOut()).isEqualTo(0);
    }
}