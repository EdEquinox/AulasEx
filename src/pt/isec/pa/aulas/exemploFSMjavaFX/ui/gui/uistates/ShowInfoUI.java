package pt.isec.pa.aulas.exemploFSMjavaFX.ui.gui.uistates;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import pt.isec.pa.aulas.exemploFSMjavaFX.model.GameBWManager;
import pt.isec.pa.aulas.exemploFSMjavaFX.model.data.History;
import pt.isec.pa.aulas.exemploFSMjavaFX.model.fsm.GameBWState;

import java.util.List;

public class ShowInfoUI extends BorderPane {
    GameBWManager gameBWManager;

    Label lblStats;
    Button btnStart, btnEnd;
    VBox vHistory;

    public ShowInfoUI(GameBWManager gameBWManager) {
        this.gameBWManager = gameBWManager;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {

        //lblStats = new Label();
        //lblStats.setStyle("-fx-background-color: rgba(102,102,102,0.51); -fx-font-family: Centaur;-fx-font-size: 15");
        //lblStats.setPadding(new Insets(10));

        btnStart = new Button("Start");
        btnStart.setMinWidth(100);
        btnEnd  = new Button("End");
        btnEnd.setMinWidth(100);
        HBox hBox = new HBox(btnStart,btnEnd);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);

        TilePane titlePane = getLine(
                450,
                "WBalls won",
                "WBalls out",
                "BBalls out",
                "Action"
        );
        titlePane.setStyle("-fx-background-color: #c0c0c0;");
        vHistory = new VBox();
        ScrollPane scrollPane = new ScrollPane(vHistory);
        scrollPane.setStyle("-fx-background-color: white");
        scrollPane.setPrefHeight(200);

        VBox listWithTitle = new VBox(titlePane,scrollPane);
        listWithTitle.setBorder(new Border(new BorderStroke(Color.DARKGRAY,BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,new BorderWidths(2))));
        VBox vBox = new VBox( hBox , listWithTitle);
        vBox.setFillWidth(false);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        setAlignment(vBox,Pos.CENTER);
        this.setCenter(vBox);

    }

    private void registerHandlers() {
        gameBWManager.addPropertyChangeListener(evt -> { update(); });

        btnStart.setOnAction( event -> {
            gameBWManager.start();
        });
        btnEnd.setOnAction( event -> {
            Platform.exit();
        });

    }

    private void update() {
        if (gameBWManager.getState() != GameBWState.SHOW_INFO) {
            this.setVisible(false);
            return;
        }
        this.setVisible(true);

        List<History> history = gameBWManager.getHistory();

        vHistory.getChildren().clear();
        for (int i = 0; i < history.size(); i++) {
            int bet = history.get(i).bet();
            String type = switch (history.get(i).type()) {
                case LOSE -> "Lose W";
                case REMOVE -> "Two Balls";
                case BET -> "Bet " + bet;
                case BETLOST -> "Lost";
                case BETWON -> "Won";
                default -> "--";
            };
            TilePane tilePane = getLine(
                    450,
                    String.valueOf(history.get(i).nrWBwon()),
                    String.valueOf(history.get(i).nrWBout()),
                    String.valueOf(history.get(i).nrBBout()),
                    type
            );
            vHistory.getChildren().add(tilePane);
        }

//        String text = " White balls won: " + gameBWManager.getNrWhiteBallsWon() +
//                "\n White balls out: " + gameBWManager.getNrWhiteBallsOut() +
//                "\n Black balls out: " + gameBWManager.getNrBlackBallsOut();
//        lblStats.setText(text);

    }

    private TilePane getLine(double width, String... strings) {
        TilePane tilePane = new TilePane();
        for (int i = 0; i <strings.length; i++) {
            Label label = new Label(strings[i]);
            tilePane.getChildren().add(label);
        }
        tilePane.setPrefWidth(width);
        tilePane.setPrefTileWidth(width/strings.length);
        return tilePane;
    }

}
