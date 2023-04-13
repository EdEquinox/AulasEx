package pt.isec.pa.aulas.gamebw.model.fsm.states;

import pt.isec.pa.aulas.gamebw.model.data.GameBWData;
import pt.isec.pa.aulas.gamebw.model.fsm.GameBWContext;
import pt.isec.pa.aulas.gamebw.model.fsm.GameBWState;
import pt.isec.pa.aulas.gamebw.model.fsm.GameBWStateAdapter;

public class Lost_WaitDecisionState extends GameBWStateAdapter {

    public Lost_WaitDecisionState(GameBWContext context, GameBWData data) {
        super(context,data);
    }

    @Override
    public GameBWState getState() {
        return GameBWState.LOST_WAITDECISION;
    }

    @Override
    public boolean loseWhiteBall() {
        if (data.betLost_optionWhite()){
            changeState(data.bagIsEmpty() ? GameBWState.BEGIN : GameBWState.APOSTA);
            return true;
        }
        if (data.bagIsEmpty()){
            changeState(GameBWState.BEGIN);
        }
        return false;
    }

    @Override
    public boolean removeTwoBalls() {
        if (data.bagIsEmpty() && data.getNrWhiteBallsWon()>0){
            return false;
        }
        data.betLost_optionTwoBalls();
        changeState(data.bagIsEmpty() ? GameBWState.BEGIN : GameBWState.APOSTA);
        return true;
    }
}
