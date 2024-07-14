package pl.jarrobots.battleshipfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        MainView mainView = new MainView();
        Scene scene3 = new Scene(mainView, 800, 500);

        SettingScene settingScene = new SettingScene(stage,scene3);
        Scene scene2 = new Scene(settingScene);

        StartScene startScene = new StartScene(stage,scene2);
        Scene scene1 = new Scene(startScene,800,500);

        stage.setTitle("Battleship Game");
        stage.setScene(scene1);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}