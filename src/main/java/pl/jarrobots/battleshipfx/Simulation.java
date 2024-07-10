package pl.jarrobots.battleshipfx;

import javafx.scene.paint.Color;

import java.util.Optional;

public class Simulation {
    boolean turn;
    int[][] enemy;
    int[][] you;

    public Simulation(){
        turn = false;
        enemy = new int[10][10];
        you = new int[10][10];
    }

    public Optional<Color> addShot(int x, int y){
        if(enemy[x][y] == 1) {
            return Optional.empty();
        }

        enemy[x][y] = 1;
        return Optional.of(Color.RED);
    }

    public int[][] getEnemy(){
        return enemy;
    }


}
