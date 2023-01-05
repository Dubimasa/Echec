package model;

import java.util.HashMap;
import java.util.Map;

public class Tour extends Piece{

    public Tour(Couleur couleur1)
    {
        super(couleur1);
        score = 3;
    }

    //Méthode initialisant tous les mouvements possibles
    public Map<Integer, int[]> calculmouvementPossible(Piece[][] echequier){
        Map<Integer, int[]> mouvements = new HashMap<Integer, int[]>();

        int compteur=0;
        boolean xpositif = true;
        boolean xnegatif = true;
        boolean ypositif = true;
        boolean ynegatif = true;

        for(int i=1; i<7; i++){
            if(xpositif && searchPieceDifferentColorOrNull(echequier,x+i,y))
            {
                int[] moove1 = {i, 0};
                mouvements.put(compteur, moove1);
                compteur++;
                if(searchPieceDifferentColorNotNull(echequier,x+i, y))
                {
                    xpositif = false;
                }
            }
            else
            {
                xpositif = false;
            }
            if(xnegatif && searchPieceDifferentColorOrNull(echequier,x-i, y))
            {
                int[] moove2 = {-i, 0};
                mouvements.put(compteur, moove2);
                compteur++;
                if(searchPieceDifferentColorNotNull(echequier,x-i, y))
                {
                    xnegatif = false;
                }
            }
            else
            {
                xnegatif = false;
            }
            if(ypositif && searchPieceDifferentColorOrNull(echequier,x, y+i))
            {
                int[] moove3 = {0, i};
                mouvements.put(compteur, moove3);
                compteur++;
                if(searchPieceDifferentColorNotNull(echequier,x, y+i))
                {
                    ypositif = false;
                }
            }
            else
            {
                ypositif = false;
            }
            if(ynegatif && searchPieceDifferentColorOrNull(echequier,x, y-i))
            {
                int[] moove4 = {0, -i};
                mouvements.put(compteur, moove4);
                compteur++;
                if(searchPieceDifferentColorNotNull(echequier,x, y-i))
                    {
                        ynegatif = false;
                    }
            }
            else
            {
                ynegatif = false;
            }
        }

        return mouvements;
    }
}
