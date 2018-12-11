package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControleurIHMFX {
    Controleur controleur;
    VueIHMFX vue;
    Button reset;

    ControleurIHMFX(Controleur controleur, VueIHMFX vue) {
        this.controleur = controleur;
        this.vue = vue;

        reset = new Button("Reset");
        reset.setOnAction(new ActionReset());

    }

    class ActionReset implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {  controleur.reset(); }
    }
}