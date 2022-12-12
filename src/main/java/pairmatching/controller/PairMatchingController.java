package pairmatching.controller;

import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.CrewPair;
import pairmatching.domain.Mission;
import pairmatching.dto.MissionSelectCommandDto;
import pairmatching.service.CrewPairService;
import pairmatching.view.InputView;

public class PairMatchingController {

    private final InputView inputView;
     private final CrewPairService crewPairService;

    public PairMatchingController(InputView inputView,
            CrewPairService crewPairService) {
        this.inputView = inputView;
        this.crewPairService = crewPairService;
    }

    public void start() {
        String command = inputView.inputFunctionSelectCommand();

        if ("1".equals(command)) {
            startPairMatch();
        }
    }

    private void startPairMatch() {
        MissionSelectCommandDto commandDto = inputView.inputMissionSelectCommands();
        Course course = commandDto.course();
        Mission mission = commandDto.mission();

        List<CrewPair> crewPairs = crewPairService.pairMatch(course, mission);
        crewPairService.saveCrewPairs(crewPairs);
    }
}
