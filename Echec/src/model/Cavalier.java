package model;

public class Cavalier extends Piece {;
    public Cavalier(Color color1)
    {
        super(color1);

    }

    //Méthode initialisant tous les mouvements possibles
    public int[][] CalculmouvementPossibl(Echec echec){
        int[][]  mouvements= new int[8][8];
        mouvements[0][0]=1;

        return mouvements;
    }
}
