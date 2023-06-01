package pt.isec.pa.aulas.calculator;

import javafx.application.Application;
import pt.isec.pa.aulas.calculator.model.CalculatorManager;
import pt.isec.pa.aulas.calculator.ui.MainJFX;

public class Main {
    public static CalculatorManager model = new CalculatorManager();
    public static void main(String[] args) {
        Application.launch(MainJFX.class,args);
    }
}
