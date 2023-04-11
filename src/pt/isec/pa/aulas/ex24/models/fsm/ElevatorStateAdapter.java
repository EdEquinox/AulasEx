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

    protected void changeState(ElevatorState newState){
        //elevatorContext.changeElevatorState(IElevatorState.createState(newState,elevatorContext,elevator));
        //elevatorContext.changeElevatorState(ElevatorStateFactory.createState(newState,elevatorContext,elevator));
        elevatorContext.changeElevatorState(ElevatorState.createState(newState,elevatorContext,elevator));
    }

    @Override
    public boolean up() {
        return false;
    }

    @Override
    public boolean down() {
        return false;
    }

    @Override
    public boolean underMaintenance() {
        return false;
    }

    @Override
    public int getProb() {
        return 0;
    }

    @Override
    public boolean usePassword(String password) {
        return false;
    }
}
