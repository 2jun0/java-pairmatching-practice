package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputSelectCommand() {
        printLine("기능을 선택하세요.");
        printLine("1. 페어 매칭");
        printLine("2. 페어 조회");
        printLine("3. 페어 초기화");
        printLine("Q. 종료");

        String command = readLine();
        return command;
    }

    private String readLine() {
        return Console.readLine().trim();
    }

    private void printLine(String s) {
        System.out.println(s);
    }
}
