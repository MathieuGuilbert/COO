package sample;

import javafx.util.Pair;

import java.util.ArrayList;

public class Controleur implements Sujet {
    private static Controleur singleton;


    public static Controleur getControleur() {
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
        for (Observateur observateur:observateurs)
            observateur.actualise();
    }

    public void right(int[][] etat, int x, int y) {
        facadeModele.right(etat,x,y);
        notifie();
    }
    public void left(int[][] etat, int x, int y) {
        facadeModele.left(etat,x,y);
        notifie();
    }
    public void up(int[][] etat, int x, int y) {
        facadeModele.up(etat,x,y);
        notifie();
    }
    public void down(int[][] etat, int x, int y) {
        facadeModele.down(etat,x,y);
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

    public Pair<Integer, Integer> positionSoko(int[][] exec) { return facadeModele.positionSoko(exec); }
}
