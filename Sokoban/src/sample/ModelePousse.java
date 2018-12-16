package sample;

public class ModelePousse implements Modele{

    Modele modele;
    int nbPousse=0;

    public ModelePousse(Modele modele) {
        this.modele = modele;
    }

    public int getNbPousse(){
        return nbPousse;
    }

    public void reset() {
        nbPousse=0;
        modele.reset();
    }

    public int[][] getEtat() {
        return modele.getEtat();
    }
    
    public void setEtat(int[][] etat) {
		modele.setEtat(etat);
	}

    public boolean up() {
        if(this.modele.up()){  //si pousse est vrai
            nbPousse++;
        }
        return true;
    }

    public boolean down() {
        if(this.modele.down()){  //si pousse c'est vrai
            nbPousse++;
        }
        return true;
    }

    public boolean right() {
        if(this.modele.right()){  //si pousse c'est vrai
            nbPousse++;
        }
        return true;
    }

    public boolean left() {
        if(this.modele.left()){  //si pousse c'est vrai
            nbPousse++;
        }
        return true;
    }
}
