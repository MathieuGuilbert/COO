package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControleurIHMFX {
    Controleur controleur;
    VueIHMFX vue;
    Button reset;
    Button up, down, left, right;

    ControleurIHMFX(Controleur controleur, VueIHMFX vue) {
        this.controleur = controleur;
        this.vue = vue;

        for (int i=0; i<vue.myButton.length;i++)
            vue.myButton[i].setOnAction(new MyAction(i));

        reset = new Button("Reset");
        up = new Button ("▲");
        down = new Button ("▼");
        left = new Button ("◄");
        right = new Button ("►");
        reset.setOnAction(new ActionReset());
    }

    class ActionReset implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            controleur.reset();
        }

    }

    class MyAction implements EventHandler<ActionEvent> {
        int indice;

        MyAction(int indice) {
            this.indice = indice;
        }

        @Override
        public void handle(ActionEvent event) {
            controleur.move(indice);
        }
    }
}