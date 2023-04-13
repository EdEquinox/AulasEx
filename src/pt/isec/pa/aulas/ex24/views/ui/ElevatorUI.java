package pt.isec.pa.aulas.ex24.views.ui;

import pt.isec.pa.aulas.ex24.models.data.Logger;
import pt.isec.pa.aulas.ex24.models.fsm.ElevatorContext;
import pt.isec.pa.aulas.utils.PAInput;

public class ElevatorUI {
    ElevatorContext elevator;
    boolean finish = false;

    public ElevatorUI(ElevatorContext elevatorContext) {
        this.elevator = elevatorContext;
    }

//    public void start() {
//        while (true) {
//            System.out.println("Estou no piso " + elevator.getPiso());
//            switch (PAInput.chooseOption("Elevador ",
//                    "Subir", "Descer", "Sair")) {
//                case 1:
//                    elevator.up();
//                    break;
//                case 2:
//                    elevator.down();
//                    break;
//                case 3:
//                 return;
//           }
//       }
//   }

    public void start() {

        while (!finish) {
            switch (elevator.getState()) {
                case FIRST_FLOOR -> {
                    firstFloor();
                }
                case GROUND_FLOOR -> {
                    groundFloor();
                }
                case SECOND_FLOOR -> {
                    secondFloor();
                }
                case MAINTENANCE -> {
                    maintenance();
                }
                default -> finish = true;
            }
            //System.out.println(Logger.getInstance().getLogs());
        }
    }

    private void maintenance() {
        //System.out.println("Estou em manutenção!!! " );
        Logger.getInstance().log("Entrada em manutenção");
        String password = PAInput.readString("Password: ",true);
        while (!elevator.usePassword(password)){
            System.out.println("Chave não aceite. " );
            password = PAInput.readString("Password: ",true);
        }
    }

    private void secondFloor() {
        //System.out.println("Estou no piso " + elevator.getPiso());
        Logger.getInstance().log("Entrada no piso " + elevator.getPiso());
        switch (PAInput.chooseOption("Elevador ",
                "Descer", "Sair")) {
            case 1 -> elevator.down();
            case 2 -> finish = true;
        }
    }

        private void groundFloor() {
            //System.out.println("Estou no piso " + elevator.getPiso());
            Logger.getInstance().log("Entrada no piso " + elevator.getPiso());
            switch (PAInput.chooseOption("Elevador ",
                    "Subir", "Sair")) {
                case 1 -> elevator.up();
                case 2 -> finish = true;
            }
        }

        private void firstFloor() {
            //System.out.println("Estou no piso " + elevator.getPiso());
            Logger.getInstance().log("Entrada no piso " + elevator.getPiso());
            switch (PAInput.chooseOption("Elevador ",
                    "Subir", "Descer", "Sair")) {
                case 1 -> elevator.up();
                case 2 -> elevator.down();
                case 3 -> finish = true;
            }
        }
    }
