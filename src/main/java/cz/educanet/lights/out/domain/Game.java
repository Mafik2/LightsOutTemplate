package cz.educanet.lights.out.domain;

import cz.educanet.lights.out.domain.interfaces.ILightsOut;

import java.util.Random;

public class Game implements ILightsOut {
    public int moveCounter;
    public boolean[][] active;

    public Game() {
        moveCounter = 0;
        active = new boolean[5][5];
        Random randomno = new Random();
        for (int i = 0; i < active.length; i++) {
            for (int j = 0; j < active[i].length; j++) {
                active[i][j] = randomno.nextBoolean();

            }
        }
    }

    @Override
    public boolean getMoveCount() {
   return false;
    }

    @Override
    public boolean isGameOver() {
        for (boolean[] gameover : this.active) {
            for (boolean gameOverBoolean : gameover) {
                if(gameOverBoolean) return false;
            }
        }
        return true;
    }

    @Override
    public boolean[][] getGrid() {
        return active;
    }

    @Override
    public void makeMove(int x, int y) {
        this.active[x][y] = !this.active[x][y];
        for (int i = -1; i <= 1; i++) {
            if(i==0) continue;
            if(xy(x+i,y)) this.active[x+i][y] = !this.active[x+i][y];
            if(xy(x,y+i)) this.active[x][y+i] = !this.active[x][y+i];

        }
        moveCounter++;
    }
    private boolean xy(int x, int y) {
        return x >= 0 && y >= 0 && y < this.active.length;
    }
}
