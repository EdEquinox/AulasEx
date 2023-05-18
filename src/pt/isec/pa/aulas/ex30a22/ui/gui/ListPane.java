package pt.isec.pa.aulas.ex30a22.ui.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pt.isec.pa.aulas.ex30a22.model.DrawingManager;
import pt.isec.pa.aulas.ex30a22.model.Figure;

import java.util.List;

public class ListPane extends ListView<Figure> {
    DrawingManager drawing;
    MenuItem mnDelete,mnChange;

    public ListPane(DrawingManager drawing) {
        this.drawing = drawing;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {
        mnDelete = new MenuItem("Delete");
        mnChange = new MenuItem("Change");

        this.setContextMenu(new ContextMenu(mnDelete,mnChange));

    }

    private void registerHandlers() {
        drawing.addPropertyChangeListener(DrawingManager.PROP_FIGURES,
                evt -> update());
        this.setOnMouseClicked( mouseEvent -> {
            if (mouseEvent.getClickCount() == 2) {
                drawing.remove(this.getSelectionModel().getSelectedIndex());
            }
        });
        mnDelete.setOnAction(actionEvent -> {
            drawing.remove(this.getSelectionModel().getSelectedIndex());
        });
        mnChange.setOnAction(actionEvent -> {
            Stage stage = new Stage();
            Label label = new Label("Change color:");
            Button button = new Button("OK");
            button.setOnAction(actionEvent1 -> {
                Figure figure = this.getSelectionModel().getSelectedItem();
                if (figure == null){
                    stage.close();
                    return;
                }
                figure.setRGB(0,0,0);
                List list = drawing.getList();
                for (int i=0; i<list.size(); i++){
                    if (list.get(i).equals(figure)){
                        list.remove(list.get(i));
                        list.add(figure);
                    }
                }
                stage.close();
            });
            VBox vBox = new VBox(label,button);
            vBox.setAlignment(Pos.CENTER);
            Scene scene = new Scene(vBox,200,60);
            stage.setScene(scene);
            stage.setTitle("Change");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(this.getScene().getWindow());
            stage.setAlwaysOnTop(true);
            stage.showAndWait();
        });
    }

    private void update() {
        this.getItems().clear();
        this.getItems().addAll(drawing.getList());
    }
}
