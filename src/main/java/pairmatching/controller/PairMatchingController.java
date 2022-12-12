package pairmatching.controller;

import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.CrewPair;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.dto.MissionSelectCommandDto;
import pairmatching.service.CrewPairService;
import pairmatching.service.CrewService;
import pairmatching.view.InputView;

public class PairMatchingController {

    private final InputView inputView;
    private final CrewService crewService;
    private final CrewPairService crewPairService;

    public PairMatchingController(InputView inputView, CrewService crewService,
            CrewPairService crewPairService) {
        this.inputView = inputView;
        this.crewService = crewService;
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
        Level level = commandDto.level();
        Course course = commandDto.course();
        Mission mission = commandDto.mission();

        List<CrewPair> crewPairs = crewPairService.pairMatch(level, course);
        crewPairService.saveCrewPairs(level, crewPairs);
    }
}
