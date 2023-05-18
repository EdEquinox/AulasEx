package pt.isec.pa.aulas.exemploFSMjavaFX;

import javafx.application.Application;
import pt.isec.pa.aulas.exemploFSMjavaFX.model.GameBWManager;
import pt.isec.pa.aulas.exemploFSMjavaFX.ui.gui.MainJFX;

public class Main {
    public static GameBWManager gameBWManager;
    static {
        gameBWManager = new GameBWManager();
    }
    public static void main(String[] args) {
        Application.launch(MainJFX.class,args);
    }
}