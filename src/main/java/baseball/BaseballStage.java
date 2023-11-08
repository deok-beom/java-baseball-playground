package baseball;

import util.Terminal;

import java.io.IOException;
import java.util.*;

public class BaseballStage {
    private final Number targetNumber;
    private final List<Discrimination> history = new ArrayList<>();

    public BaseballStage(Number number) {
        this.targetNumber = number;
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
