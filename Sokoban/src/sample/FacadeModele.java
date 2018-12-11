package sample;

public class FacadeModele {;
    ModeleListe modele= new ModeleListe( new ModeleNbCoup( new ModeleConcret()) );
    
    public int[][] getEtat() { return modele.getEtat(); }

    public void reset() { modele.reset(); }

    public void right() { modele.right(); }
    public void left() { modele.left(); }
    public void up() { modele.up(); }
    public void down() { modele.down(); }

    public void gameOver() { modele.gameOver(getEtat());}
    public boolean getGameOver() { return modele.getGameOver();}
    public void setGameOver(boolean b) { modele.setGameOver(b);}

    public int nbCoup() {
        return modele.getNbCoup();
    }

}
