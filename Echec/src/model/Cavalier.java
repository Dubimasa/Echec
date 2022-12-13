package model;
import java.util.HashMap;
import java.util.Map;
public class Cavalier extends Piece {;
    public Cavalier(Couleur couleur1)
    {
        super(couleur1);

    }

    //Méthode initialisant tous les mouvements possibles
    public Map<Integer, int[]> calculmouvementPossible(Echec echec){
        Map<Integer, int[]> mouvements = new HashMap<Integer, int[]>();

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

        Source: https://prograide.com/pregunta/26098/comment-creer-un-dictionnaire-en-java

        return mouvements;
    }
}
