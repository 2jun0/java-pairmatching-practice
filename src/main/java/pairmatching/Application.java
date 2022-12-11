package pairmatching;

import pairmatching.controller.PairMatchingController;
import pairmatching.view.InputFormatter;
import pairmatching.view.InputParser;
import pairmatching.view.InputValidator;
import pairmatching.view.InputView;

public class Application {
    public static void main(String[] args) {
        PairMatchingController controller = new PairMatchingController(inputView());
        controller.start();
    }

    private static InputView inputView() {
        InputValidator inputValidator = new InputValidator();
        InputParser inputParser = new InputParser(inputValidator);
        InputFormatter inputFormatter = new InputFormatter();

        return new InputView(inputValidator, inputFormatter, inputParser);
    }
}
