package sample;

import javafx.util.Pair;

public class ModeleConcret implements Modele {

    public int[][] etat = /*{{1,1,1,1,1,2,2,2,2,1,1},{1,1,1,1,1,2,1,1,2,1,1},{1,1,1,2,2,2,1,3,2,1,1},{1,1,1,2,1,1,1,1,2,1,1},
                           {2,2,2,2,1,2,2,1,2,2,2},{2,1,3,1,3,1,1,3,1,1,2},{2,1,1,1,1,2,2,1,2,1,2},{2,1,1,3,3,2,2,1,2,1,2},
                           {2,2,2,2,1,1,1,1,2,1,2},{1,1,1,2,2,2,2,1,1,1,2},{1,1,1,1,1,1,2,1,2,2,2},{1,1,1,1,1,1,2,1,2,2,2},
                           {1,1,1,1,1,1,2,1,0,2,1},{1,1,1,1,1,1,2,1,2,2,1},{1,1,1,1,1,2,2,1,2,2,1},{1,1,1,1,1,2,1,1,1,2,1},
                           {1,1,1,1,1,2,1,1,1,2,1},{1,1,1,1,1,2,4,4,4,2,1},{1,1,1,1,1,2,4,4,4,2,1},{1,1,1,1,1,2,2,2,2,2,1}};*/
            {{2,2,2,2,2},{2,1,1,1,2},{2,1,0,1,2},{2,1,3,1,2},{2,1,4,1,2},{2,2,2,2,2}};

    public int[][] getEtat(){
    	return cloneTab(etat);
    }
    
    public int[][] cloneTab(int[][] etatBis){
    	int[][] tmp = new int[etat.length][etat[0].length];
    	for(int i=0; i < etatBis.length; ++i) {
    		for(int j=0; j < etatBis[i].length; j++) {
        		tmp[i][j] = etat[i][j];
    		}
    	}
    	return tmp;
    }
    
    public void setEtat(int[][] etat) {
		this.etat = etat;
	}

	//Retourne la position de soko dans le tableau etat sous la forme <x,y> (x = colonne, y = y = ligne)
    public Pair<Integer, Integer> positionSoko(){
        for(int i=0; i<etat.length; i++){
            for(int j=0; j<etat[i].length; j++) {
                if (etat[i][j] == 0 || etat[i][j] == 6) {
                    return new Pair(i,j);
                }
            }
        }
        return null;
    }

