package pt.isec.pa.aulas.ex30v2.ui.gui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import pt.isec.pa.aulas.ex30v2.model.Drawing;
import pt.isec.pa.aulas.ex30v2.model.DrawingManager;
import pt.isec.pa.aulas.ex30v2.model.Figure;

public class DrawingArea extends Canvas {
    DrawingManager drawing;

    public DrawingArea(DrawingManager drawing) {
        //super(400, 400);
        this.drawing = drawing;

        //createViews();
        registerHandlers();
        update();
    }

    private void registerHandlers() {
        drawing.addClient(DrawingManager.PROP_FIGURES,evt -> {
            update();
        });
        this.setOnMousePressed(mouseEvent -> {
            /*if (mouseEvent.isControlDown()) {
                drawing.setCurrentType(Figure.FigureType.RECTANGLE);
            } else if (mouseEvent.isAltDown()) {
                drawing.setCurrentType(Figure.FigureType.OVAL);
            } else {
                drawing.setCurrentType(Figure.FigureType.LINE);
            }*/
            //drawing.setRGB(Math.random(),Math.random(),Math.random());

            drawing.createFigure(mouseEvent.getX(), mouseEvent.getY());
//            update();
        });
        this.setOnMouseDragged(mouseEvent -> {
            drawing.updateCurrentFigure(mouseEvent.getX(), mouseEvent.getY());
//            update();
        });
        this.setOnMouseReleased(mouseEvent -> {
            drawing.finishCurrentFigure(mouseEvent.getX(), mouseEvent.getY());
//            update();
        });
    }

    private void update() {
        GraphicsContext gc = this.getGraphicsContext2D();

        clearScreen(gc);
        for(Figure figure:drawing.getList())
            drawFigure(gc,figure);

        drawFigure(gc,drawing.getCurrentFigure());

        /*for(int i=10;i>=0;i--) {
            gc.fillArc(100, 100+i, 200, 100, 0, 270, ArcType.ROUND);
            gc.strokeArc(100, 100+i, 200, 100, 0, 270, ArcType.ROUND);
        }*/

        /*double x[]={Math.random()*100,Math.random()*100,Math.random()*100,Math.random()*100,Math.random()*100};
        double y[]={Math.random()*100,Math.random()*100,Math.random()*100,Math.random()*100,Math.random()*100};
        //gc.strokePolyline(x,y,5);
        gc.strokePolygon(x,y,5); */

    }

    private void clearScreen(GraphicsContext gc) {
        gc.setFill(Color.LIGHTGOLDENRODYELLOW);
        gc.fillRect(0,0,getWidth(),getHeight());
    }

    private void drawFigure(GraphicsContext gc, Figure figure) {
        if (figure == null) return;
        Color color = Color.color(figure.getR(),figure.getG(),figure.getB());
        gc.setFill(color);
        gc.setLineWidth(5);
        switch (figure.getType()) {
            case LINE -> {
                gc.setStroke(color);
                gc.strokeLine(figure.getX1(),figure.getY1(),figure.getX2(),figure.getY2());
            }
            case RECTANGLE -> {
                gc.fillRect(figure.getX1(),figure.getY1(),figure.getWidth(),figure.getHeight());
                gc.setStroke(color.darker());
                gc.strokeRect(figure.getX1(),figure.getY1(),figure.getWidth(),figure.getHeight());
            }
            case OVAL -> {
                gc.fillOval(figure.getX1(),figure.getY1(),figure.getWidth(),figure.getHeight());
                gc.setStroke(color.darker());
                gc.strokeOval(figure.getX1(),figure.getY1(),figure.getWidth(),figure.getHeight());
            }
        }
    }

    public void updateSize(double w, double h) {
        setWidth(w);     setHeight(h);
        update();
    }
}
