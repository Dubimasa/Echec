package model;


public abstract class Piece {
    private int[][]  mouvements= new int[8][8];

    private Couleur color;
    public Piece(Couleur color1)
    {
        color = color1;
    }

    public Couleur getColor() {
        return color;
    }
    public abstract int[][] CalculmouvementPossible(Echec echec);
}
