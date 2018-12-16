package sample;

import javafx.scene.control.Alert;
import java.io.IOException;
import java.util.ArrayList;

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
    
    public void undo() {
        facadeModele.undo();
        notifie();
    }

    public void redo() {
        facadeModele.redo();
        notifie();
    }
    public boolean getGameOver() { return facadeModele.getGameOver();}
    public void setGameOver(boolean b) { facadeModele.setGameOver(b);}


    public CommandeTabInt commandeGetEtat() {
        return new CommandeTabInt() {
            @Override
            public int[][] exec() {
                return facadeModele.getEtat();
            }
        };
    }

    public CommandeInt commandeNbCoup() {
        return new CommandeInt() {
            @Override
            public int exec() {
                return facadeModele.nbCoup();
            }
        };
    }

    public CommandeInt commandePousse() {
        return new CommandeInt() {
            @Override
            public int exec() {
                return facadeModele.nbPousse();
            }
        };
    }

//    Creer une fenetre popup
    public void victory(){
        Alert victoire = new Alert(Alert.AlertType.INFORMATION);
        victoire.setTitle("Victoire");
        victoire.setHeaderText("BRAVO    \\^.^/");
        victoire.setContentText("Vous avez réussis ce niveau en "+ facadeModele.nbCoup() +" déplacements et en "+ facadeModele.nbPousse() +" poussees");
        victoire.showAndWait();
    }
}
