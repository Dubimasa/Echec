package model;

public class Roi extends Piece{
    public Roi(Couleur couleur1)
    {
        super(couleur1);
    }

    //Méthode initialisant tous les mouvements possibles
    public int[][] calculmouvementPossible(Echec echec){
        int[][]  mouvements= new int[8][8];
        mouvements[0][0]=1;

        return mouvements;
    }
}
