package pt.isec.pa.aulas.ex30v2.ui.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pt.isec.pa.aulas.ex30v2.model.Drawing;
import pt.isec.pa.aulas.ex30v2.model.DrawingManager;
import pt.isec.pa.aulas.ex30v2.model.Figure;

public class MainJFX extends Application {
    DrawingManager drawing;

    @Override
    public void init() throws Exception {
        super.init();
        drawing = new DrawingManager();

        //TEST
//        drawing.setCurrentType(Figure.FigureType.LINE);
//        drawing.setRGB(1,0,0);
//        drawing.createFigure(0,0);
//        drawing.finishCurrentFigure(100,100);
//        drawing.setCurrentType(Figure.FigureType.OVAL);
//        drawing.setRGB(0,1,0);
//        drawing.createFigure(100,0);
//        drawing.finishCurrentFigure(200,100);
//        drawing.setCurrentType(Figure.FigureType.RECTANGLE);
//        drawing.setRGB(0,0,1);
//        drawing.createFigure(200,0);
//        drawing.finishCurrentFigure(300,100);

    }

    @Override
    public void start(Stage stage) throws Exception {
        createOneStage(stage);
       createLogStage(stage.getX()+stage.getWidth(),stage.getY());
    }

    private void createOneStage(Stage stage){
        RootPane root = new RootPane(drawing);
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.setTitle("Drawing@PA");
        stage.show();
    }

    private void createLogStage(double x, double y){
        Stage stage1 = new Stage();
        ListPane listPane = new ListPane(drawing);
        Scene scene = new Scene(listPane,300,400);
        stage1.setScene(scene);
        stage1.setTitle("Logs");
        stage1.setX(x);
        stage1.setY(y);
        stage1.show();
    }
}
