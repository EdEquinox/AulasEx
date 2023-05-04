package pt.isec.pa.aulas.jfx.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JavaFxMain extends Application {


    //preparaçao da aplicaçao, chama isto antes do start ////NAO OBRIGATORIO
    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("init");
    }

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("start");
        RootPane rootPane = new RootPane();
        Scene scene = new Scene(rootPane, 400, 200);
        stage.setScene(scene);
//        stage.setFullScreen(true);
//        stage.setMaxHeight(200);
//        stage.setMinHeight(50);
//        stage.setMaxHeight(600);
//        stage.setMinWidth(100);
        stage.setTitle("Trollagem podre");
        stage.show();

    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop");
        super.stop();
    }
}
