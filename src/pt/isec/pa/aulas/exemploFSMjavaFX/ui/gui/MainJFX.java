package pt.isec.pa.aulas.exemploFSMjavaFX.ui.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pt.isec.pa.aulas.exemploFSMjavaFX.Main;
import pt.isec.pa.aulas.exemploFSMjavaFX.model.GameBWManager;

public class MainJFX extends Application {
    GameBWManager gameBWManager;

    @Override
    public void init() throws Exception {
        super.init();
        gameBWManager = Main.gameBWManager;
    }

    @Override
    public void start(Stage stage) throws Exception {
        newStageForTesting(stage,"Game BW");
        newStageForTesting(new Stage(),"Game BW#clone");
    }

    private void newStageForTesting(Stage stage, String title) {
        RootPane root = new RootPane(gameBWManager);
        Scene scene = new Scene(root,700,400);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.setMinWidth(700);
        stage.setMinHeight(400);
        stage.show();
    }
}
