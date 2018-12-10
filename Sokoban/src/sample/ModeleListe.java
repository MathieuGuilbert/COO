package sample;

import java.util.ArrayList;
import java.util.Iterator;

public class ModeleListe implements Modele{
	ArrayList<int[][]> listeEtat = new ArrayList<int[][]>();
	ModeleNbCoup modele;
	
	
	public ModeleListe(ModeleNbCoup modele) {
		this.modele = modele;
	}

	public int getNbCoup(){
		return modele.getNbCoup();
	}

	public ArrayList<int[][]> getListeEtat() {
		return listeEtat;
	}

	public void addList(int[][] etat) {
    	listeEtat.add(etat.clone());
    }
	
	public void reset() {
		modele.reset();
	}
	
	public int[][] getEtat() {
		return modele.getEtat();
	}
	
	public void up() {
		addList(this.modele.getEtat().clone());
		this.modele.up();
		gameOver(modele.getEtat());
	}
	
	public void down() {
		addList(this.modele.getEtat().clone());
		this.modele.down();
		gameOver(modele.getEtat());
	}
	
	public void right() {
		addList(this.modele.getEtat().clone());
		this.modele.right();
		gameOver(modele.getEtat());
	}
	
	public void left() {
		addList(this.modele.getEtat().clone());
		this.modele.left();
		gameOver(modele.getEtat());
	}
	
	public boolean gameOver(int[][] etat){
		for(int i=0;i<etat.length;i++) {
			for(int j=0;j<etat[i].length;j++) {
				if(etat[i][j]==3) {
					return false;
				}
	    	}	
	    }	
		Iterator it = listeEtat.iterator();
		while(it.hasNext()) {
			int[][] tmp = (int[][]) it.next();
			System.out.println(" ");
			for(int i = 0;i<tmp.length;i++) {
				for(int j = 0;j<tmp[i].length;j++) {
					System.out.print(tmp[i][j] + " / ");
				}
				System.out.println(" ");
	   		}	
	   	}
	   	return true;
	   }

}


