package pt.isec.pa.aulas.ex24.models.fsm.states;

import pt.isec.pa.aulas.ex24.models.data.Elevator;
import pt.isec.pa.aulas.ex24.models.fsm.ElevatorContext;
import pt.isec.pa.aulas.ex24.models.fsm.ElevatorState;
import pt.isec.pa.aulas.ex24.models.fsm.ElevatorStateAdapter;

public class GroundFloorState extends ElevatorStateAdapter {
    public GroundFloorState(ElevatorContext elevatorContext, Elevator elevator) {
        super(elevatorContext, elevator);
        elevator.setPiso(0);
    }

    @Override
    public boolean up() {
        changeState(new FirstFloorState(elevatorContext,elevator));
        return true;
    }

    @Override
    public ElevatorState getState() {
        return ElevatorState.GROUND_FLOOR;
    }
}
