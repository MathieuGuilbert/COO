package sample;

import javafx.util.Pair;

public interface Modele {
    public int[][] getEtat();
    public void right();
    public void left();
    public void up();
    public void down();
    public void reset();
}
