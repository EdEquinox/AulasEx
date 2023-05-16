package pt.isec.pa.aulas.ex30v2.ui.gui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import pt.isec.pa.aulas.ex30v2.model.Drawing;
import pt.isec.pa.aulas.ex30v2.model.DrawingManager;
import pt.isec.pa.aulas.ex30v2.model.Figure;

public class RootPane extends BorderPane {
    DrawingManager drawing;

    DrawingArea area;
    Pane areaPane;

    public RootPane(DrawingManager drawing) {
        this.drawing = drawing;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {
        this.setTop(new DrawingToolBar(drawing));

        area = new DrawingArea(drawing);
        areaPane = new Pane(area);
        this.setCenter(areaPane);
    }

    private void registerHandlers() {
        //TODO: event processing
        areaPane.widthProperty().addListener(observable -> {
            area.updateSize(getWidth(),getHeight());
        });
        areaPane.heightProperty().addListener(observable -> {
            area.updateSize(getWidth(),getHeight());
        });

    }
    private void update() { }
}
