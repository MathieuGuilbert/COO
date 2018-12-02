package sample;

import javafx.util.Pair;

public interface Modele {
    public int[][] getEtat();
    public Pair<Integer, Integer> positionSoko();
    public void right(int x, int y);
    public void left(int x, int y);
    public void up(int x, int y);
    public void down(int x, int y);
    public void reset();
}
