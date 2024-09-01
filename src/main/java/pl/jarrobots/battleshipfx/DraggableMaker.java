package pl.jarrobots.battleshipfx;

import javafx.scene.Node;

public class DraggableMaker {
    private final int cellSize = 40;
    private int pressX;
    private int pressY;



    public void makeDraggable( Node node){
        final int finalX;
        final int finalY;

        node.setOnMousePressed(mouseEvent -> {
            pressX = (int) mouseEvent.getX()/cellSize;
            pressY = (int) mouseEvent.getY()/cellSize;
        });

        node.setOnMouseDragged( e -> {
            int x = (int) (e.getSceneX()/cellSize) - pressX;
            int y = (int) (e.getSceneY()/cellSize) - pressY;

            node.setLayoutX(x*40);
            node.setLayoutY(y*40);
        });
    }

}
