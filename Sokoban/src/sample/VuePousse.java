package sample;

import javafx.scene.control.Label;

public class VuePousse {

    Controleur controleur;
    Label label = new Label("Nombre de poussees:  0");
    CommandeInt commande;

    public VuePousse(Controleur controleur) {
        this.controleur=controleur;
        commande = controleur.commandePousse();
    }

    public void dessine() {
        label.setText("Nombre de poussees:  "+commande.exec()+"");
    }
}
