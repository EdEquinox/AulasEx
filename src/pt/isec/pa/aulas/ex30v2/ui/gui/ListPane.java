package pt.isec.pa.aulas.ex30v2.ui.gui;

import javafx.scene.control.ListView;
import pt.isec.pa.aulas.ex30v2.model.DrawingManager;
import pt.isec.pa.aulas.ex30v2.model.Figure;
public class ListPane extends ListView<Figure> {
    DrawingManager drawing;
    public ListPane(DrawingManager drawing) {
        this.drawing = drawing;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {

    }

    private void registerHandlers() {
        drawing.addClient(DrawingManager.PROP_FIGURES,evt -> update());
        this.setOnMouseClicked(mouseEvent -> {
            if (mouseEvent.getClickCount() == 2){
                drawing.remove(this.getSelectionModel().getSelectedIndex());
            }
        });
    }

    private void update() {
        this.getItems().clear();
        this.getItems().addAll(drawing.getList());
    }
}
