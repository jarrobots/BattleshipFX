package pl.jarrobots.battleshipfx;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class StartScene extends GridPane {

    Button button = new Button("OK");
    TextField textField = new TextField();
    Label label = new Label("IP routera");

    public StartScene(Stage window, Scene scene){
        this.add(label,1,1);
        this.add(textField,2,1);
        this.add(button,1,2);
        button.setOnAction( e-> window.setScene(scene));

    }

}
