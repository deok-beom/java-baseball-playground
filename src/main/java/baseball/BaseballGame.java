package baseball;

import util.Terminal;

import java.io.IOException;
import java.util.*;

public class BaseballGame {
    private Number targetNumber;
    private final List<Discrimination> history = new ArrayList<>();

    public void setNewGame() {
        Set<Integer> bucket = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        int num = 0;
        int digit = 1;
        for (int i = 0; i < 3; i++) {
            num += pickNumber(bucket) * digit;
            digit *= 10;
        }

        this.targetNumber = new Number(num);
        this.history.clear();
    }

    private int pickNumber(Set<Integer> bucket) {
        while (true) {
            int random = (int) (Math.random() * 9) + 1;
            if (bucket.contains(random)) {
                bucket.remove(random);
                return random;
            }
        }
    }

    protected void setTargetNumber(Number targetNumber) {
        this.targetNumber = targetNumber;
    }

    public Number getTargetNumber() {
        return this.targetNumber;
    }

    public boolean proceed() throws IOException {
        String in = Terminal.in("숫자를 입력해주세요 : ");
        Discrimination discrimination = discriminate(Integer.parseInt(in));
        Terminal.out(discrimination.print());

        return discrimination.getStrike() == 3;
    }

    public Discrimination discriminate(int answer) {
        Number compare = new Number(answer);
        Discrimination discrimination = new Discrimination(targetNumber, compare);
        history.add(discrimination);
        return discrimination;
    }

    public List<Discrimination> getHistory() {
        return new ArrayList<>(this.history);
    }
}
