package pl.jarrobots.battleshipfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        StartScene startScene = new StartScene(stage);
        Scene scene1 = new Scene(startScene,800,500);

        stage.setTitle("Battleship Game");
        stage.setScene(scene1);
        stage.show();

    }
}