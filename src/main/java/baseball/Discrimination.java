package baseball;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Discrimination {
    private final int input;
    private final int strike;
    private final int ball;
    private final int out;
    private final String[] visual = new String[3];

    public Discrimination(Number base, Number compare) {
        int[] compareArr = compare.get();
        int input = 0;
        for (int i : compareArr) {
            input = input * 10 + i;
        }
        this.input = input;

        int[] baseArr = base.get();
        Map<Integer, Integer> baseMap = new HashMap<>();
        IntStream.range(0, 3).forEach(i -> baseMap.put(baseArr[i], i));

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < compareArr.length; i++) {
            if (baseMap.containsKey(compareArr[i])) {
                if (baseMap.get(compareArr[i]) == i) {
                    visual[i] = "S";
                    strike++;
                } else {
                    visual[i] = "B";
                    ball++;
                }

                baseMap.remove(baseArr[i]);
            } else {
                visual[i] = "O";
            }
        }

        this.strike = strike;
        this.ball = ball;
        this.out = baseMap.size();
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("[입력:%d] > ", this.input));

        if (ball > 0) {
            sb.append(String.format("%d볼 ", getBall()));
        }

        if (strike > 0) {
            sb.append(String.format("%d스트라이크", getStrike()));
        }

        if (out == 3) {
            sb.append("3아웃!");
        }

        sb.append(System.lineSeparator());
        return sb.toString();
    }

    public String show() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("[입력:%d] > ", this.input));
        for (String s : visual) {
            sb.append(s);
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
