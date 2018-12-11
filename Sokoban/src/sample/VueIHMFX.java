package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class VueIHMFX {

    CommandeTabInt commandeGetEtat;
    ImageView[][] jeu;
    GridPane gridPane = new GridPane();
    Controleur controleur; { try { controleur = Controleur.getControleur(); } catch (IOException e) { e.printStackTrace();}}

    Image[] sokoban = new Image[]{
            new Image(new FileInputStream("Soko.png"),50,50,false,false), /*etat 0*/
            new Image(new FileInputStream("blanc.png"),50,50,false,false), /*etat 1*/
            new Image(new FileInputStream("Wall.png"),50,50,false,false), /*etat 2*/
            new Image(new FileInputStream("Caisse.png"),45,45,false,false), /*etat 3*/
            new Image(new FileInputStream("Point.png"),50,50,false,false), /*etat 4*/
            new Image(new FileInputStream("Caisse+Point.png"),45,45,false,false), /*etat 5*/
            new Image(new FileInputStream("Soko+Point.png"),50,50,false,false), /*etat 6*/
    };

    public VueIHMFX(Controleur controleur) throws FileNotFoundException {
        commandeGetEtat = controleur.commandeGetEtat();
        jeu = new ImageView[commandeGetEtat.exec().length][commandeGetEtat.exec()[0].length];
        for (int i=0;i<commandeGetEtat.exec().length;i++) {
            for (int j=0; j<commandeGetEtat.exec()[i].length; j++){
                jeu[i][j] = new ImageView();
                gridPane.add(jeu[i][j],i,j);
            }
        }
        dessine();
    }

    public void dessine() {
        for (int i = 0; i < commandeGetEtat.exec().length; i++) {
            for (int j = 0; j < commandeGetEtat.exec()[i].length; j++) {
                jeu[i][j].setImage(sokoban[commandeGetEtat.exec()[i][j]]);
            }
        }
        if (controleur.getGameOver()) {
            controleur.setGameOver(false);
            controleur.victory();
        }
    }
}
