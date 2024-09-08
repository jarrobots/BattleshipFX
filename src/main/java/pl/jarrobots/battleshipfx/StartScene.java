package pl.jarrobots.battleshipfx;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.IOException;

public class StartScene extends GridPane {

    Button button = new Button("OK");
    TextField ipTextField = new TextField();
    Label label1 = new Label("IP routera");
    TextField  portTextField = new TextField();
    Label label2 = new Label("port");

    public StartScene(Stage window){
        this.add(label1,1,1);
        this.add(ipTextField,2,1);
        this.add(button,1,3);
        this.add(label2,1,2);
        this.add(portTextField,2,2);

        button.setOnAction( e-> {
            Connector connector = null;
            try{
                connector = new Connector(ipTextField.getText(), portTextField.getText());
            }
            catch (IOException exception){
                exception.printStackTrace();
            }

            SettingScene settingScene = new SettingScene(window, connector);
            Scene scene = new Scene(settingScene);
            window.setScene(scene);

        });

    }


}
