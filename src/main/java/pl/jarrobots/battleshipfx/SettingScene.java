package pl.jarrobots.battleshipfx;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collection;

public class SettingScene extends GridPane {
    private static final int a = 40;
    private static final int v1 = 400;
    private Canvas mainGrid;
    private Canvas actionGrid;

    private ArrayList<Ship> ships;

    private Affine affine1;
    private Button button = new Button("Ok");
    public SettingScene(Stage window, Scene scene){

        ships = new ArrayList<>();

        this.mainGrid = new Canvas(v1,v1);
        this.actionGrid = new Canvas(v1,v1);

        affine1 = new Affine();
        affine1.appendScale(v1/10f,v1/10f);

        GraphicsContext gc2 = mainGrid.getGraphicsContext2D();
        GraphicsContext gc1 = actionGrid.getGraphicsContext2D();

        Pane grids = new Pane();
        grids.getChildren().addAll(mainGrid,actionGrid);
        actionGrid.toFront();

        button.setOnAction( e-> {
            window.setScene(scene);
            e.consume();
        });

        this.draw(gc2,v1,v1);

        //this.add(grids,0,0);
        this.add(button,0,1);
        this.settingShips();
        Ship ship = ships.get(4);
        this.add(ship,0,1);



    }
    private void settingShips(){
        ships.add(new Ship("Carrier", 5));
        ships.add(new Ship("Battleship",4));
        ships.add(new Ship("Cruiser",3));
        ships.add(new Ship("Submarine",2));
        ships.add(new Ship("Destroyer",1));


        /*for(Ship ship : ships){
            this.add(ship.getShipCanvas(),ship.getNumber(),0);
        } */

    }

    private void draw(GraphicsContext context, int i1, int i2){

        context.setTransform(affine1);
        context.setFill(Color.WHITESMOKE);
        context.fillRect(0,0,i1,i2);


        context.setStroke(Color.BLACK);
        context.setLineWidth(0.05);

        for(int i = 0; i<=10;i++){
            context.strokeLine(0,i,10,i);
        }
        for(int i = 0; i<=10;i++){
            context.strokeLine(i,0,i,10);
        }
    }


}