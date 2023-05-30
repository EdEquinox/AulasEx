package pt.isec.pa.aulas.exemploFSMjavaFX.model.fsm;

import pt.isec.pa.aulas.exemploFSMjavaFX.model.data.History;
import pt.isec.pa.aulas.exemploFSMjavaFX.model.fsm.BetResult;
import pt.isec.pa.aulas.exemploFSMjavaFX.model.fsm.GameBWState;

import java.util.List;

public interface IGameBWState {
    void start();
    void end();
    BetResult bet(int nr_balls);
    boolean loseWhiteball();
    boolean removeTwoBalls();

    GameBWState getState();
    List<History> getHistory();
}
