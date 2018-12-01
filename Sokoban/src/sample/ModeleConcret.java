package sample;

import javafx.util.Pair;

public class ModeleConcret implements Modele {
    public int[][] etat = {{1,1,1},{1,0,1},{1,1,1}};

    public int[][] getEtat() {
        return etat;
    }

    public Pair<Integer, Integer> positionSoko(int[][] tab){
        Pair<Integer, Integer> a = new Pair(0,0);
        for(int i=0; i<tab.length-1; i++){
            for(int j=0; j<tab[i].length-1; j++) {
                if (tab[i][j] == 0) {
                    a = new Pair(i,j);
                }
            }
        }
        return a;
    }

    public void right(int[][] etat, int x, int y) {
        if (x<(etat.length) && etat[x+1][y]==1) {
            etat[x][y] = 1; etat[x + 1][y] = 0;
        }
    }
    public void left(int[][] etat, int x, int y) {
        if (0<x && etat[x-1][y] == 1){
            etat[x][y]=1; etat[x-1][y]=0;
        }
    }
    public void up(int[][] etat, int x, int y) {
        if (x!=0 && etat[x][y-1]==1){
            etat[x][y]=1; etat[x][y-1]=0;
        }
    }
    public void down(int[][] etat, int x, int y) {
        if (y<etat[0].length && etat[x][y+1]==1){
            etat[x][y]=1; etat[x][y+1]=0;
        }
    }

    @Override
    public void reset() {
        etat =  new int[][]  {{1,1,1},{1,0,1},{1,1,1}};
    }

}
