package pt.isec.pa.aulas.exemploFSMjavaFX.model.fsm.states;

import pt.isec.pa.aulas.exemploFSMjavaFX.model.data.GameBWData;
import pt.isec.pa.aulas.exemploFSMjavaFX.model.data.History;
import pt.isec.pa.aulas.exemploFSMjavaFX.model.fsm.GameBWContext;
import pt.isec.pa.aulas.exemploFSMjavaFX.model.fsm.GameBWState;
import pt.isec.pa.aulas.exemploFSMjavaFX.model.fsm.GameBWStateAdapter;

import java.util.List;

public class ShowInfoState extends GameBWStateAdapter {
    public ShowInfoState(GameBWContext context, GameBWData data) {
        super(context, data);
    }

    @Override
    public void start() {
        data.initGame();
        changeState(GameBWState.WAIT_BET);
    }

    @Override
    public GameBWState getState() {
        return GameBWState.SHOW_INFO;
    }

    @Override
    public List<History> getHistory() {
        return data.getHistory();
    }
}
