package pt.isec.pa.aulas.exemploFSMjavaFX.model.fsm.states;

import pt.isec.pa.aulas.exemploFSMjavaFX.model.data.GameBWData;
import pt.isec.pa.aulas.exemploFSMjavaFX.model.fsm.GameBWContext;
import pt.isec.pa.aulas.exemploFSMjavaFX.model.fsm.GameBWState;
import pt.isec.pa.aulas.exemploFSMjavaFX.model.fsm.GameBWStateAdapter;

public class LostWaitDecisionState extends GameBWStateAdapter {
    public LostWaitDecisionState(GameBWContext context, GameBWData data) {
        super(context, data);
    }

    @Override
    public boolean loseWhiteball() {
        if (data.betLost_optionWhite()) {
            changeState(data.bagIsEmpty() ? GameBWState.SHOW_INFO : GameBWState.WAIT_BET);
            return true;
        }
        if (data.bagIsEmpty())
            changeState(GameBWState.SHOW_INFO); // not needed but...!
        return false;
    }

    @Override
    public boolean removeTwoBalls() {
        if (data.bagIsEmpty() && data.getNrWhiteBallsWon()>0)
            return false;
        data.betLost_optionTwoBalls();
        changeState(data.bagIsEmpty() ? GameBWState.SHOW_INFO : GameBWState.WAIT_BET);
        return true;
    }

    @Override
    public GameBWState getState() {
        return GameBWState.LOST_WAIT_DECISION;
    }
}
