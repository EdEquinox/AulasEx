package pt.isec.pa.aulas.ex24.models.fsm;

import pt.isec.pa.aulas.ex24.models.data.Elevator;

public abstract class ElevatorStateAdapter implements IElevatorState{
    protected ElevatorContext elevatorContext;
    protected Elevator elevator;

    protected ElevatorStateAdapter(ElevatorContext elevatorContext, Elevator elevator) {
        this.elevatorContext = elevatorContext;
        this.elevator = elevator;
    }

    protected void changeState(IElevatorState newState){
        elevatorContext.changeElevatorState(newState);
    }

    @Override
    public boolean up() {
        return false;
    }

    @Override
    public boolean down() {
        return false;
    }

}
