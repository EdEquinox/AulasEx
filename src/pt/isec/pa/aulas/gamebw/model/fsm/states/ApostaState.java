package pt.isec.pa.aulas.gamebw.model.fsm.states;

import pt.isec.pa.aulas.gamebw.model.data.BallType;
import pt.isec.pa.aulas.gamebw.model.data.GameBWData;
import pt.isec.pa.aulas.gamebw.model.fsm.*;

public class ApostaState extends GameBWStateAdapter {

    public ApostaState(GameBWContext context, GameBWData data) {
        super(context,data);
    }

    @Override
    public GameBWState getState() {
        return GameBWState.APOSTA;
    }

    @Override
    public BetResult bet(int nWBalls) {
        if (!data.bet(nWBalls)) return BetResult.ERROR;
        BallType ball = data.getBall();
        switch (ball){
            case WHITE -> {
                data.betWon();
                changeState(data.bagIsEmpty() ? GameBWState.BEGIN : GameBWState.APOSTA);
                return BetResult.WIN;
            }
            case BLACK -> {
                data.betLost();
                changeState(data.bagIsEmpty() && data.getNrWhiteBallsWon()<1 ? GameBWState.BEGIN : GameBWState.LOST_WAITDECISION);
                return BetResult.LOST;
            }
            case NONE -> {
                changeState(GameBWState.BEGIN);
            }
        }
        return BetResult.ERROR;
    }

    @Override
    public void end() {
        changeState(GameBWState.BEGIN);
    }
}
