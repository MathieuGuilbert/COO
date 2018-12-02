package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.util.Pair;

public class ControleurIHMFX {
    Controleur controleur;
    VueIHMFX vue;
    Button reset;
    Button up, down, left, right;

    ControleurIHMFX(Controleur controleur, VueIHMFX vue) {
        this.controleur = controleur;
        this.vue = vue;

        reset = new Button("Reset");
        up = new Button ("▲");
        down = new Button ("▼");
        left = new Button ("◄");
        right = new Button ("►");


        reset.setOnAction(new ActionReset());

        up.setOnAction(new Up());
        down.setOnAction(new Down());
        left.setOnAction(new Left());
        right.setOnAction(new Right());

    }

    class ActionReset implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            controleur.reset();
        }

    }
    class Right implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {  controleur.right();}
    }
    class Left implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {  controleur.left();}
    }
    class Up implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {  controleur.up();}
    }
    class Down implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {  controleur.down();}
    }
}