package pt.isec.pa.aulas.ex30v2.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class DrawingManager {
    public static final String PROP_TOOLS = "_tools_";
    public static final String PROP_FIGURES = "_figures_";
    Drawing drawing;
    PropertyChangeSupport pcs;

//    public DrawingManager(Drawing drawing) {
//        this.drawing = drawing;
//    }

    public DrawingManager() {
        this.drawing = new Drawing();
        this.pcs = new PropertyChangeSupport(this);
    }

    public void addClient(String property,PropertyChangeListener listener){
        pcs.addPropertyChangeListener(property,listener);
    }

    public void addClient(PropertyChangeListener listener){
        pcs.addPropertyChangeListener(listener);
    }

    public double getR() {
        return drawing.getR();
    }
    public double getG() {
        return drawing.getG();
    }
    public double getB() {
        return drawing.getB();
    }
    public void setRGB(double r,double g, double b) {
        drawing.setRGB(r,g,b);
        pcs.firePropertyChange(PROP_TOOLS,null,null);
    }

    public Figure.FigureType getCurrentType() {
        return drawing.getCurrentType();
    }

    public void setCurrentType(Figure.FigureType currentType) {
        drawing.setCurrentType(currentType);
        pcs.firePropertyChange(PROP_TOOLS,null,null);
    }

    public void createFigure(double x, double y) {
        drawing.createFigure(x,y);
        pcs.firePropertyChange(PROP_FIGURES,null,null);
    }

    public void updateCurrentFigure(double x, double y) {
        drawing.updateCurrentFigure(x,y);
        pcs.firePropertyChange(PROP_FIGURES,null,null);
    }

    public void finishCurrentFigure(double x,double y) {
        drawing.finishCurrentFigure(x,y);
        pcs.firePropertyChange(PROP_FIGURES,null,null);
    }

    public Figure getCurrentFigure() {
        return drawing.getCurrentFigure();
    }

    public List<Figure> getList() {
        return drawing.getList();
    }

    public void clearAll() {
        drawing.clearAll();
        pcs.firePropertyChange(PROP_FIGURES,null,null);
    }

    public void removeLast() {
        drawing.removeLast();
        pcs.firePropertyChange(PROP_FIGURES,null,null);
    }

    public void remove(int selectedIndex) {
        drawing.remove(selectedIndex);
        pcs.firePropertyChange(PROP_FIGURES,null,null);
    }
}
