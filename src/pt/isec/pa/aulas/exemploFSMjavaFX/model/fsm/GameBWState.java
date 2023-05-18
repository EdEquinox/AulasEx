package pt.isec.pa.aulas.exemploFSMjavaFX.model.fsm;

import pt.isec.pa.aulas.exemploFSMjavaFX.model.data.GameBWData;
import pt.isec.pa.aulas.exemploFSMjavaFX.model.fsm.states.BeginState;
import pt.isec.pa.aulas.exemploFSMjavaFX.model.fsm.states.LostWaitDecisionState;
import pt.isec.pa.aulas.exemploFSMjavaFX.model.fsm.states.WaitBetState;

public enum GameBWState {
    BEGIN, WAIT_BET, LOST_WAIT_DECISION;

    public IGameBWState createState(GameBWContext context, GameBWData data) {
        return switch (this) {
            case BEGIN -> new BeginState(context,data);
            case WAIT_BET -> new WaitBetState(context,data);
            case LOST_WAIT_DECISION -> new LostWaitDecisionState(context,data);
            //default -> null;
        };
    }
}
