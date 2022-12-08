package model;


public abstract class Piece {
    private int[][]  mouvements= new int[8][8];
    private int x;
    private int y;

    static Couleur color;
    public Piece(Couleur color1)
    {
        color = color1;
    }

    public static Couleur getColor() {
        return color;
    }
    public abstract int[][] CalculmouvementPossible(Echec echec);
}
