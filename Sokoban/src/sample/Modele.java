package sample;

public interface Modele {
    public int[][] getEtat();
    public void right(int[][] etat, int x, int y);
    public void left(int[][] etat, int x, int y);
    public void up(int[][] etat, int x, int y);
    public void down(int[][] etat, int x, int y);
    public void reset();
}
