package sample;

import java.util.ArrayList;

public class ModeleListe implements Modele{
	ArrayList<int[][]> listeEtat = new ArrayList<int[][]>();
	Modele modele;
	boolean gameOver;
	
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
	
	public boolean up() {
		addList(this.modele.getEtat().clone());
		boolean up = this.modele.up();
		gameOver(modele.getEtat());
		return up;
	}
	
	public boolean down() {
		addList(this.modele.getEtat().clone());
		boolean down = this.modele.down();
		gameOver(modele.getEtat());
		return down;
	}
	
	public boolean right() {
		addList(this.modele.getEtat().clone());
		boolean right = this.modele.right();
		gameOver(modele.getEtat());
		return right;
	}
	
	public boolean left() {
		addList(this.modele.getEtat().clone());
		boolean left = this.modele.left();
		gameOver(modele.getEtat());
		return left;
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

	public boolean getGameOver(){
		return gameOver;
	}
	public void setGameOver(boolean b){
		gameOver=b;
	}
}


