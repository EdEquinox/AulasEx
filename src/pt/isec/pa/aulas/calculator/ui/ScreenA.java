package pt.isec.pa.aulas.calculator.ui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ScreenA implements Initializable {

    public TextField tfTest;

    public ScreenA() {

    }

    @FXML
    void onConfirm(javafx.event.ActionEvent actionEvent) throws IOException {
        if (tfTest.getText().equals("exit"))
            Platform.exit();
        if (!tfTest.getText().equals("c"))
            return;
        Button btn = (Button) actionEvent.getSource();
        Scene scene = btn.getScene();
        scene.setRoot( new FXMLLoader(
                getClass().getResource("fxml/screenB.fxml")
        ).load() );
    }

    @Override
    public void initialize(URL url,
                           ResourceBundle resourceBundle) {
        //TODO
    }
}
