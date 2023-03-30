package pt.isec.pa.aulas.ex24.models.fsm.states;

import pt.isec.pa.aulas.ex24.models.data.Elevator;
import pt.isec.pa.aulas.ex24.models.fsm.ElevatorContext;
import pt.isec.pa.aulas.ex24.models.fsm.ElevatorState;
import pt.isec.pa.aulas.ex24.models.fsm.ElevatorStateAdapter;

public class SecondFloorState extends ElevatorStateAdapter {
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
        changeState(new FirstFloorState(elevatorContext,elevator));
        return true;
    }
}
