package pt.isec.pa.aulas.ex24.models.fsm;

import pt.isec.pa.aulas.ex24.models.data.Elevator;
import pt.isec.pa.aulas.ex24.models.fsm.states.GroundFloorState;

import java.util.Random;

public class ElevatorContext {
    private IElevatorState state;
    private Elevator elevator;

    public ElevatorContext() {
        this.elevator = new Elevator(0,"olare");
        this.state = ElevatorState.createState(ElevatorState.GROUND_FLOOR,this,elevator);
    }

    public ElevatorState getState(){
        return state.getState();
    }

    void changeElevatorState(IElevatorState newstate) {     //ESTA MERDA È IMPORTANTISSIMA NAO TER O PUBLIC
        this.state = newstate;                              //A SERIO NAO PONHAS O PUBLIC
    }                                                       //NAO PONHAS MESMO
                                                           //significa package private

    public boolean up(){
        return state.up();
    }

    public boolean down(){
        return state.down();
    }

    public int getPiso(){
        return elevator.getPiso();
    }
    public boolean usePassword(String password){
        return state.usePassword(password);
    }

    public boolean isMaintenance(){
        return elevator.isUnderMaintenance();
    }

}
