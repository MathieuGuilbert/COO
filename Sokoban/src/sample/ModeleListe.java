package sample;

import java.util.ArrayList;
import java.util.Iterator;

public class ModeleListe {
	ArrayList<int[][]> listeEtat = new ArrayList<int[][]>();
	Modele modele;
	
	
	public ModeleListe(Modele modele) {
		this.modele = modele;
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
	}
	
	public void down() {
		addList(this.modele.getEtat().clone());
		this.modele.down();
	}
	
	public void right() {
		addList(this.modele.getEtat().clone());
		this.modele.right();
	}
	
	public void left() {
		addList(this.modele.getEtat().clone());
		this.modele.left();
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
