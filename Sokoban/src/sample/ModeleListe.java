package sample;

import java.util.ArrayList;
import java.util.Iterator;

public class ModeleListe implements Modele{
	ArrayList<int[][]> listeEtat = new ArrayList<int[][]>(); //liste contenant les etats
	Modele modele;
	int cpt = 0; // indice d'iteration liste
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
	
	public void reset() 
	{
		modele.reset();
		this.cpt = 0;
		listeEtat.clear();
	}
	
	public int[][] getEtat() {
		return modele.getEtat();
	}
	
	public void setEtat(int[][] etat) {
		modele.setEtat(etat);
	}
	
	public boolean up() {
		boolean up = this.modele.up();
		cleanList();
		addList(this.modele.getEtat());
		gameOver(modele.getEtat());
		return up;
	}
	
	public boolean down() {
		boolean down = this.modele.down();
		cleanList();
		addList(this.modele.getEtat());
		gameOver(modele.getEtat());
		return down;
	}
	
	public boolean right() {
		boolean right = this.modele.right();
		cleanList();
		addList(this.modele.getEtat());
		gameOver(modele.getEtat());
		return right;
	}
	
	public boolean left() {
		boolean left = this.modele.left();
		cleanList();
		addList(this.modele.getEtat());
		gameOver(modele.getEtat());
		return left;
	}
	
	public void cleanList() {
		while ( cpt!=0 ) 
		{
			listeEtat.remove(cpt-1);
			--cpt;
		}
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
		if ( cpt+1 < listeEtat.size() )
		{
			testList(listeEtat);
			modele.setEtat(listeEtat.get(cpt+1));
			++cpt;
		}
	}
	
	public void redo() {
		if(cpt!=0) {
			testList(listeEtat);
			modele.setEtat(listeEtat.get(cpt-1));
			--cpt;
		}
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


