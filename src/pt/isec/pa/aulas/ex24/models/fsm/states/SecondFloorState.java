package pt.isec.pa.aulas.ex24.models.fsm.states;

import pt.isec.pa.aulas.ex24.models.data.Elevator;
import pt.isec.pa.aulas.ex24.models.fsm.ElevatorContext;
import pt.isec.pa.aulas.ex24.models.fsm.ElevatorState;
import pt.isec.pa.aulas.ex24.models.fsm.ElevatorStateAdapter;

import java.util.Random;

public class SecondFloorState extends ElevatorStateAdapter {
    int prob = 30;
    public SecondFloorState(ElevatorContext elevatorContext, Elevator elevator) {
        super(elevatorContext, elevator);
        elevator.setPiso(2);
    }

    @Override
    public ElevatorState getState() {
        return ElevatorState.SECOND_FLOOR;
    }
    @Override
    public boolean down() {
        Random randomNum = new Random();
        if (randomNum.nextInt(100)<getProb()){
            elevator.enterMaintenance();
            underMaintenance();
            return true;
        }
        changeState(ElevatorState.FIRST_FLOOR);
        return true;
    }

    @Override
    public int getProb() {
        return prob;
    }

    @Override
    public boolean underMaintenance() {
        changeState(ElevatorState.MAINTENANCE);
        return true;
    }
}
