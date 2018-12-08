package sample;
import java.util.*;

import javafx.util.Pair;

public class ModeleNbCoup implements Modele {

    Modele modele;
    int nbCoup=0;

    public ModeleNbCoup(Modele modele) {
        this.modele = modele;
    }

    public int getNbCoup(){
        return nbCoup;
    }



    public void reset() {
        nbCoup=0;
        modele.reset();
    }

    public int[][] getEtat() {
        return modele.getEtat();
    }

    public void up() {
        nbCoup++;
        this.modele.up();
    }

    public void down() {
        nbCoup++;
        this.modele.down();
    }

    public void right() {
        nbCoup++;
        this.modele.right();
    }

    public void left() {
        nbCoup++;
        this.modele.left();
    }

}
