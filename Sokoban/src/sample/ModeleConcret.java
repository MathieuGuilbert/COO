package sample;

import javafx.util.Pair;

public class ModeleConcret implements Modele {
    public int[][] etat = {{1,1,1},{1,0,1},{1,1,1}};

    public int[][] getEtat() {return etat; }

    //Retourne la position de soko dans le tableau etat sous la forme <x,y> (x = colonne, y = y = ligne)
    public Pair<Integer, Integer> positionSoko(){
        for(int i=0; i<etat.length; i++){
            for(int j=0; j<etat[i].length; j++) {
                if (etat[i][j] == 0) {
                    return new Pair(i,j);
                }
            }
        }
        return null;
    }

    //Prend la position de soko (x = colonne, y = y = ligne) et le déplace d'une case à droite en changeant les données du tableau etat
    public void right() {
        Pair<Integer,Integer> pos = positionSoko();
        if (pos!=null) {
            int x = pos.getKey(); int y = pos.getValue();
            if (x<(etat.length) && etat[x+1][y]==1) {
                etat[x][y] = 1; etat[x + 1][y] = 0;
            }
        }
    }
    //Prend la position de soko (x = colonne, y = y = ligne) et le déplace d'une case à gauche en changeant les données du tableau etat
    public void left() {
        Pair<Integer,Integer> pos = positionSoko();
        if (pos!=null) {
            int x = pos.getKey(); int y = pos.getValue();
            if (0<x && etat[x-1][y] == 1){
                etat[x][y]=1; etat[x-1][y]=0;
            }
        }
    }
    //Prend la position de soko (x = colonne, y = y = ligne) et le déplace d'une case en haut en changeant les données du tableau etat
    public void up() {
        Pair<Integer,Integer> pos = positionSoko();
        if (pos!=null) {
            int x = pos.getKey(); int y = pos.getValue();
            if (x!=0 && etat[x][y-1]==1) {
                etat[x][y] = 1; etat[x][y - 1] = 0;
            }
        }
    }
    //Prend la position de soko (x = colonne, y = y = ligne) et le déplace d'une case en bas en changeant les données du tableau etat
    public void down() {
        Pair<Integer,Integer> pos = positionSoko();
        if (pos!=null) {
            int x = pos.getKey(); int y = pos.getValue();
            if (y<etat[0].length && etat[x][y+1]==1){
                etat[x][y]=1; etat[x][y+1]=0;
            }
        }
    }

    @Override
    public void reset() {
        etat =  new int[][]  {{1,1,1},{1,0,1},{1,1,1}};
    }

}
