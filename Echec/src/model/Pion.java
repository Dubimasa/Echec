package model;

public class Pion extends Piece {
    private boolean tour1; //Boolean qui vérifie si c'est le tour 1 ou non

    public Pion(Color color1)
    {
        super(color1);
    }

    //Méthode initialisant tous les mouvements possibles
    public int[][] CalculmouvementPossibl(Echec echec){
        int[][]  mouvements= new int[8][8];
        mouvements[0][0]=1;

        if (this.tour1){
            mouvements[0][1]=2;
        }
        return mouvements;
    }


}
