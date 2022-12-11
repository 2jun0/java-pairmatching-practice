package pairmatching.controller;

import pairmatching.view.InputView;

public class PairMatchingController {

    private final InputView inputView;

    public PairMatchingController(InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        String command = inputView.inputFunctionSelectCommand();

        if ("1".equals(command)) {
            startPairMatch();
        }
    }

    private void startPairMatch() {
        String commands = inputView.inputMissionSelectCommands();
    }
}
