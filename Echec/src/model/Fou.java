package model;

import java.util.HashMap;
import java.util.Map;

public class Fou extends Piece{
    public Fou(Couleur couleur1)
    {
        super(couleur1);
        score =3;
    }

    //Méthode initialisant tous les mouvements possibles
    public Map<Integer, int[]> calculmouvementPossible(Piece[][] echequier){
        Map<Integer, int[]> mouvements = new HashMap<Integer, int[]>();
        boolean xPositifyPositif = true;
        boolean xPositifyNegatif = true;
        boolean xNegatifyPositif = true;
        boolean xNegatifyNegatif = true;
        

        int compteur=0;
        for(int i=1; i<7; i++){
            if(xPositifyPositif && searchPieceDifferentColorOrNull(echequier,x+i,y+i))
            {
                int[] moove1 = {i, i};
                mouvements.put(compteur, moove1);
                compteur++;
                if(searchPieceDifferentColorNotNull(echequier,x+i, y+i))
                {
                    xPositifyPositif = false;
                }
            }
            else
            {
                xPositifyPositif = false;
            }
            if(xPositifyNegatif && searchPieceDifferentColorOrNull(echequier,x+i,y-i))
            {
                int[] moove2 = {i, -i};
                mouvements.put(compteur, moove2);
                compteur++;
                if(searchPieceDifferentColorNotNull(echequier,x+i, y-i))
                {
                    xPositifyNegatif = false;
                }
            }
            else
            {
                xPositifyNegatif = false;
            }
            if(xNegatifyPositif && searchPieceDifferentColorOrNull(echequier,x-i,y+i))
            {
                int[] moove3 = {-i, i};
                mouvements.put(compteur, moove3);
                compteur++;
                if(searchPieceDifferentColorNotNull(echequier,x-i, y+i))
                {
                    xNegatifyPositif = false;
                }
            }
            else
            {
                xNegatifyPositif = false;
            }
            if(xNegatifyNegatif && searchPieceDifferentColorOrNull(echequier,x-i,y-i))
            {
            int[] moove4 = {-i, -i};
            mouvements.put(compteur, moove4);
            compteur++;
            if(searchPieceDifferentColorNotNull(echequier,x-i, y-i))
            {
                xNegatifyNegatif = false;
            }
            }
            else
            {
                xNegatifyNegatif = false;
            }
        }

        return mouvements;
    }
}
