package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class IHMFX extends Application implements Observateur {
    VueIHMFX vue;
    VueNbCoupIHMFX vueNbCoup;

    public void actualise(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                vueNbCoup.dessine();
                vue.dessine();
            }

        });
    };

    @Override
    public void start(Stage primaryStage) throws Exception{
        Controleur controleur = Controleur.getControleur();
        controleur.abonne(this);

        vue = new VueIHMFX(controleur);
        ControleurIHMFX controleurIHMFX = new ControleurIHMFX(controleur,vue);
        vue.gridPane.setAlignment(Pos.CENTER);
        vueNbCoup= new VueNbCoupIHMFX(controleur);
        vueNbCoup.label.setAlignment(Pos.CENTER);

        /* montage de la scene */
        MonteurScene monteurScene = new MonteurScene();

        Scene scene = monteurScene.
                setCentre(vue.gridPane).
                ajoutBas(controleurIHMFX.reset).
                ajoutBas(vueNbCoup.label).
                setLargeur(1000).
                setHauteur(750).
                retourneScene();

        primaryStage.setScene(scene);
        primaryStage.setTitle("Sokoban");
        primaryStage.show();

        monteurScene.gridPane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                KeyCode input = event.getCode();
                if (input.equals(KeyCode.LEFT)) {
                    controleur.left();
                } else if (input.equals(KeyCode.RIGHT)) {
                    controleur.right();
                } else if (input.equals(KeyCode.UP)) {
                    controleur.up();
                } else if (input.equals(KeyCode.DOWN)) {
                    controleur.down();
                }
                vue.dessine();
            }
        });
        monteurScene.gridPane.requestFocus();
    }

    public void lance() { launch(new String[]{}); }
}

