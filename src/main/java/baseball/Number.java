package baseball;

import java.util.Arrays;

public class Number {
    private final int[] nums = new int[3];

    public Number(int number) {
        for (int i = 2; i >= 0; i--) {
            nums[i] = number % 10;
            number = number / 10;
        }
    }

    public int[] get() {
        return Arrays.copyOf(nums, 3);
    }
}
