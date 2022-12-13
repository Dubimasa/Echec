package model;

public class Pion extends Piece {
    private boolean tour1; //Boolean qui vérifie si c'est le tour 1 ou non

    public Pion(Couleur color1)
    {
        super(color1);
    }

    //Méthode initialisant tous les mouvements possibles
    public Map< class="hljs-built_in">int, int[]> calculmouvementPossible(Echec echec){
        Map< class="hljs-built_in">int, int[]> mouvements = new HashMap<int, int[]>();

        int[] moove1 = {0, 1};
        mouvements.put(0, moove1);

        if (this.tour1){
            int[] moove2 = {0, 2};
            mouvements.put(1, moove2);
        }

        //Vérifie si ennemi dans le coin au dessus à droite du pion puis le coin gauche
        if(true){
            int moove3 = {1, 1};
            mouvements.put(2, moove3);
        }
        if (true){
            int moove3 = {1, 1};
            mouvements.put(2, moove3);
            mouvements[-1][1]=4;
        }

        return mouvements;
    }


}
