package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.function.Supplier;
import pairmatching.dto.MissionSelectCommandDto;

public class InputView {

    private final InputValidator inputValidator;
    private final InputFormatter inputFormatter;
    private final InputParser inputParser;

    public InputView(InputValidator inputValidator, InputFormatter inputFormatter,
            InputParser inputParser) {
        this.inputValidator = inputValidator;
        this.inputFormatter = inputFormatter;
        this.inputParser = inputParser;
    }

    public MissionSelectCommandDto inputMissionSelectCommands() {
        return repeatUntilSuccess(this::tryInputMissionSelectCommands);
    }

    private MissionSelectCommandDto tryInputMissionSelectCommands() {
        String formattedMessage = inputFormatter.formatInputMissionSelectCommands();
        printLine(formattedMessage);

        String commands = readLine();
        return inputParser.parseMissionSelectCommands(commands);
    }

    public String inputFunctionSelectCommand() {
        return repeatUntilSuccess(this::tryInputFunctionSelectCommand);
    }

    private String tryInputFunctionSelectCommand() {
        printLine("기능을 선택하세요.");
        printLine("1. 페어 매칭");
        printLine("2. 페어 조회");
        printLine("3. 페어 초기화");
        printLine("Q. 종료");

        String command = readLine();
        inputValidator.validateFunctionSelectCommand(command);

        return command;
    }

    private String readLine() {
        return Console.readLine().trim();
    }

    private void printLine(String s) {
        System.out.println(s);
    }

    private <T> T repeatUntilSuccess(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                printLine("[ERROR] " + e.getMessage());
            }
        }
    }
}
