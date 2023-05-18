package pt.isec.pa.aulas.ex30a22.ui.gui;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;
import pt.isec.pa.aulas.ex30a22.model.DrawingManager;

import java.io.File;


public class AppMenu extends MenuBar {

    DrawingManager drawing;
    Menu mnFile,mnEdit;
    MenuItem itNew,itOpen,itSave,itExit,itUndo,itRedo;

    public AppMenu(DrawingManager drawing) {
        this.drawing=drawing;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {
        mnFile = new Menu("File");
        itNew = new MenuItem("_New");
        itOpen = new MenuItem("Open");
        itOpen.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
        itSave = new MenuItem("Save");
        itExit = new MenuItem("Exit");

        mnFile.getItems().addAll(itNew,itOpen,itSave,new SeparatorMenuItem(),itExit);
        this.getMenus().addAll(mnFile);

        mnEdit = new Menu("Edit");
        itUndo = new MenuItem("Undo");
        itRedo = new MenuItem("Redo");

        mnEdit.getItems().addAll(itUndo,itRedo);
        this.getMenus().addAll(mnEdit);

//        this.setUseSystemMenuBar(true);

    }

    private void registerHandlers() {
        itNew.setOnAction(actionEvent -> {
            drawing.clearAll();
        });
        itOpen.setOnAction(actionEvent -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("File open:");
            fileChooser.setInitialDirectory(new File("."));
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Drawing (*.dat)","dat"),
                    new FileChooser.ExtensionFilter("All,","*.*"));
            File hFile = fileChooser.showOpenDialog(this.getScene().getWindow());
            if (hFile!=null){
                drawing.load(hFile);
            }
        });
        itSave.setOnAction(actionEvent -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("File save:");
            fileChooser.setInitialDirectory(new File("."));
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Drawing (*.dat)","dat"),
                    new FileChooser.ExtensionFilter("All,","*.*"));
            File hFile = fileChooser.showSaveDialog(this.getScene().getWindow());
            if (hFile!=null){
                drawing.save(hFile);
            }
        });
        itExit.setOnAction(actionEvent -> {
            Platform.exit();
        });
    }

    private void update() {
        itUndo.setDisable(true); //itUndo.setDisable(drawing.hasUndo());
        itRedo.setDisable(true);
    }
}
