package pt.isec.pa.aulas.exemploFSMjavaFX.model.fsm.states;

import pt.isec.pa.aulas.exemploFSMjavaFX.model.data.GameBWData;
import pt.isec.pa.aulas.exemploFSMjavaFX.model.fsm.GameBWContext;
import pt.isec.pa.aulas.exemploFSMjavaFX.model.fsm.GameBWState;
import pt.isec.pa.aulas.exemploFSMjavaFX.model.fsm.GameBWStateAdapter;

public class BeginState extends GameBWStateAdapter {
    public BeginState(GameBWContext context, GameBWData data) {
        super(context, data);
    }

    @Override
    public void start() {
        data.initGame();
        changeState(GameBWState.WAIT_BET);
    }

    @Override
    public GameBWState getState() {
        return GameBWState.BEGIN;
    }
}
