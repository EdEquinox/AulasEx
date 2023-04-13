package pt.isec.pa.aulas.gamebw.model.fsm;

import pt.isec.pa.aulas.gamebw.model.data.GameBWData;

public abstract class GameBWStateAdapter implements IGameBWState {
    protected GameBWContext context;
    protected GameBWData data;

    protected GameBWStateAdapter(GameBWContext context, GameBWData data) {
        this.context = context;
        this.data = data;
    }

    protected void changeState(GameBWState newState) {
        context.changeState(GameBWState.createState(newState,context,data));
    }

    public BetResult bet(int nWBalls){
        return BetResult.ERROR;
    }

    public boolean loseWhiteBall(){
        return false;
    }

    public void start(){

    }

    public void end(){

    }

    public boolean removeTwoBalls(){
        return false;
    }

}
