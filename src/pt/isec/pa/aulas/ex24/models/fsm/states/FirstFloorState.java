package pt.isec.pa.aulas.ex24.models.fsm.states;

import pt.isec.pa.aulas.ex24.models.data.Elevator;
import pt.isec.pa.aulas.ex24.models.fsm.ElevatorContext;
import pt.isec.pa.aulas.ex24.models.fsm.ElevatorState;
import pt.isec.pa.aulas.ex24.models.fsm.ElevatorStateAdapter;

import java.util.Random;

public class FirstFloorState extends ElevatorStateAdapter {
    int prob = 20;
    public FirstFloorState(ElevatorContext elevatorContext, Elevator elevator) {
        super(elevatorContext, elevator);
        elevator.setPiso(1);
    }

    @Override
    public boolean up() {
        Random randomNum = new Random();
        double num = randomNum.nextInt(100);
        System.out.println(num);
        if (num<getProb()){
            elevator.enterMaintenance();
            underMaintenance();
            return true;
        }
        changeState(ElevatorState.SECOND_FLOOR);
        return true;
    }

    public int getProb() {
        return prob;
    }

    @Override
    public boolean underMaintenance() {
        changeState(ElevatorState.MAINTENANCE);
        return true;
    }

    @Override
    public boolean down() {
        Random randomNum = new Random();
        double num = randomNum.nextInt(100);
        System.out.println(num);
        if (num<getProb()){
            elevator.enterMaintenance();
            underMaintenance();
            return true;
        }
        changeState(ElevatorState.GROUND_FLOOR);
        return true;
    }

    @Override
    public ElevatorState getState() {
        return ElevatorState.FIRST_FLOOR;
    }

}
