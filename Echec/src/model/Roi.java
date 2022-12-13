package model;

import java.util.HashMap;
import java.util.Map;

public class Roi extends Piece{
    public Roi(Couleur couleur1)
    {
        super(couleur1);
    }

    //Méthode initialisant tous les mouvements possibles
    public Map<Integer, int[]> calculmouvementPossible(Echec echec){
        Map<Integer, int[]> mouvements = new HashMap<Integer, int[]>();
        int compteur = 0;
        int[] moove1 = {1, 0};
        mouvements.put(compteur, moove1);
        compteur++;

        int[] moove2 = {-1, 0};
        mouvements.put(compteur, moove2);
        compteur++;

        int[] moove3 = {1, 1};
        mouvements.put(compteur, moove3);
        compteur++;

        int[] moove4 = {1, -1};
        mouvements.put(compteur, moove4);
        compteur++;

        int[] moove5 = {0, -1};
        mouvements.put(compteur, moove5);
        compteur++;

        int[] moove6 = {0, 1};
        mouvements.put(compteur, moove6);
        compteur++;

        int[] moove7 = {-1, 1};
        mouvements.put(compteur, moove7);
        compteur++;

        int[] moove8 = {-1, -1};
        mouvements.put(compteur, moove8);
        compteur++;

        return mouvements;
    }
}
