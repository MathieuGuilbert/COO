package sample;

import javafx.util.Pair;

public class ModeleConcret implements Modele {
    public int[][] etat = {{2,2,2,2,2},{2,1,1,1,2},{2,1,0,1,2},{2,1,3,1,2},{2,1,1,1,2},{2,2,2,2,2}};

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
            if (x<(etat.length)){
                if (etat[x+1][y]==1) {
                    etat[x][y] = 1; etat[x + 1][y] = 0;
                }
                if (etat[x+1][y]==3 && etat[x+2][y]==1) {
                    etat[x][y] = 1;etat[x+1][y]=0;etat[x+2][y]=3;
                }
                if (etat[x+1][y]==3 && etat[x+2][y]==4) {
                    etat[x][y] = 1;etat[x+1][y]=0;etat[x+2][y]=5;
                }
            }
        }
    }
    //Prend la position de soko (x = colonne, y = y = ligne) et le déplace d'une case à gauche en changeant les données du tableau etat
    public void left() {
        Pair<Integer,Integer> pos = positionSoko();
        if (pos!=null) {
            int x = pos.getKey(); int y = pos.getValue();
            if (0<x){
                if (etat[x-1][y] == 1) {
                    etat[x][y]=1; etat[x-1][y]=0;
                }
                if (etat[x-1][y]==3 && etat[x-2][y]==1) {
                    etat[x][y] = 1;etat[x-1][y]=0;etat[x-2][y]=3;
                }
                if (etat[x-1][y]==3 && etat[x-2][y]==4) {
                    etat[x][y] = 1;etat[x-1][y]=0;etat[x-2][y]=5;
                }
            }
        }
    }
    //Prend la position de soko (x = colonne, y = y = ligne) et le déplace d'une case en haut en changeant les données du tableau etat
    public void up() {
        Pair<Integer,Integer> pos = positionSoko();
        if (pos!=null) {
            int x = pos.getKey(); int y = pos.getValue();
            if (x!=0){
                if (etat[x][y-1]==1) {
                    etat[x][y]=1; etat[x][y-1]=0;
                }
                if (etat[x][y-1]==3 && etat[x][y-2]==1) {
                    etat[x][y]=1;etat[x][y-1]=0;etat[x][y-2]=3;
                }
                if (etat[x][y-1]==3 && etat[x][y-2]==4) {
                    etat[x][y]=1;etat[x][y-1]=0;etat[x][y-2]=5;
                }
            }
        }
    }
    //Prend la position de soko (x = colonne, y = y = ligne) et le déplace d'une case en bas en changeant les données du tableau etat
    public void down() {
        Pair<Integer,Integer> pos = positionSoko();
        if (pos!=null) {
            int x = pos.getKey(); int y = pos.getValue();
            if (y<etat[0].length){
                if (etat[x][y+1]==1) {
                    etat[x][y]=1; etat[x][y+1]=0;
                }
                if (etat[x][y+1]==3 && etat[x][y+2]==1) {
                    etat[x][y]=1;etat[x][y+1]=0;etat[x][y+2]=3;
                }if (etat[x][y+1]==3 && etat[x][y+2]==4) {
                    etat[x][y]=1;etat[x][y+1]=0;etat[x][y+2]=5;
                }
            }
        }
    }

    @Override
    public void reset() {
        etat =  new int[][] {{2,2,2,2,2},{2,1,1,1,2},{2,1,0,1,2},{2,1,3,1,2},{2,1,1,1,2},{2,2,2,2,2}};
    }

}
