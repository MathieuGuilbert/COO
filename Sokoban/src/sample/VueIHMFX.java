package sample;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VueIHMFX {

    CommandeTabInt commandeGetEtat;
    ImageView[][] myButton;
    GridPane gridPane = new GridPane();

    Image[] sokoban = new Image[]{
            new Image(new FileInputStream("Character4.png"),40,60,false,false), /*etat 0*/
            new Image(new FileInputStream("blanc.png"),50,60,false,false), /*etat 1*/
            new Image(new FileInputStream("Wall.png"),50,60,false,false), /*etat 2*/
            new Image(new FileInputStream("Caisse.png"),45,45,false,false), /*etat 3*/
            new Image(new FileInputStream("Point.png"),25,25,false,false), /*etat 4*/
            new Image(new FileInputStream("Caisse_.png"),45,45,false,false), /*etat 5*/
    };


    public VueIHMFX(Controleur controleur) throws FileNotFoundException {
        commandeGetEtat = controleur.commandeGetEtat();
        myButton = new ImageView[commandeGetEtat.exec().length][commandeGetEtat.exec()[0].length];
        for (int i=0;i<commandeGetEtat.exec().length;i++) {
            for (int j=0; j<commandeGetEtat.exec()[i].length; j++){
                myButton[i][j] = new ImageView();
                gridPane.add(myButton[i][j],i,j);
            }
        }
        dessine();
    }
    public void dessine() {
        for (int i=0;i<commandeGetEtat.exec().length;i++) {
            for (int j=0; j<commandeGetEtat.exec()[i].length; j++){
                myButton[i][j].setImage(sokoban[commandeGetEtat.exec()[i][j]]);
            }
        }
    }
}
