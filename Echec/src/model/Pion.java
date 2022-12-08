package model;

public class Pion extends Piece {
    private boolean tour1; //Boolean qui vérifie si c'est le tour 1 ou non

    public Pion(Couleur color1)
    {
        super(color1);
    }

    //Méthode initialisant tous les mouvements possibles
    public int[][] CalculmouvementPossible(Echec echec){
        int[][]  mouvements= new int[8][8];
        mouvements[0][1]=1;

        if (this.tour1){
            mouvements[0][2]=2;
        }

        //Vérifie si ennemi dans le coin au dessus à droite du piont puis le coin gauche
        if(){
            mouvements[1][1]=3;
        }
        if (){
            mouvements[-1][1]=4;
        }

        return mouvements;
    }


}
