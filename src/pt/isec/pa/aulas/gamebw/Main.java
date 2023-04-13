package pt.isec.pa.aulas.gamebw;

import pt.isec.pa.aulas.gamebw.model.fsm.GameBWContext;
import pt.isec.pa.aulas.gamebw.ui.GameBWUI;

public class Main {
    public static void main(String[] args) {
        GameBWContext fsm = new GameBWContext();
        GameBWUI ui = new GameBWUI(fsm);
        ui.start();
    }
}
