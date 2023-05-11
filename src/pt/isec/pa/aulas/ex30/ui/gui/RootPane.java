package pt.isec.pa.aulas.ex30.ui.gui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import pt.isec.pa.aulas.ex30.model.Drawing;
import pt.isec.pa.aulas.ex30.model.Figure;
import pt.isec.pa.aulas.ex30.model.Oval;

public class RootPane extends BorderPane {
    Drawing drawing;

    Color randColor;
    ToggleButton tgbline;
    ToggleButton tgbrec;
    ToggleButton tgbov;
    ToggleButton tgbRed;
    ToggleButton tgbBlue;
    ToggleButton tgbGreen;
    ToggleButton tgbRnd;
    Canvas area;
    ToolBar toolBar;
    Pane areaPane;

    public RootPane(Drawing drawing) {
        this.drawing = drawing;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {
        randColor = new Color(Math.random(), Math.random(), Math.random(), 1);
        toolBar = new ToolBar();

        ToggleGroup toggleGroupForm = new ToggleGroup();
        tgbline = new ToggleButton(null,new Line(10,10,30,30));
        tgbrec = new ToggleButton(null,new Rectangle(10,10,20,20));
        tgbov = new ToggleButton(null,new Ellipse(10,10));

        tgbline.setToggleGroup(toggleGroupForm);
        tgbrec.setToggleGroup(toggleGroupForm);
        tgbov.setToggleGroup(toggleGroupForm);
        toolBar.getItems().add(tgbline);
        toolBar.getItems().add(tgbrec);
        toolBar.getItems().add(tgbov);
        toggleGroupForm.selectToggle(tgbline);

        ToggleGroup toggleGroupColor = new ToggleGroup();
        tgbRed = new ToggleButton(null,new Rectangle(20,20,Color.RED));
        tgbBlue = new ToggleButton(null,new Rectangle(20,20,Color.BLUE));
        tgbGreen = new ToggleButton(null,new Rectangle(20,20,Color.GREEN));
        tgbRnd = new ToggleButton("Random",new Rectangle(20,20, randColor));

        tgbRed.setToggleGroup(toggleGroupColor);
        tgbGreen.setToggleGroup(toggleGroupColor);
        tgbBlue.setToggleGroup(toggleGroupColor);
        tgbRed.setToggleGroup(toggleGroupColor);
        tgbRnd.setToggleGroup(toggleGroupColor);
        toolBar.getItems().addAll(tgbRed,tgbBlue,tgbGreen,tgbRnd);
        toggleGroupColor.selectToggle(tgbRed);

        this.setTop(toolBar);

        area = new Canvas();
        areaPane = new Pane(area);
        this.setCenter(areaPane);
    }

    private void registerHandlers() {
        //TODO: event processing
        update();
        areaPane.widthProperty().addListener(observable -> {
            area.setWidth(getWidth());
            area.setHeight(getHeight());
            update();
        });
        areaPane.heightProperty().addListener(observable -> {
            area.setWidth(getWidth());
            area.setHeight(getHeight());
            update();
        });

        areaPane.setOnMousePressed(e ->{
            drawing.createFigure(e.getX(),e.getY());
            update();
        });

        areaPane.setOnMouseDragged(e->{
            drawing.updateCurrentFigure(e.getX(),e.getY());
            update();
        });

        areaPane.setOnMouseReleased(e->{
            drawing.finishCurrentFigure(e.getX(),e.getY());
            update();
        });
    }

    private void update() {
        GraphicsContext gc = area.getGraphicsContext2D();

        if (tgbline.isSelected()){
            drawing.setCurrentType(Figure.FigureType.LINE);
        }
        else if (tgbrec.isSelected()){
            drawing.setCurrentType(Figure.FigureType.RECTANGLE);
        }
        else if (tgbov.isSelected()){
            drawing.setCurrentType(Figure.FigureType.OVAL);
        }
        if (tgbRed.isSelected()){
            drawing.setRGB(1,0,0);
        }
        else if (tgbBlue.isSelected()){
            drawing.setRGB(0,0,1);
        }
        else if (tgbGreen.isSelected()){
            drawing.setRGB(0,1,0);
        }
        else if (tgbRnd.isSelected()){
            drawing.setRGB(Math.random(),Math.random(),Math.random());
        }

        // Canvas: clearScreen
        gc.setFill(Color.LIGHTGOLDENRODYELLOW);
        gc.fillRect(0,0,getWidth(),getHeight());

        for(Figure figure:drawing.getList())
            switch(figure.getType()) {
                case LINE -> {
                    gc.strokeLine(figure.getX1(), figure.getY1(), figure.getX2(), figure.getY2());
                }
                case RECTANGLE -> {
                    gc.strokeRect(figure.getX1(), figure.getY1(), figure.getWidth(), figure.getHeight());
                    gc.setFill(Color.color(figure.getR(),figure.getB(),figure.getB()));
                    gc.fillRect(figure.getX1(), figure.getY1(), figure.getWidth(), figure.getHeight());
                }
                case OVAL -> {
                    gc.strokeOval(figure.getX1(), figure.getY1(), figure.getWidth(), figure.getHeight());
                    gc.setFill(Color.color(figure.getR(),figure.getB(),figure.getB()));
                    gc.fillOval(figure.getX1(), figure.getY1(), figure.getWidth(), figure.getHeight());
                }
            }
        if (drawing.getCurrentFigure()!=null){
            switch(drawing.getCurrentFigure().getType()) {
                case LINE -> {
                    gc.strokeLine(drawing.getCurrentFigure().getX1(), drawing.getCurrentFigure().getY1(), drawing.getCurrentFigure().getX2(), drawing.getCurrentFigure().getY2());
                }
                case RECTANGLE -> {
                    gc.strokeRect(drawing.getCurrentFigure().getX1(), drawing.getCurrentFigure().getY1(), drawing.getCurrentFigure().getWidth(), drawing.getCurrentFigure().getHeight());
                    gc.setFill(Color.color(drawing.getCurrentFigure().getR(),drawing.getCurrentFigure().getB(),drawing.getCurrentFigure().getB()));
                    gc.fillRect(drawing.getCurrentFigure().getX1(), drawing.getCurrentFigure().getY1(), drawing.getCurrentFigure().getWidth(), drawing.getCurrentFigure().getHeight());
                }
                case OVAL -> {
                    gc.strokeOval(drawing.getCurrentFigure().getX1(), drawing.getCurrentFigure().getY1(), drawing.getCurrentFigure().getWidth(), drawing.getCurrentFigure().getHeight());
                    gc.setFill(Color.color(drawing.getCurrentFigure().getR(),drawing.getCurrentFigure().getB(),drawing.getCurrentFigure().getB()));
                    gc.fillOval(drawing.getCurrentFigure().getX1(), drawing.getCurrentFigure().getY1(), drawing.getCurrentFigure().getWidth(), drawing.getCurrentFigure().getHeight());
                }
            }
        }

        //gc.setStroke(...)
        //gc.fill*(...)
        //gc.setFill(...)
        //gc.setLineWidth(....);


//        gc.strokeText("Advanced Programming",300,300);

    }
}
