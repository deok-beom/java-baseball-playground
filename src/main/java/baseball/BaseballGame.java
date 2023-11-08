package baseball;

import util.Terminal;

import java.io.IOException;
import java.util.List;

public class BaseballGame {
    public static void main(String[] args) throws IOException {
        while (true) {
            Terminal.out("게임 시작!" + System.lineSeparator());
            Number targetNumber = RandomNumberGenerator.generate();
            BaseballStage stage = new BaseballStage(targetNumber);
            if (proceed(stage)) {
                return;
            }
        }
    }

    private static boolean proceed(BaseballStage stage) throws IOException {
        while (true) {
            boolean proceed = stage.proceed();
            if (proceed) {
                return askPlayEnd(stage.getHistory());
            }
        }
    }

    private static boolean askPlayEnd(List<Discrimination> history) throws IOException {
        while (true) {
            Terminal.out("세 개의 숫자를 모두 맞히셨습니다! 게임 종료" + System.lineSeparator());

            for (Discrimination discrimination : history) {
                Terminal.out(discrimination.show());
            }

            String in = Terminal.in("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." + System.lineSeparator());
            if (in.trim().equals("1")) {
                return false;
            }

            if (in.trim().equals("2")) {
                return true;
            }

            Terminal.out("1과 2중에서 입력해주세요");
        }
    }
}
