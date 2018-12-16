package sample;

public class ModeleNbCoup implements Modele {

    Modele modele;
    int nbCoup=0;

    public ModeleNbCoup(Modele modele) {
        this.modele = modele;
    }

    public int getNbCoup(){
        return nbCoup;
    }

    public void reset() {
        nbCoup=0;
        modele.reset();
    }

    public int[][] getEtat() {
        return modele.getEtat();
    }

    public void setEtat(int[][] etat) {
		modele.setEtat(etat);
	}
    
    public boolean up() {
        nbCoup++;
        return this.modele.up();
    }

    public boolean down() {
        nbCoup++;
        return this.modele.down();
    }

    public boolean right() {
        nbCoup++;
        return this.modele.right();
    }

    public boolean left() {
        nbCoup++;
        return this.modele.left();
    }
    
    public void undo() {
    	nbCoup++;
    }
    
    public void redo() {
    	nbCoup++;
    }
}
