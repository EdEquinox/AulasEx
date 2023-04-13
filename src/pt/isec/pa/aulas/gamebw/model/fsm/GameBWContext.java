package pt.isec.pa.aulas.gamebw.model.fsm;

import pt.isec.pa.aulas.ex24.models.fsm.ElevatorState;
import pt.isec.pa.aulas.gamebw.model.data.GameBWData;

public class GameBWContext {
    private IGameBWState state;
    private GameBWData data;

    public GameBWContext() {
        data = new GameBWData();
        state = GameBWState.createState(GameBWState.BEGIN,this,data);
    }

    public BetResult bet(int nWBalls){
        return state.bet(nWBalls);
    }

    public boolean loseWhiteBall(){
        return state.loseWhiteBall();
    }

    public boolean removeTwoBalls(){
        return state.removeTwoBalls();
    }

    public void start(){
        state.start();
    }
    public void end(){
        state.end();
    }
    void changeState(IGameBWState newState) {
        state = newState;
    }

    // getters
    public GameBWState getState() {
        if (state == null)
            return null;
        return state.getState();
    }

    public int getNrWhiteBallsWon() {
        return data.getNrWhiteBallsWon();
    }

    public int getNrWhiteBallsOut() {
        return data.getNrWhiteBallsOut();
    }

    public int getNrBlackBallsOut() {
        return data.getNrBlackBallsOut();
    }

    public boolean bagIsEmpty() {
        return data.bagIsEmpty();
    }

}
