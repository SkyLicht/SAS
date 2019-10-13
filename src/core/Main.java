package core;

import core.apps.vada.Vada;
import core.apps.vada.VadaConfig;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{//1024×768


        //Vada vada = new Vada(1024,768);
        VadaConfig config = new VadaConfig(1024,768);


    }


    public static void main(String[] args) {
        launch(args);
    }
}
