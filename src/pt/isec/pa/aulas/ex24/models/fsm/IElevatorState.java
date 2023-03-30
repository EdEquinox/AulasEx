package pt.isec.pa.aulas.ex24.models.fsm;

public interface IElevatorState {
    ElevatorState getState();
    boolean up();
    boolean down();
}
