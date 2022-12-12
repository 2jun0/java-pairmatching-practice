package pairmatching;

import pairmatching.controller.PairMatchingController;
import pairmatching.repository.CrewPairRepository;
import pairmatching.repository.CrewRepository;
import pairmatching.service.CrewPairService;
import pairmatching.service.CrewService;
import pairmatching.view.InputFormatter;
import pairmatching.view.InputParser;
import pairmatching.view.InputValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Application {

    public static void main(String[] args) {
        PairMatchingController controller = new PairMatchingController(
                inputView(), outputView(), crewPairService());
        controller.start();
    }

    private static CrewService crewService() {
        return new CrewService(new CrewRepository());
    }

    private static CrewPairService crewPairService() {
        return new CrewPairService(new CrewPairRepository(), crewService());
    }

    private static InputView inputView() {
        InputValidator inputValidator = new InputValidator();
        InputParser inputParser = new InputParser(inputValidator);
        InputFormatter inputFormatter = new InputFormatter();

        return new InputView(inputValidator, inputFormatter, inputParser);
    }

    private static OutputView outputView() {
        return new OutputView();
    }
}
