package sample;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VueIHMFX {

    CommandeTabInt commandeGetEtat;
    ImageView[][] jeu;
    GridPane gridPane = new GridPane();

    Image[] sokoban = new Image[]{
            new Image(new FileInputStream("Soko.png"),40,60,false,false), /*etat 0*/
            new Image(new FileInputStream("blanc.png"),50,60,false,false), /*etat 1*/
            new Image(new FileInputStream("Wall.png"),50,60,false,false), /*etat 2*/
            new Image(new FileInputStream("Caisse.png"),45,45,false,false), /*etat 3*/
            new Image(new FileInputStream("Point.png"),25,25,false,false), /*etat 4*/
            new Image(new FileInputStream("Caisse+Point.png"),45,45,false,false), /*etat 5*/
            new Image(new FileInputStream("Soko+Point.png"),40,60,false,false), /*etat 6*/
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
        for (int i=0;i<commandeGetEtat.exec().length;i++) {
            for (int j=0; j<commandeGetEtat.exec()[i].length; j++){
                jeu[i][j].setImage(sokoban[commandeGetEtat.exec()[i][j]]);
            }
        }
    }
}