    //Déplace Soko d'une case à droite en changeant les données du tableau etat
    public boolean right() {
        Pair<Integer,Integer> pos = positionSoko();
        if (pos!=null) {
            int x = pos.getKey(); int y = pos.getValue();
            if (x<(etat.length)){
                if (etat[x][y]==0){
//              Si la case à droite est vide (sol)
                    if (etat[x+1][y]==1) {
                        etat[x][y] = 1; etat[x + 1][y] = 0;
                        return false;
                    }
//              Si la case à droite est un point
                    if (etat[x+1][y]==4) {
                        etat[x][y] = 1; etat[x + 1][y] = 6;
                        return false;
                    }
//              Si la case à droite est une caisse et la case à droite+2 est vide (sol)
                    if (etat[x+1][y]==3 && etat[x+2][y]==1) {
                        etat[x][y] = 1;etat[x+1][y]=0;etat[x+2][y]=3;
                        return true;
                    }
//              Si la case à droite est une caisse et la case à droite+2 est un point
                    if (etat[x+1][y]==3 && etat[x+2][y]==4) {
                        etat[x][y] = 1;etat[x+1][y]=0;etat[x+2][y]=5;
                        return true;
                    }
//              Si la case à droite est une caisse+point et la case à droite+2 est un point
                    if (etat[x+1][y]==5 && etat[x+2][y]==4) {
                        etat[x][y]=1;etat[x+1][y]=6;etat[x+2][y]=5;
                        return true;
                    }
//              Si la case à droite est une caisse+point et la case à droite+2 est vide (sol)
                    if (etat[x+1][y]==5 && etat[x+2][y]==1) {
                        etat[x][y]=1;etat[x+1][y]=6;etat[x+2][y]=3;
                        return true;
                    }
                }
                if (etat[x][y]==6){
//              Si la case à droite est vide (sol)
                    if (etat[x+1][y]==1) {
                        etat[x][y] = 4; etat[x + 1][y] = 0;
                        return false;
                    }
//              Si la case à droite est un point
                    if (etat[x+1][y]==4) {
                        etat[x][y] = 4; etat[x + 1][y] = 6;
                        return false;
                    }
//              Si la case à droite est une caisse et la case à droite+2 est vide (sol)
                    if (etat[x+1][y]==3 && etat[x+2][y]==1) {
                        etat[x][y] = 4;etat[x+1][y]=0;etat[x+2][y]=3;
                        return true;
                    }
//              Si la case à droite est une caisse et la case à droite+2 est un point
                    if (etat[x+1][y]==3 && etat[x+2][y]==4) {
                        etat[x][y] = 4;etat[x+1][y]=0;etat[x+2][y]=5;
                        return true;
                    }
//              Si la case à droite est une caisse+point et la case à droite+2 est un point
                    if (etat[x+1][y]==5 && etat[x+2][y]==4) {
                        etat[x][y] = 4;etat[x+1][y]=6;etat[x+2][y]=5;
                        return true;
                    }
//              Si la case à droite est une caisse+point et la case à droite+2 est vide (sol)
                    if (etat[x+1][y]==5 && etat[x+2][y]==1) {
                        etat[x][y] = 4;etat[x+1][y]=6;etat[x+2][y]=3;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    //Déplace Soko d'une case à gauche en changeant les données du tableau etat
    public boolean left() {
        Pair<Integer,Integer> pos = positionSoko();
        if (pos!=null) {
            int x = pos.getKey(); int y = pos.getValue();
            if (0<x){
                if (etat[x][y]==0){
//              Si la case à gauche est vide (sol)
                    if (etat[x-1][y] == 1) {
                        etat[x][y]=1; etat[x-1][y]=0;
                        return false;
                    }
//              Si la case à gauche est un point
                    if (etat[x-1][y] == 4) {
                        etat[x][y]=1; etat[x-1][y]=6;
                        return false;
                    }
//              Si la case à gauche est une caisse et la case à gauche+2 est vide (sol)
                    if (etat[x-1][y]==3 && etat[x-2][y]==1) {
                        etat[x][y] = 1;etat[x-1][y]=0;etat[x-2][y]=3;
                        return true;
                    }
//              Si la case à gauche est une caisse et la case à gauche+2 est un point
                    if (etat[x-1][y]==3 && etat[x-2][y]==4) {
                        etat[x][y] = 1;etat[x-1][y]=0;etat[x-2][y]=5;
                        return true;
                    }
//              Si la case à gauche est une caisse+point et la case à gauche+2 est un point
                    if (etat[x-1][y]==5 && etat[x-2][y]==4) {
                        etat[x][y] = 1;etat[x-1][y]=6;etat[x-2][y]=5;
                        return true;
                    }
//              Si la case à gauche est une caisse+point et la case à gauche+2 est vide (sol)
                    if (etat[x-1][y]==5 && etat[x-2][y]==1) {
                        etat[x][y] = 1;etat[x-1][y]=6;etat[x-2][y]=3;
                        return true;
                    }
                }
                if (etat[x][y]==6){
//              Si la case à gauche est vide (sol)
                    if (etat[x-1][y] == 1) {
                        etat[x][y]=4; etat[x-1][y]=0;
                        return false;
                    }
//              Si la case à gauche est un point
                    if (etat[x-1][y] == 4) {
                        etat[x][y]=4; etat[x-1][y]=6;
                        return false;
                    }
//              Si la case à gauche est une caisse et la case à gauche+2 est vide (sol)
                    if (etat[x-1][y]==3 && etat[x-2][y]==1) {
                        etat[x][y] = 4;etat[x-1][y]=0;etat[x-2][y]=3;
                        return true;
                    }
//              Si la case à gauche est une caisse et la case à gauche+2 est un point
                    if (etat[x-1][y]==3 && etat[x-2][y]==4) {
                        etat[x][y] = 4;etat[x-1][y]=0;etat[x-2][y]=5;
                        return true;
                    }
//              Si la case à gauche est une caisse+point et la case à gauche+2 est un point
                    if (etat[x-1][y]==5 && etat[x-2][y]==4) {
                        etat[x][y] = 4;etat[x-1][y]=6;etat[x-2][y]=5;
                        return true;
                    }
//              Si la case à gauche est une caisse+point et la case à gauche+2 est vide (sol)
                    if (etat[x-1][y]==5 && etat[x-2][y]==1) {
                        etat[x][y] = 4;etat[x-1][y]=6;etat[x-2][y]=3;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    //Déplace Soko d'une case en haut en changeant les données du tableau etat
    public boolean up() {
        Pair<Integer,Integer> pos = positionSoko();
        if (pos!=null) {
            int x = pos.getKey(); int y = pos.getValue();
            if (x!=0){
                if (etat[x][y]==0){
//              Si la case en haut est vide (sol)
                    if (etat[x][y-1]==1) {
                        etat[x][y]=1; etat[x][y-1]=0;
                        return false;
                    }
//              Si la case en haut est un point
                    if (etat[x][y-1]==4) {
                        etat[x][y]=1; etat[x][y-1]=6;
                        return false;
                    }
//              Si la case en haut est une caisse et la case en haut+2 est vide (sol)
                    if (etat[x][y-1]==3 && etat[x][y-2]==1) {
                        etat[x][y]=1;etat[x][y-1]=0;etat[x][y-2]=3;
                        return true;
                    }
//              Si la case en haut est une caisse et la case en haut+2 est un point
                    if (etat[x][y-1]==3 && etat[x][y-2]==4) {
                        etat[x][y]=1;etat[x][y-1]=0;etat[x][y-2]=5;
                        return true;
                    }
//              Si la case en haut est une caisse+point et la case en haut+2 est un point
                    if (etat[x][y-1]==5 && etat[x][y-2]==4) {
                        etat[x][y]=1;etat[x][y-1]=6;etat[x][y-2]=5;
                        return true;
                    }
//              Si la case en haut est une caisse+point et la case en haut+2 est vide (sol)
                    if (etat[x][y-1]==5 && etat[x][y-2]==1) {
                        etat[x][y] = 1;etat[x][y-1]=6;etat[x][y-2]=3;
                        return true;
                    }
                }
                if (etat[x][y]==6){
//              Si la case en haut est vide (sol)
                    if (etat[x][y-1]==1) {
                        etat[x][y]=4; etat[x][y-1]=0;
                        return false;
                    }
//              Si la case en haut est un point
                    if (etat[x][y-1]==4) {
                        etat[x][y]=4; etat[x][y-1]=6;
                        return false;
                    }
//              Si la case en haut est une caisse et la case en haut+2 est vide (sol)
                    if (etat[x][y-1]==3 && etat[x][y-2]==1) {
                        etat[x][y]=4;etat[x][y-1]=0;etat[x][y-2]=3;
                        return true;
                    }
//              Si la case en haut est une caisse et la case en haut+2 est un point
                    if (etat[x][y-1]==3 && etat[x][y-2]==4) {
                        etat[x][y]=4;etat[x][y-1]=0;etat[x][y-2]=5;
                        return true;
                    }
//              Si la case en haut est une caisse+point et la case en haut+2 est un point
                    if (etat[x][y-1]==5 && etat[x][y-2]==4) {
                        etat[x][y]=4;etat[x][y-1]=6;etat[x][y-2]=5;
                        return true;
                    }
//              Si la case en haut est une caisse+point et la case en haut+2 est vide (sol)
                    if (etat[x][y-1]==5 && etat[x][y-2]==1) {
                        etat[x][y]=4;etat[x][y-1]=6;etat[x][y-2]=3;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    //Déplace Soko d'une case en bas en changeant les données du tableau etat
    public boolean down() {
        Pair<Integer,Integer> pos = positionSoko();
        if (pos!=null) {
            int x = pos.getKey(); int y = pos.getValue();
            if (y<etat[0].length){
                if (etat[x][y]==0){
//              Si la case en bas est vide (sol)
                    if (etat[x][y+1]==1) {
                        etat[x][y]=1; etat[x][y+1]=0;
                        return false;
                    }
//              Si la case en bas est un point
                    if (etat[x][y+1]==4) {
                        etat[x][y]=1; etat[x][y+1]=6;
                        return false;
                    }
//              Si la case en bas est une caisse et la case en bas+2 est vide (sol)
                    if (etat[x][y+1]==3 && etat[x][y+2]==1) {
                        etat[x][y]=1;etat[x][y+1]=0;etat[x][y+2]=3;
                        return true;
                    }
//              Si la case en bas est une caisse et la case en bas+2 est un point
                    if (etat[x][y+1]==3 && etat[x][y+2]==4) {
                        etat[x][y]=1;etat[x][y+1]=0;etat[x][y+2]=5;
                        return true;
                    }
//              Si la case en bas est une caisse+point et la case en bas+2 est un point
                    if (etat[x][y+1]==5 && etat[x][y+2]==4) {
                        etat[x][y]=1;etat[x][y+1]=6;etat[x][y+2]=5;
                        return true;
                    }
//              Si la case en bas est une caisse+point et la case en bas+2 est vide (sol)
                    if (etat[x][y+1]==5 && etat[x][y+2]==1) {
                        etat[x][y]=1;etat[x][y+1]=6;etat[x][y+2]=3;
                        return true;
                    }
                }
                if (etat[x][y]==6){
//              Si la case en bas est vide (sol)
                    if (etat[x][y+1]==1) {
                        etat[x][y]=4; etat[x][y+1]=0;
                        return false;
                    }
//              Si la case en bas est un point
                    if (etat[x][y+1]==4) {
                        etat[x][y]=4; etat[x][y+1]=6;
                        return false;
                    }
//              Si la case en bas est une caisse et la case en bas+2 est vide (sol)
                    if (etat[x][y+1]==3 && etat[x][y+2]==1) {
                        etat[x][y]=4;etat[x][y+1]=0;etat[x][y+2]=3;
                        return true;
                    }
//              Si la case en bas est une caisse et la case en bas+2 est un point
                    if (etat[x][y+1]==3 && etat[x][y+2]==4) {
                        etat[x][y]=4;etat[x][y+1]=0;etat[x][y+2]=5;
                        return true;
                    }
//              Si la case en bas est une caisse+point et la case en bas+2 est un point
                    if (etat[x][y+1]==5 && etat[x][y+2]==4) {
                        etat[x][y]=4;etat[x][y+1]=6;etat[x][y+2]=5;
                        return true;
                    }
//              Si la case en bas est une caisse+point et la case en bas+2 est vide (sol)
                    if (etat[x][y+1]==5 && etat[x][y+2]==1) {
                        etat[x][y]=4;etat[x][y+1]=6;etat[x][y+2]=3;
                        return true;
                    }
                }
            }
        }
        return false;
    }


    
    @Override
    public void reset() {
        etat =  new int[][] /*{{1,1,1,1,1,2,2,2,2,1,1},{1,1,1,1,1,2,1,1,2,1,1},{1,1,1,2,2,2,1,3,2,1,1},{1,1,1,2,1,1,1,1,2,1,1},
                             {2,2,2,2,1,2,2,1,2,2,2},{2,1,3,1,3,1,1,3,1,1,2},{2,1,1,1,1,2,2,1,2,1,2},{2,1,1,3,3,2,2,1,2,1,2},
                             {2,2,2,2,1,1,1,1,2,1,2},{1,1,1,2,2,2,2,1,1,1,2},{1,1,1,1,1,1,2,1,2,2,2},{1,1,1,1,1,1,2,1,2,2,2},
                             {1,1,1,1,1,1,2,1,0,2,1},{1,1,1,1,1,1,2,1,2,2,1},{1,1,1,1,1,2,2,1,2,2,1},{1,1,1,1,1,2,1,1,1,2,1},
                             {1,1,1,1,1,2,1,1,1,2,1},{1,1,1,1,1,2,4,4,4,2,1},{1,1,1,1,1,2,4,4,4,2,1},{1,1,1,1,1,2,2,2,2,2,1}};*/
                {{2,2,2,2,2},{2,1,1,1,2},{2,1,0,1,2},{2,1,3,1,2},{2,1,4,1,2},{2,2,2,2,2}};
    }

}
