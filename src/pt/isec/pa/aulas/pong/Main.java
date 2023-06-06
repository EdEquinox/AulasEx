package pt.isec.pa.aulas.pong;

import javafx.application.Application;
import pt.isec.pa.aulas.pong.model.Game;
import pt.isec.pa.aulas.pong.ui.MainJFX;

public class Main {
    public static Game game;
    static {
        game = new Game();
    }
    public static void main(String[] args) {
        Application.launch(MainJFX.class,args);
    }
}
