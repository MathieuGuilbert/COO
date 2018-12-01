package sample;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VueIHMFX {

    CommandeTabInt commandeGetEtat;
    Button[][] myButton;
    GridPane gridPane = new GridPane();

    Image[] sokoban = new Image[]{
            new Image(new FileInputStream("Character4.png"),40,60,false,false),
            new Image(new FileInputStream("blanc.png"),40,60,false,false),
    };


    public VueIHMFX(Controleur controleur) throws FileNotFoundException {
        commandeGetEtat = controleur.commandeGetEtat();
        myButton = new Button[commandeGetEtat.exec().length][commandeGetEtat.exec()[0].length];
        for (int i=0;i<commandeGetEtat.exec().length;i++) {
            for (int j=0; j<commandeGetEtat.exec()[i].length; j++){
                myButton[i][j] = new Button();
                myButton[i][j].setMinSize(50,50);
                gridPane.add(myButton[i][j],i,j);
            }
        }
        dessine();
    }
    public void dessine() {
        for (int i=0;i<commandeGetEtat.exec().length;i++) {
            for (int j=0; j<commandeGetEtat.exec()[i].length; j++){
                myButton[i][j].setGraphic(new ImageView(sokoban[commandeGetEtat.exec()[i][j]]));
            }
        }
    }
}
