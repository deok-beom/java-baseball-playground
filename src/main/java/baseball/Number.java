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

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        int[] compare = ((Number) obj).get();

        if (nums.length != compare.length) {
            return false;
        }

        for (int i = 0; i < this.nums.length; i++) {
            if (nums[i] != compare[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        for (int num : nums) {
            hashCode = 31 * hashCode + num;
        }

        return hashCode;
    }
}
