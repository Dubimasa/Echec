package model;

public class Cavalier extends Piece {;
    public Cavalier(Couleur couleur1)
    {
        super(couleur1);

    }

    //Méthode initialisant tous les mouvements possibles
    public Map< class="hljs-built_in">int, int[]> calculmouvementPossible(Echec echec){
        Map< class="hljs-built_in">int, int[]> mouvements = new HashMap<int, int[]>();

        int[] moove1 = {2, 1};
        mouvements.put(0, moove1);

        int[] moove2 = {2, -1};
        mouvements.put(1, moove2);

        int[] moove3 = {1, 2};
        mouvements.put(2, moove3);

        int[] moove4 = {1, -2};
        mouvements.put(3, moove4);

        int[] moove5 = {-2, 1};
        mouvements.put(4, moove5);

        int[] moove6 = {-2, -1};
        mouvements.put(5, moove6);

        int[] moove7 = {-1, 2};
        mouvements.put(6, moove7);

        int[] moove8 = {-1, -2};
        mouvements.put(7, moove8);

        return mouvements;
    }
}
