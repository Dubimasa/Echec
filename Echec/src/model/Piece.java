package model;


public class Piece {
    private int[][]  mouvements= new int[8][8];

    static Couleur color;
    public Piece(Couleur color1)
    {
        color = color1;
    }

    public static Couleur getColor() {
        return color;
    }
}
