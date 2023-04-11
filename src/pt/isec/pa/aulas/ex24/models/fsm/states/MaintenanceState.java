package pt.isec.pa.aulas.ex24.models.fsm.states;

import pt.isec.pa.aulas.ex24.models.data.Elevator;
import pt.isec.pa.aulas.ex24.models.fsm.ElevatorContext;
import pt.isec.pa.aulas.ex24.models.fsm.ElevatorState;
import pt.isec.pa.aulas.ex24.models.fsm.ElevatorStateAdapter;
import pt.isec.pa.aulas.ex24.models.fsm.IElevatorState;

public class MaintenanceState extends ElevatorStateAdapter {
    public MaintenanceState(ElevatorContext elevatorContext, Elevator elevator) {
        super(elevatorContext, elevator);
    }

    @Override
    public boolean usePassword(String password) {
        if (!elevator.leaveMaintenance(password)){
            return false;
        }
        switch (elevator.getPiso()){
            case 0 -> changeState(ElevatorState.GROUND_FLOOR);
            case 1 -> changeState(ElevatorState.FIRST_FLOOR);
            case 2 -> changeState(ElevatorState.SECOND_FLOOR);
            default -> changeState(ElevatorState.MAINTENANCE);
        }
        return true;
    }

    @Override
    public ElevatorState getState() {
        return ElevatorState.MAINTENANCE;
    }
}
