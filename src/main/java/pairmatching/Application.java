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

public class Application {

    public static void main(String[] args) {
        CrewService crewService = crewService();
        CrewPairService crewPairService = crewPairService(crewService);

        PairMatchingController controller = new PairMatchingController(
                inputView(), crewService, crewPairService);
        controller.start();
    }

    private static CrewService crewService() {
        return new CrewService(new CrewRepository());
    }

    private static CrewPairService crewPairService(CrewService crewService) {
        return new CrewPairService(new CrewPairRepository(), crewService);
    }

    private static InputView inputView() {
        InputValidator inputValidator = new InputValidator();
        InputParser inputParser = new InputParser(inputValidator);
        InputFormatter inputFormatter = new InputFormatter();

        return new InputView(inputValidator, inputFormatter, inputParser);
    }
}
