package model;

public class Cavalier extends Piece {;
    public Cavalier(Couleur couleur1)
    {
        super(couleur1);

    }

    //Méthode initialisant tous les mouvements possibles
    public int[][] calculmouvementPossible(Echec echec){
        int[][]  mouvements= new int[8][8];
        mouvements[2][1]=1;
        mouvements[2][-1]=2;
        mouvements[1][2]=3;
        mouvements[1][-2]=4;
        mouvements[-2][1]=5;
        mouvements[-2][-1]=6;
        mouvements[-1][2]=7;
        mouvements[-1][-2]=8;

        Source: https://prograide.com/pregunta/26098/comment-creer-un-dictionnaire-en-java

        return mouvements;
    }
}
