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

    public void actualise(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
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

        /* montage de la scene */
        MonteurScene monteurScene = new MonteurScene();

        Scene scene = monteurScene.
                setCentre(vue.gridPane).
                ajoutBas(controleurIHMFX.reset).
//                ajoutBas(controleurIHMFX.up).
//                ajoutBas(controleurIHMFX.down).
//                ajoutBas(controleurIHMFX.left).
//                ajoutBas(controleurIHMFX.right).
                setLargeur(1000).
                setHauteur(800).
                retourneScene();

        primaryStage.setScene(scene);

        primaryStage.setTitle("Sokoban");
        primaryStage.show();

        vue.gridPane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
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
        vue.gridPane.requestFocus();
    }

    public void lance() { launch(new String[]{}); }
}

