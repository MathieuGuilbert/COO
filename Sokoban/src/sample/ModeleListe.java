package sample;

import java.util.ArrayList;
import java.util.Iterator;

public class ModeleListe implements Modele{
	ArrayList<int[][]> listeEtat = new ArrayList<int[][]>(); //liste contenant les etats
	Modele modele;
	int cpt = 1; // indice d'iteration liste
	boolean gameOver; 
	
	public ModeleListe(Modele modele) {
		this.modele = modele;
		this.listeEtat.add(modele.getEtat());
	}

	public ArrayList<int[][]> getListeEtat() {
		return listeEtat;
	}

	public void addList(int[][] etat) {
    	listeEtat.add(0,etat);
    }
	
	public void reset() {
		modele.reset();
		listeEtat.clear();
	}
	
	public int[][] getEtat() {
		return modele.getEtat();
	}
	
	public void setEtat(int[][] etat) {
		modele.setEtat(etat);
	}
	
	public boolean up() {
		//testTab(this.modele.getEtat().clone());
		addList(this.modele.getEtat());
		boolean up = this.modele.up();
		gameOver(modele.getEtat());
		cleanList();
		return up;
	}
	
	public boolean down() {
		addList(this.modele.getEtat());
		boolean down = this.modele.down();
		gameOver(modele.getEtat());
		cleanList();
		return down;
	}
	
	public boolean right() {
		addList(this.modele.getEtat());
		boolean right = this.modele.right();
		gameOver(modele.getEtat());
		cleanList();
		return right;
	}
	
	public boolean left() {
		addList(this.modele.getEtat());
		boolean left = this.modele.left();
		gameOver(modele.getEtat());
		cleanList();
		return left;
	}
	
	public void cleanList() {
		for(int i = 0; i<this.cpt-1 && this.cpt>1; this.cpt++) {
			listeEtat.remove(i);
		}
		this.cpt=1;
	}
	
	public void gameOver(int[][] etat) {
	    setGameOver(true);
		for (int i = 0; i < etat.length; i++) {
			for (int j = 0; j < etat[i].length; j++) {
				if (etat[i][j] == 3) {
					setGameOver(false);
					break;
				}
			}
		}
//		Iterator it = listeEtat.iterator();
//		while (it.hasNext()) {
//			int[][] tmp = (int[][]) it.next();
//			System.out.println(" ");
//			for (int i = 0; i < tmp.length; i++) {
//				for (int j = 0; j < tmp[i].length; j++) {
//					System.out.print(tmp[i][j] + " / ");
//				}
//				System.out.println(" ");
//			}
//		}
	}

	public void undo() {	
		//testTab(modele.getEtat());
		//testTab(listeEtat.get(cpt));
		testList(listeEtat);
		modele.setEtat(listeEtat.get(cpt).clone());
		++cpt;
		//testTab(modele.getEtat());
	}
	
	public void redo() {
		if(this.cpt>1) {
			modele.setEtat(listeEtat.get(cpt-2));
		}
		--cpt;
	}
	
	public boolean getGameOver(){
		return gameOver;
	}
	public void setGameOver(boolean b){
		gameOver=b;
	}
	
	public void testTab(int[][] tab) {
		for(int i=0; i<tab.length; i++) {
			for(int j=0;j<tab[i].length;j++) {
				System.out.print(tab[i][j] + " / ");
			}
			System.out.println();
		}
		System.out.println("---------------------");
	}
	
	public void testList(ArrayList<int[][]> l) {
		Iterator<int[][]> it = l.iterator();
		int cpt = 0;
		while(it.hasNext()) {
			System.out.println(cpt + " : ");
			testTab(it.next());
			++cpt;
		}
	}
}


