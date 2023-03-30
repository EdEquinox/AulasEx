package pt.isec.pa.aulas.ex24.models.fsm.states;

import pt.isec.pa.aulas.ex24.models.data.Elevator;
import pt.isec.pa.aulas.ex24.models.fsm.ElevatorContext;
import pt.isec.pa.aulas.ex24.models.fsm.ElevatorState;
import pt.isec.pa.aulas.ex24.models.fsm.ElevatorStateAdapter;

public class FirstFloorState extends ElevatorStateAdapter {
    public FirstFloorState(ElevatorContext elevatorContext, Elevator elevator) {
        super(elevatorContext, elevator);
        elevator.setPiso(1);
    }

    @Override
    public boolean up() {
        changeState(new SecondFloorState(elevatorContext,elevator));
        return true;
    }

    @Override
    public boolean down() {
        changeState(new GroundFloorState(elevatorContext,elevator));
        return true;
    }

    @Override
    public ElevatorState getState() {
        return ElevatorState.FIRST_FLOOR;
    }

}
