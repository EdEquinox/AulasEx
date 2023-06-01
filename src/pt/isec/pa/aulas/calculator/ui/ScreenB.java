package pt.isec.pa.aulas.calculator.ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import pt.isec.pa.aulas.calculator.model.CalculatorManager;

import java.net.URL;
import java.util.ResourceBundle;

public class ScreenB implements Initializable {
    @FXML public HBox root;
    CalculatorManager calculatorManager;

    public void init(CalculatorManager calculatorManager){
        this.calculatorManager = calculatorManager;
        
        registerHandlers();
        update();
    }

    private void registerHandlers() {
    }

    private void update() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
