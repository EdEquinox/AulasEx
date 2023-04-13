package pt.isec.pa.aulas.gamebw.model.fsm;

import pt.isec.pa.aulas.gamebw.model.data.GameBWData;
import pt.isec.pa.aulas.gamebw.model.fsm.states.ApostaState;
import pt.isec.pa.aulas.gamebw.model.fsm.states.BeginState;
import pt.isec.pa.aulas.gamebw.model.fsm.states.Lost_WaitDecisionState;

public enum GameBWState {
    BEGIN, APOSTA, LOST_WAITDECISION; // TODO

    static IGameBWState createState(GameBWState type,GameBWContext context, GameBWData data) {
        return switch (type) {
            case BEGIN -> new BeginState(context,data);
            case APOSTA -> new ApostaState(context,data);
            case LOST_WAITDECISION -> new Lost_WaitDecisionState(context,data);
        };
    }
}
