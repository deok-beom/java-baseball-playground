import baseball.BaseballGame;
import util.Terminal;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BaseballGame stage = new BaseballGame();

        while (true) {
            stage.setNewGame();
            if (proceed(stage)) {
                return;
            }
        }
    }

    private static boolean proceed(BaseballGame stage) throws IOException {
        while (true) {
            boolean proceed = stage.proceed();
            if (proceed) {
                return askPlayEnd();
            }
        }
    }

    private static boolean askPlayEnd() throws IOException {
        while (true) {
            Terminal.out("세 개의 숫자를 모두 맞히셨습니다! 게임 종료");
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
