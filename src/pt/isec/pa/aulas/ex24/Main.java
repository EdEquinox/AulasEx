package pt.isec.pa.aulas.ex24;

import pt.isec.pa.aulas.ex24.models.fsm.ElevatorContext;
import pt.isec.pa.aulas.ex24.views.ui.ElevatorUI;

public class Main {
    public static void main(String[] args) {

        ElevatorContext elevatorContext = new ElevatorContext();
        ElevatorUI elevatorUI = new ElevatorUI(elevatorContext);

        elevatorUI.start();

    }
}
