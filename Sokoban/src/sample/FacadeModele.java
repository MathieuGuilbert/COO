package sample;

public class FacadeModele {;
    ModeleNbCoup modeleNbCoup= new ModeleNbCoup( new ModeleConcret());
    ModelePousse modelePousse= new ModelePousse(modeleNbCoup);
    ModeleListe modele= new ModeleListe( modelePousse);
    
    public int[][] getEtat() { return modele.getEtat(); }

    public void reset() { modele.reset(); }

    public void right() { modele.right(); }
    public void left() { modele.left(); }
    public void up() { modele.up(); }
    public void down() { modele.down(); }
    public void undo() { 
    	modele.undo();
    	modeleNbCoup.undo();
    }
    public void redo() {
    	modele.redo();
    	modeleNbCoup.redo();
    }
    
    public void gameOver() { modele.gameOver(getEtat());}
    public boolean getGameOver() { return modele.getGameOver();}
    public void setGameOver(boolean b) { modele.setGameOver(b);}

    public int nbCoup() {
        return modeleNbCoup.getNbCoup();
    }

    public int nbPousse() {return modelePousse.getNbPousse(); }
}
