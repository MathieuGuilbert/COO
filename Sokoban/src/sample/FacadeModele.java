package sample;

import javafx.util.Pair;

public class FacadeModele {
    ModeleConcret modele = new ModeleConcret();

    public int[][] getEtat() {
        return modele.getEtat();
    }

    public void reset() {
        modele.reset();
    }

    public void right(int[][] etat, int x, int y) { modele.right(etat,x,y); }
    public void left(int[][] etat, int x, int y) { modele.left(etat,x,y); }
    public void up(int[][] etat, int x, int y) { modele.up(etat,x,y); }
    public void down(int[][] etat, int x, int y) { modele.down(etat,x,y); }

    public Pair<Integer, Integer> positionSoko(int[][] exec) { return modele.positionSoko(exec); }
}
