package pl.jarrobots.battleshipfx;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
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
    private Affine affine1;
    private Affine affine2;
    private Canvas viewGrid;
    public MainView(){
        Simulation simulation = new Simulation();
        
        this.startButton = new Button("HI");

        this.mainGrid = new Canvas(v1,v1);
        this.viewGrid = new Canvas(v2, v2);

        affine1 = new Affine();
        affine2 = new Affine();

        affine1.appendScale(v1/10f,v1/10f);
        affine2.appendScale(v2/10f,v2/10f);

        draw(mainGrid,Color.LIGHTBLUE, affine1);
        draw(viewGrid, Color.WHITESMOKE,  affine2);

        mainGrid.setOnMousePressed(this::drawOnClick);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(this.viewGrid, this.startButton);
        this.getChildren().addAll(this.mainGrid, vBox);
    }

    private void draw(Canvas canvas, Color c, Affine affine){
        GraphicsContext context = canvas.getGraphicsContext2D();
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
        context.setFill(Color.RED);
        context.fillOval(30.0,30.0,60.0,60.0);
    }
    private void drawOnClick(MouseEvent event){

        try {
            Point2D coords = this.affine1.inverseTransform(event.getX(), event.getY());
            int simX = (int) coords.getX();
            int simY = (int) coords.getY();
            System.out.println(simX + " , "+simY);
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
