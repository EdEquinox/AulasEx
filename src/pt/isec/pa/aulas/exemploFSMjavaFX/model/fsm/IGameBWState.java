package pt.isec.pa.aulas.exemploFSMjavaFX.model.fsm;

import pt.isec.pa.aulas.exemploFSMjavaFX.model.fsm.BetResult;
import pt.isec.pa.aulas.exemploFSMjavaFX.model.fsm.GameBWState;

public interface IGameBWState {
    void start();
    void end();
    BetResult bet(int nr_balls);
    boolean loseWhiteball();
    boolean removeTwoBalls();

    GameBWState getState();
}
