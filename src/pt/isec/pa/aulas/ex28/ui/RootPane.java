package pt.isec.pa.aulas.ex28.ui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class RootPane extends BorderPane {

    Button buttonGreen;
    Button buttonBlue;
    Button btnCustom;
    int greenCnt, blueCnt, customCnt;
    Label labelStatus;
    TextField textFieldColor;
    Color background = Color.WHITE;

    public RootPane() {
        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {
        buttonBlue = new Button("Green");               //criar butoes
        buttonBlue.setPrefSize(50,10);
        buttonGreen = new Button("Blue");
        buttonGreen.setPrefSize(50,10);
        textFieldColor = new TextField("Color name");
        textFieldColor.setPrefSize(200,10);
        btnCustom = new Button("Enter");
        btnCustom.setPrefSize(50,20);

        HBox hBox = new HBox(buttonBlue,buttonGreen, textFieldColor,btnCustom);       //criar a hbox que leva os botoes
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(15));

        labelStatus = new Label();
        labelStatus.setPrefWidth(Integer.MAX_VALUE);
        labelStatus.setPadding(new Insets(15));
        labelStatus.setStyle("-fx-background-color: rgba(128,128,128,0.78); -fx-font-size: 16;-fx-font: Courier New");
        labelStatus.setBorder(
                new Border(
                        new BorderStroke(Color.DARKGRAY,BorderStrokeStyle.DASHED,CornerRadii.EMPTY,BorderStroke.DEFAULT_WIDTHS)
                )
        );
        labelStatus.setText(String.format("green: %d \t blue: %d \t custom: %d", greenCnt, blueCnt,customCnt));

        this.setTop(hBox);                                  //mete a hbox no topo do border pane
        this.setBottom(labelStatus);
    }

    private void registerHandlers() {
        buttonGreen.setOnAction(actionEvent -> {
            greenCnt++;
            background = Color.GREEN;
            update();
        });
        buttonBlue.setOnAction(actionEvent -> {
            blueCnt++;
            background = Color.BLUE;
            update();
        });
        btnCustom.setOnAction(actionEvent -> {
            try {
                customCnt++;
                background = Color.valueOf(textFieldColor.getText());
            } catch (Exception e){
                background = Color.ALICEBLUE;
                textFieldColor.setStyle("-fx-background-color: rgba(255,0,0,0.61)");
            }
            update();
        });
        textFieldColor.setOnKeyPressed(keyEvent -> {
            textFieldColor.setStyle("-fx-background-color: rgb(255,255,255)");
            if (keyEvent.getCode() == KeyCode.ENTER){
                btnCustom.fire();
            }
            update();
        });

    }

    private void update() {
        this.setBackground(new Background(new BackgroundFill(background, CornerRadii.EMPTY,Insets.EMPTY)));

    }
}
