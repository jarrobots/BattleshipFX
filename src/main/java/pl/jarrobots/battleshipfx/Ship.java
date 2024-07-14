package pl.jarrobots.battleshipfx;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;

public class Ship extends Pane {
    private String name;
    private Canvas canvas;
    private int number;
    private Affine affine;

    public Ship(String name,  int number) {
        canvas = new Canvas();
        this.name = name;
        this.number = number;
        affine = new Affine();
        affine.appendScale(40f,40f);
        this.drawShip(canvas.getGraphicsContext2D());
        this.getChildren().add(canvas);
    }

    public String getName(){
        return name;
    }
    public int getNumber(){
        return number;
    }

    public Affine getAffine() {
        return affine;
    }

    private void drawShip(GraphicsContext context) {

        context.setTransform(affine);
        context.setFill(Color.YELLOW);
        context.fillRect(0, 0, 40, number * 40);
        /*
        context.setStroke(Color.BLACK);
        context.setLineWidth(0.05);
        for (int i = 0; i <= 10; i++) {
            context.strokeLine(i, 0, i, number);
        }
        */
    }

}
