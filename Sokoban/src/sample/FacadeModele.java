package sample;

import javafx.util.Pair;

public class FacadeModele {;
    ModeleListe modele= new ModeleListe(new ModeleConcret());
    
    public int[][] getEtat() { return modele.getEtat(); }

    public void reset() { modele.reset(); }

    public void right() { modele.right(); }
    public void left() { modele.left(); }
    public void up() { modele.up(); }
    public void down() { modele.down(); }
}
