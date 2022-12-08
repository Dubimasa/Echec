package model;

public class Fou extends Piece{
    public Fou(Couleur couleur1)
    {
        super(couleur1);
    }

    //Méthode initialisant tous les mouvements possibles
    public int[][] calculmouvementPossible(Echec echec){
        int[][]  mouvements= new int[8][8];
        for(int i=1; i<7; i++){
            mouvements[i][i]=1;
            mouvements[i][-i]=1;
            mouvements[-i][i]=1;
            mouvements[-i][-i]=1;
        }

        return mouvements;
    }
}
