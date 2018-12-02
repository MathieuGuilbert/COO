package sample;

import javafx.util.Pair;

public class FacadeModele {
    ModeleConcret modele = new ModeleConcret();

    public int[][] getEtat() { return modele.getEtat(); }

    public void reset() { modele.reset(); }

    public void right(int x, int y) { modele.right(x,y); }
    public void left(int x, int y) { modele.left(x,y); }
    public void up(int x, int y) { modele.up(x,y); }
    public void down(int x, int y) { modele.down(x,y); }

    public Pair<Integer, Integer> positionSoko() { return modele.positionSoko(); }
}
