package cz.educanet.lights.out.domain.interfaces;

public interface ILightsOut {

    /**
     * @return Count of player moves.
     */
    boolean getMoveCount();

    /**
     * @return
     */
    boolean isGameOver();

    /**
     * @return Grid representing switched on and off lights
     */
    boolean[][] getGrid();

    /**
     * Simulates one round of the Lights Out game.
     * @param x
     * @param y
     */
    void makeMove(int x, int y);
}
