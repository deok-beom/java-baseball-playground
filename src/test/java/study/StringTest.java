package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void request_1() {
        //given, when
        String[] split1 = "1,2".split(",");
        String[] split2 = "1,".split(",");

        //then
        assertThat(split1).contains("1", "2");
        assertThat(split2).containsExactly("1");
    }

    @Test
    void request_2() {
        //given, when
        String substring = "(1,2)".substring(1, 4);

        //then
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    void request_3() {
        //given
        String base = "abc";

        //when
        char a = base.charAt(0);
        char b = base.charAt(1);
        char c = base.charAt(2);

        //then
        assertThat(a).isEqualTo('a');
        assertThat(b).isEqualTo('b');
        assertThat(c).isEqualTo('c');
        Assertions.assertThatThrownBy(() -> base.charAt(3))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }
}
