package pt.isec.pa.aulas.pong.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pt.isec.pa.aulas.pong.Main;
import pt.isec.pa.aulas.pong.model.Game;

public class MainJFX extends Application {
    Game game;
    @Override
    public void init() throws Exception {
        super.init();
        game = Main.game;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Pane()); // fake pane
        scene.setUserData(game);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/game_pane.fxml"));
        scene.setRoot(loader.load());

        stage.setScene(scene);
        stage.setTitle("PONG@PA");
        stage.setMinHeight(300);
        stage.setMinWidth(400);
        stage.show();
    }
}
