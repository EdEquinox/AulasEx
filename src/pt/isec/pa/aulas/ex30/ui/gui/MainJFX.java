package pt.isec.pa.aulas.ex30.ui.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pt.isec.pa.aulas.ex30.model.Drawing;
import pt.isec.pa.aulas.ex30.model.Figure;

public class MainJFX extends Application {
    Drawing drawing;

    @Override
    public void init() throws Exception {
        super.init();
        drawing = new Drawing();
    }

    @Override
    public void start(Stage stage) throws Exception {
        RootPane root = new RootPane(drawing);
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.setTitle("Drawing@PA");
        stage.show();
    }
}
