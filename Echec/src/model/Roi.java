package model;

public class Roi extends Piece{
    public Roi(Couleur couleur1)
    {
        super(couleur1);
    }

    //Méthode initialisant tous les mouvements possibles
    public int[][] calculmouvementPossible(Echec echec){
        int[][]  mouvements= new int[8][8];
        mouvements[1][0]=1;
        mouvements[-1][0]=2;
        mouvements[0][1]=3;
        mouvements[0][-1]=4;
        mouvements[1][1]=5;
        mouvements[1][-1]=6;
        mouvements[-1][1]=7;
        mouvements[-1][-1]=8;

        return mouvements;
    }
}
