package pt.isec.pa.aulas.ex24.models.fsm;

import pt.isec.pa.aulas.ex24.models.data.Elevator;
import pt.isec.pa.aulas.ex24.models.fsm.states.FirstFloorState;
import pt.isec.pa.aulas.ex24.models.fsm.states.GroundFloorState;
import pt.isec.pa.aulas.ex24.models.fsm.states.MaintenanceState;
import pt.isec.pa.aulas.ex24.models.fsm.states.SecondFloorState;

public interface IElevatorState {
    ElevatorState getState();
    boolean up();
    boolean down();
    int getProb();
    boolean underMaintenance();
    boolean usePassword(String password);

    static IElevatorState createState(ElevatorState type, ElevatorContext elevatorContext, Elevator elevator){
        return switch (type){
            case SECOND_FLOOR -> new SecondFloorState(elevatorContext,elevator);
            case GROUND_FLOOR -> new GroundFloorState(elevatorContext,elevator);
            case FIRST_FLOOR -> new FirstFloorState(elevatorContext,elevator);
            case MAINTENANCE -> new MaintenanceState(elevatorContext,elevator);
        };
    }
}
