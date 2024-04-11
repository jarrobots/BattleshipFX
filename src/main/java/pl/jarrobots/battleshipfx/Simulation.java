package pl.jarrobots.battleshipfx;

public class Simulation {
    int[][] enemy;
    int[][] you;

    public Simulation(){
        enemy = new int[10][10];
        you = new int[10][10];
    }

    public void addShot(int x, int y){
        enemy[x][y] = 1;
    }

    public int[][] getEnemy(){
        return enemy;
    }

}
