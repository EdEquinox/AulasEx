package pt.isec.pa.aulas.ex28.ui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import pt.isec.pa.aulas.ex28.ui.RootPane;

public class JavaFxMain extends Application {
    public JavaFxMain() {
        System.out.println("contrutor");
    }

    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("init");
    }

    //____so para eventos complexos____

    class MyEventHandler implements EventHandler<WindowEvent>{

        @Override
        public void handle(WindowEvent windowEvent) {
            System.out.println("evento class");
        }
    }

    //--------------------------------

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("Stageinit");
        stage.setTitle("Trollada do Kazzio");
        stage.setOnHiding(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                System.out.println("class anonima");
            }
        });
        stage.setOnShowing(windowEvent -> {
            System.out.println("lambda");
        });
        stage.setOnShown(windowEvent -> System.out.println("simple lambda"));
        stage.setOnCloseRequest(windowEvent -> new MyEventHandler() );

        RootPane root = new RootPane();

        Scene scene = new Scene(root,600,400);

        stage.setScene(scene);
        stage.show();
        System.out.println("Stageend");
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("stop");
    }
}
