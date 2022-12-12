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
        while (true) {
            String command = inputView.inputFunctionSelectCommand();

            if ("Q".equals(command)) {
                break;
            }

            runFunction(command);
        }
    }

    private void runFunction(String command) {
        if ("1".equals(command)) {
            startPairMatch();
        }

        if ("2".equals(command)) {
            searchPairs();
        }

        if ("3".equals(command)) {
            resetPairs();
        }
    }

    private void startPairMatch() {
        MissionSelectCommandDto commandDto = inputView.inputMissionSelectCommands();
        Course course = commandDto.course();
        Mission mission = commandDto.mission();

        if (!checkHavingBeenPairMatched(course, mission)) {
            return;
        }

        List<CrewPair> crewPairs = crewPairService.pairMatch(course, mission);
        crewPairService.saveCrewPairs(crewPairs);

        outputView.printPariMatchResult(crewPairs);
    }

    private boolean checkHavingBeenPairMatched(Course course, Mission mission) {
        if (crewPairService.hasBeenPairMatched(course, mission)) {
            if (!inputView.askReMatch()) {
                return false;
            }

            crewPairService.clearPairsByCourseAndMission(course, mission);
        }

        return true;
    }

    private void searchPairs() {
        MissionSelectCommandDto commandDto = inputView.inputMissionSelectCommands();
        Course course = commandDto.course();
        Mission mission = commandDto.mission();

        List<CrewPair> crewPairs = crewPairService.searchPairs(course, mission);
        outputView.printPariMatchResult(crewPairs);
    }

    private void resetPairs() {
        crewPairService.resetPairs();
        outputView.printResetComplete();
    }
}
