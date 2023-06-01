package pt.isec.pa.aulas.calculator.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pt.isec.pa.aulas.calculator.Main;
import pt.isec.pa.aulas.calculator.model.CalculatorManager;

public class MainJFX extends Application {
    CalculatorManager model = Main.model;

    @Override
    public void start(Stage stage) throws Exception {
        //Scene scene = new Scene(new BorderPane(new Label("/* TODO */")),400,600);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/screenA.fxml"));
        ScreenA a1= loader.getController();
        System.out.println(a1);
        VBox root = loader.load();
        ScreenA a2= loader.getController();
        System.out.println(a2);


        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Calculator@PA");
        stage.show();
    }
}
