package sample;

import javafx.util.Pair;

public class ModeleConcret implements Modele {
    public int[][] etat = {{1,1,1},{1,0,1},{1,1,1}};

    public int[][] getEtat() {
        return etat;
    }

    //Retourne la position de soko dans le tableau etat sous la forme <x,y> (x = colonne, y = y = ligne)
    public Pair<Integer, Integer> positionSoko(){
        Pair<Integer, Integer> a = new Pair(0,0);
        for(int i=0; i<etat.length-1; i++){
            for(int j=0; j<etat[i].length-1; j++) {
                if (etat[i][j] == 0) {
                    a = new Pair(i,j);
                }
            }
        }
        return a;
    }

    //Prend en param la position de soko (x = colonne, y = y = ligne) et le déplace d'une case à droite en changeant les données du tableau etat
    public void right(int x, int y) {
        if (x<(etat.length) && etat[x+1][y]==1) {
            etat[x][y] = 1; etat[x + 1][y] = 0;
        }
    }
    //Prend en param la position de soko (x = colonne, y = y = ligne) et le déplace d'une case à gauche en changeant les données du tableau etat
    public void left(int x, int y) {
        if (0<x && etat[x-1][y] == 1){
            etat[x][y]=1; etat[x-1][y]=0;
        }
    }
    //Prend en param la position de soko (x = colonne, y = y = ligne) et le déplace d'une case en haut en changeant les données du tableau etat
    public void up(int x, int y) {
        if (x!=0 && etat[x][y-1]==1){
            etat[x][y]=1; etat[x][y-1]=0;
        }
    }
    //Prend en param la position de soko (x = colonne, y = y = ligne) et le déplace d'une case en bas en changeant les données du tableau etat
    public void down(int x, int y) {
        if (y<etat[0].length && etat[x][y+1]==1){
            etat[x][y]=1; etat[x][y+1]=0;
        }
    }

    @Override
    public void reset() {
        etat =  new int[][]  {{1,1,1},{1,0,1},{1,1,1}};
    }

}
