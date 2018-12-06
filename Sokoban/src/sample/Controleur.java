package sample;

import javafx.util.Pair;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.*;

public class Controleur implements Sujet {
    private static Controleur singleton;


    public static Controleur getControleur() throws IOException {
        if (singleton == null)
            singleton = new Controleur(new FacadeModele());
        return singleton;
    }

    FacadeModele facadeModele;
    ArrayList<Observateur> observateurs = new ArrayList<Observateur>();

    private Controleur(FacadeModele facadeModele) {
        this.facadeModele = facadeModele;
    }

    public void abonne(Observateur observateur) {
        observateurs.add(observateur);
    }

    @Override
    public void notifie() {
        for (Observateur observateur:observateurs) {
        	observateur.actualise();
        	System.out.println(facadeModele.gameOver());
        }
    }

    public void right() {
        facadeModele.right();
        notifie();
    }
    public void left() {
        facadeModele.left();
        notifie();
    }
    public void up() {
        facadeModele.up();
        notifie();
    }
    public void down() {
        facadeModele.down();
        notifie();
    }

    public void reset() {
        facadeModele.reset();
        notifie();
    }

    public CommandeTabInt commandeGetEtat() {
        return new CommandeTabInt() {
            @Override
            public int[][] exec() {
                return facadeModele.getEtat();
            }
        };
    }
}
