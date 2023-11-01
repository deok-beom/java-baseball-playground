package baseball;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Discrimination {
    private final int strike;
    private final int ball;
    private final int out;

    public Discrimination(Number base, Number compare) {
        int[] baseArr = base.get();
        int[] compareArr = compare.get();

        Map<Integer, Integer> compareMap = new HashMap<>();
        IntStream.range(0, 3).forEach(i -> compareMap.put(compareArr[i], i));

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < baseArr.length; i++) {
            if (compareMap.containsKey(baseArr[i])) {
                if (compareMap.get(baseArr[i]) == i) {
                    strike++;
                } else {
                    ball++;
                }

                compareMap.remove(baseArr[i]);
            }
        }

        this.strike = strike;
        this.ball = ball;
        this.out = compareMap.size();
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        if (getBall() > 0) {
            sb.append(String.format("%d볼 ", getBall()));
        }

        if (getStrike() > 0) {
            sb.append(String.format("%d스트라이크", getStrike()));
        }

        sb.append(System.lineSeparator());
        return sb.toString();
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public int getOut() {
        return out;
    }
}
