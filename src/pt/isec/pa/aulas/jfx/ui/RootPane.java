package pt.isec.pa.aulas.jfx.ui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class RootPane extends HBox {
    Button button;
    Button button1;
    Label lbl;
    private String text = "Kazzio";
    public RootPane() {
        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {
        button = new Button("ola");
        button1 = new Button("adeus");
        lbl = new Label("Kazzio?");

        this.setStyle("-fx-background-color: #FFFFFF");

        this.getChildren().addAll(button,button1,lbl);
    }

    private void registerHandlers() {
        button.setOnAction(actionEvent -> {
           text = "trolei";
           update();
        });
        button1.setOnAction(actionEvent -> {
            this.setStyle("-fx-background-color: #ffffcc");
        });
    }

    private void update() {
        lbl.setText(text);
    }


}
