package model;

public class Piece {
    private int[][]  mouvements= new int[8][8];

    static Color color;
    public Piece(Color color1)
    {
        color = color1;
    }

}
