package model;


import java.util.Dictionary;

public abstract class Piece {
    private int[][]  mouvements= new int[8][8];
    private int x;
    private int y;

    private Couleur color;
    public Piece(Couleur color1)
    {
        color = color1;
    }

    public Couleur getColor() {
        return color;
    }
    public abstract int[][] calculmouvementPossible(Echec echec);
}
