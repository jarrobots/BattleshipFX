package pl.jarrobots.battleshipfx;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class SettingScene extends GridPane {
    private static final int a = 40;
    private static final int x = 15;
    private static final int y = 10;
    private static final int v1 = 600;
    private static final int v2 = 400;
    private Canvas mainGrid;

    private final ArrayList<Ship> ships;

    private final Affine affine1;

    public SettingScene(Stage window, Connector connector){

        ships = new ArrayList<>();

        this.mainGrid = new Canvas(v1,v2);


        affine1 = new Affine();
        affine1.appendScale(v1/15f,v2/10f);

        GraphicsContext gc2 = mainGrid.getGraphicsContext2D();

        this.draw(gc2,v1,v1);
        settingShips();

        Pane grids = new Pane();
        grids.getChildren().addAll(mainGrid, ships.get(0), ships.get(1), ships.get(2), ships.get(3), ships.get(4));
        mainGrid.toBack();

        Button button = new Button("Ok");
        button.setOnAction(e-> {
            int[][] a = shipsLayout();
            try {
                int sendValue = connector.sendInitialArray(a);
            }
            catch (IOException exception){
                exception.printStackTrace();
            }

            MainView mainView = new MainView();
            Scene scene = new Scene(mainView, 800, 500);

            window.setScene(scene);
            e.consume();
        });

        this.add(grids,1,1);
        this.add(button,0,0);
    }

    private int[][] shipsLayout(){
        int[][] array = new int[10][10];
        ArrayList<double[]> list = new ArrayList<>();

        for(Ship ship : ships){
            int x = (int) (ship.getLayoutX()/40) - 5;
            int y = (int) (ship.getLayoutY()/40);

            for(int i = 0 ; i < ship.getNumber(); i++){
                array[y][x+i] = 1;
            }
        }

        return array;
    }

    private void settingShips(){
        ships.add(new Ship("Carrier", 5));
        ships.add(new Ship("Battleship",4));
        ships.add(new Ship("Cruiser",3));
        ships.add(new Ship("Submarine",2));
        ships.add(new Ship("Destroyer",1));

        this.add(ships.get(0),0 ,1);
        this.add(ships.get(1),0 ,2);
        this.add(ships.get(2),0 ,3);
        this.add(ships.get(3),0 ,4);
        this.add(ships.get(4),0 ,5);

        DraggableMaker draggableMaker = new DraggableMaker();
        for(Ship ship : ships){
            draggableMaker.makeDraggable(ship);
        }
    }

    private void draw(GraphicsContext context, int i1, int i2){

        context.setTransform(affine1);
        context.setFill(Color.WHITESMOKE);
        context.fillRect(0,0,i1,i2);


        context.setStroke(Color.BLACK);
        context.setLineWidth(0.05);

        for(int i = 0; i<=10;i++){
            context.strokeLine(5,i,x,i);
        }
        for(int i = 5; i<=15;i++){
            context.strokeLine(i,0,i,y);
        }
    }


}
