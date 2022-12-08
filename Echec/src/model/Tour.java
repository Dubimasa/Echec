package model;

public class Tour extends Piece{

    public Tour(Couleur couleur1)
    {
        super(couleur1);
    }

    //Méthode initialisant tous les mouvements possibles
    public int[][] calculmouvementPossible(Echec echec){
        int[][]  mouvements= new int[8][8];
        for(int i=1; i<7; i++){
            mouvements[i][0]=1;
            mouvements[0][i]=1;
            mouvements[-i][0]=1;
            mouvements[0][-i]=1;
        }

        return mouvements;
    }
}
