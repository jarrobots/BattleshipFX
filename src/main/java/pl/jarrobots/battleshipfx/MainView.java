package pl.jarrobots.battleshipfx;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Affine;
import javafx.scene.transform.NonInvertibleTransformException;


public class MainView extends HBox {
    private final int v1 = 500;
    private final int v2 = 200;
    private Button startButton;
    private Canvas mainGrid;
    private Canvas actionGrid;
    private Affine affine1;
    private Affine affine2;
    private Canvas viewGrid;
    public MainView(){
        Simulation simulation = new Simulation();
        
        this.startButton = new Button("HI");

        this.mainGrid = new Canvas(v1,v1);
        this.actionGrid = new Canvas(v1,v1);
        this.viewGrid = new Canvas(v2, v2);

        affine1 = new Affine();
        affine2 = new Affine();

        affine1.appendScale(v1/10f,v1/10f);
        affine2.appendScale(v2/10f,v2/10f);

        GraphicsContext gc3 = mainGrid.getGraphicsContext2D();
        GraphicsContext gc2 = viewGrid.getGraphicsContext2D();
        GraphicsContext gc1 = actionGrid.getGraphicsContext2D();


        draw(gc3,Color.LIGHTBLUE, affine1);
        draw(gc2, Color.WHITESMOKE, affine2);

        actionGrid.setOnMousePressed( e -> { this.drawOnClick(e, gc1);});

        Pane grids = new Pane();
        grids.getChildren().addAll(mainGrid,actionGrid);
        actionGrid.toFront();
        VBox vBox = new VBox();
        vBox.getChildren().addAll(this.viewGrid, this.startButton);
        this.getChildren().addAll(grids, vBox);
    }

    private void draw(GraphicsContext context, Color c, Affine affine){

        context.setTransform(affine);
        context.setFill(c);
        context.fillRect(0,0,v1,v1);


        context.setStroke(Color.BLACK);
        context.setLineWidth(0.05);
        for(int i = 0; i<=10; i++){
            context.strokeLine(i,0,i,10);
        }

        for(int j = 0; j<=10;j++){
            context.strokeLine(0,j,10,j);
        }
    }
    private void drawOnClick(MouseEvent event, GraphicsContext context){

        try {
            Point2D coords = this.affine1.inverseTransform(event.getX(), event.getY());
            int simX = (int) coords.getX();
            int simY = (int) coords.getY();
            context.setFill(Color.RED);
            context.fillRect(simX*v1/10f,simY*v1/10f, v1/10f, v1/10f);
            System.out.println(simX + " " +simY);
        }catch (NonInvertibleTransformException e){
            e.printStackTrace();
        }

    }

    private int[] getXYProcessed(double x, double y, int v){
        int c[] = new int[4];
        for(double i = 0.0;i<=v;i+=40){
            if(x<i){
                c[0] = (int) i-40;
                c[1] = (int) i;
                break;
            }
        }
        for(double j = 0.0; j<=v; j+=40){
            if(y<j){
                c[2] = (int) j-40;
                c[3] = (int) j;
                break;
            }
        }
        return c;
    }

}
