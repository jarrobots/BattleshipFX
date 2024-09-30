package pl.jarrobots.battleshipfx;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public abstract class AlertBox{
    public static void display(String text){
        Stage window = new Stage();
        HBox pane = new HBox();
        Label label = new Label();
        label.setText(text);
        pane.getChildren().add(label);
        window.setScene(new Scene(pane));
        window.setAlwaysOnTop(true);
        window.show();
    }
}
