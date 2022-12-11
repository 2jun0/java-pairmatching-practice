package pairmatching.view;

public class InputValidator {

    void validateFunctionSelectCommand(String command) {
        if (!command.matches("^1|2|3|q$")) {
            throw new IllegalArgumentException("잘못 입력하셨습니다. 다시 입력해주세요.");
        }
    }
}
