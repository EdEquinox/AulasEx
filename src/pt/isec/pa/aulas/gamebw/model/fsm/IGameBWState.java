package pt.isec.pa.aulas.gamebw.model.fsm;

public interface IGameBWState {

    GameBWState getState();

    boolean removeTwoBalls();

    boolean loseWhiteBall();

    void start();
    void end();
    BetResult bet(int nWBalls);
}
