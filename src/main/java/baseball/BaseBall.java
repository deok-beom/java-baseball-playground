package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseBall {
    private Number targetNumber;
    private final List<Discrimination> history = new ArrayList<>();

    public void setNewGame() {
        int num = 0;
        for (int i = 0; i < 3; i++) {
            int digit = 1;
            int random = (int) (Math.random() * 9) + 1;
            num += random * digit;
        }

        this.targetNumber = new Number(num);
    }

    protected void setTargetNumber(Number targetNumber) {
        this.targetNumber = targetNumber;
    }

    public Number getTargetNumber() {
        return this.targetNumber;
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
