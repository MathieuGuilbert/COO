package sample;

public interface Modele {
    public int[][] getEtat();
    public void setEtat(int[][] etat);
    public boolean right();
    public boolean left();
    public boolean up();
    public boolean down();
    public void reset();
}
