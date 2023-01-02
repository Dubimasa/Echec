package model;

import java.util.HashMap;
import java.util.Map;

public class Fou extends Piece{
    public Fou(Couleur couleur1,Echec echec1)
    {
        super(couleur1,echec1);
    }

    //Méthode initialisant tous les mouvements possibles
    public Map<Integer, int[]> calculmouvementPossible(){
        Map<Integer, int[]> mouvements = new HashMap<Integer, int[]>();

        int compteur=0;
        for(int i=1; i<7; i++){
            int[] moove1 = {i, i};
            mouvements.put(compteur, moove1);
            compteur++;

            int[] moove2 = {i, -i};
            mouvements.put(compteur, moove2);
            compteur++;

            int[] moove3 = {-i, i};
            mouvements.put(compteur, moove3);
            compteur++;

            int[] moove4 = {-i, -i};
            mouvements.put(compteur, moove4);
            compteur++;
        }

        return mouvements;
    }
}
