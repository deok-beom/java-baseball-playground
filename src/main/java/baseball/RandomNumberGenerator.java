package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {
    public static Number generate() {
        List<Integer> bucket = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(bucket);

        int num = 0;
        for (int i = 0; i < 3; i++) {
            num = num * 10 + bucket.get(i);
        }

        return new Number(num);
    }
}
