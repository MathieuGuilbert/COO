package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControleurIHMFX {
    Controleur controleur;
    VueIHMFX vue;
    Button reset,undo,redo;

    ControleurIHMFX(Controleur controleur, VueIHMFX vue) {
        this.controleur = controleur;
        this.vue = vue;

        undo = new Button("Undo");
        redo = new Button("Redo");
        reset = new Button("Reset");
        reset.setOnAction(new ActionReset());
        undo.setOnAction(new ActionUndo());
        redo.setOnAction(new ActionRedo());
    }

    class ActionReset implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {  controleur.reset(); }
    }
    
    class ActionUndo implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {  controleur.undo(); }
    }
    
    class ActionRedo implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {  controleur.redo(); }
    }
}