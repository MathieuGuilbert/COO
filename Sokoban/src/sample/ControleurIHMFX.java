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

        Pair<Integer,Integer> pos = controleur.positionSoko(controleur.commandeGetEtat().exec());
        int x = pos.getKey(); int y = pos.getValue();
        up.setOnAction(new Up(x,y));
        down.setOnAction(new Down(x,y));
        left.setOnAction(new Left(x,y));
        right.setOnAction(new Right(x,y));
    }

    class ActionReset implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            controleur.reset();
        }

    }
    class Right implements EventHandler<ActionEvent> {
        int[][] etat; int x; int y;

        Right(int x, int y) {
            this.etat = controleur.commandeGetEtat().exec(); this.x = x; this.y = y;
        }

        @Override
        public void handle(ActionEvent event) {
            controleur.right(etat,x,y);
        }
    }
    class Left implements EventHandler<ActionEvent> {
        int[][] etat; int x; int y;

        Left(int x, int y) {
            this.etat = controleur.commandeGetEtat().exec(); this.x = x; this.y = y;
        }

        @Override
        public void handle(ActionEvent event) {
            controleur.left(etat,x,y);
        }
    }
    class Up implements EventHandler<ActionEvent> {
        int[][] etat; int x; int y;

        Up(int x, int y) {
            this.etat = controleur.commandeGetEtat().exec(); this.x = x; this.y = y;
        }

        @Override
        public void handle(ActionEvent event) {
            controleur.up(etat,x,y);
        }
    }
    class Down implements EventHandler<ActionEvent> {
        int[][] etat; int x; int y;

        Down(int x, int y) {
            this.etat = controleur.commandeGetEtat().exec(); this.x = x; this.y = y;
        }

        @Override
        public void handle(ActionEvent event) {
            controleur.down(etat,x,y);
        }
    }
}