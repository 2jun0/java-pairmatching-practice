package pairmatching.controller;

import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.CrewPair;
import pairmatching.domain.Mission;
import pairmatching.dto.MissionSelectCommandDto;
import pairmatching.service.CrewPairService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CrewPairService crewPairService;

    public PairMatchingController(InputView inputView,
            OutputView outputView, CrewPairService crewPairService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.crewPairService = crewPairService;
    }

    public void start() {
        String command = inputView.inputFunctionSelectCommand();

        if ("1".equals(command)) {
            startPairMatch();
        }

        if ("2".equals(command)) {
            searchPairs();
        }
    }

    private void startPairMatch() {
        MissionSelectCommandDto commandDto = inputView.inputMissionSelectCommands();
        Course course = commandDto.course();
        Mission mission = commandDto.mission();

        List<CrewPair> crewPairs = crewPairService.pairMatch(course, mission);
        crewPairService.saveCrewPairs(crewPairs);

        outputView.printPariMatchResult(crewPairs);
    }

    private void searchPairs() {
        MissionSelectCommandDto commandDto = inputView.inputMissionSelectCommands();
        Course course = commandDto.course();
        Mission mission = commandDto.mission();

        List<CrewPair> crewPairs = crewPairService.searchPairs(course, mission);
        outputView.printPariMatchResult(crewPairs);
    }
}
