package pt.isec.pa.aulas.exemploFSMjavaFX.ui.gui;

import javafx.scene.layout.*;
import pt.isec.pa.aulas.exemploFSMjavaFX.model.GameBWManager;
import pt.isec.pa.aulas.exemploFSMjavaFX.ui.gui.resources.CSSManager;
import pt.isec.pa.aulas.exemploFSMjavaFX.ui.gui.resources.ImageManager;
import pt.isec.pa.aulas.exemploFSMjavaFX.ui.gui.uistates.BeginUI;
import pt.isec.pa.aulas.exemploFSMjavaFX.ui.gui.uistates.LostWaitDecisionUI;
import pt.isec.pa.aulas.exemploFSMjavaFX.ui.gui.uistates.WaitBetUI;

public class RootPane extends BorderPane {
    GameBWManager gameBWManager;

    public RootPane(GameBWManager gameBWManager) {
        this.gameBWManager = gameBWManager;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {
        CSSManager.applyCSS(this,"styles.css");

        StackPane stackPane = new StackPane(
                new BeginUI(gameBWManager),
                new WaitBetUI(gameBWManager),
                new LostWaitDecisionUI(gameBWManager)
        ); // mencionar a possibilidade de apenas ir criando quando muda de estado
        stackPane.setBackground(
            new Background(
                new BackgroundImage(
                    ImageManager.getImage("background.png"),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    new BackgroundSize(1,1,true,true,true,false)
                )
            )
        );
        this.setCenter(stackPane);

        this.setRight(
                new BallsWon(gameBWManager)
        );
        this.setBottom(
                new BallsOut(gameBWManager)
        );

    }

    private void registerHandlers() {
    }

    private void update() {
    }
}
