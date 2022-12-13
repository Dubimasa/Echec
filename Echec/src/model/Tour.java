package model;

import java.util.HashMap;
import java.util.Map;

public class Tour extends Piece{

    public Tour(Couleur couleur1)
    {
        super(couleur1);
    }

    //Méthode initialisant tous les mouvements possibles
    public Map<Integer, int[]> calculmouvementPossible(Echec echec){
        Map<Integer, int[]> mouvements = new HashMap<Integer, int[]>();

        int compteur=0;
        for(int i=1; i<7; i++){
            int[] moove1 = {i, 0};
            mouvements.put(compteur, moove1);
            compteur++;

            int[] moove2 = {-i, 0};
            mouvements.put(compteur, moove2);
            compteur++;

            int[] moove3 = {0, i};
            mouvements.put(compteur, moove3);
            compteur++;

            int[] moove4 = {0, -i};
            mouvements.put(compteur, moove4);
            compteur++;
        }

        return mouvements;
    }
}
