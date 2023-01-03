package model;

import java.util.HashMap;
import java.util.Map;

public class Dame extends Piece {
    public Dame(Couleur couleur1,Echec echec1)
    {
        super(couleur1,echec1);
    }

    //Méthode initialisant tous les mouvements possibles
    public Map<Integer, int[]> calculmouvementPossible(){
        Map<Integer, int[]> mouvements = new HashMap<Integer, int[]>();

        boolean xpositif = true;
        boolean xnegatif = true;
        boolean ypositif = true;
        boolean ynegatif = true;
        boolean xPositifyPositif = true;
        boolean xPositifyNegatif = true;
        boolean xNegatifyPositif = true;
        boolean xNegatifyNegatif = true;

        int compteur=0;
        for(int i=1; i<7; i++){
            if(xpositif && searchPieceDifferentColorOrNull(x+i,y))
            {
                int[] moove1 = {i, 0};
                mouvements.put(compteur, moove1);
                compteur++;
                if(searchPieceDifferentColorNotNull(x+i, y))
                {
                    xpositif = false;
                }
            }
            else
            {
                xpositif = false;
            }
            if(xnegatif && searchPieceDifferentColorOrNull(x-i, y))
            {
                int[] moove2 = {-i, 0};
                mouvements.put(compteur, moove2);
                compteur++;
                if(searchPieceDifferentColorNotNull(x-i, y))
                {
                    xnegatif = false;
                }
            }
            else
            {
                xnegatif = false;
            }
            if(ypositif && searchPieceDifferentColorOrNull(x, y+i))
            {
                int[] moove3 = {0, i};
                mouvements.put(compteur, moove3);
                compteur++;
                if(searchPieceDifferentColorNotNull(x, y+i))
                {
                    ypositif = false;
                }
            }
            else
            {
                ypositif = false;
            }
            if(ynegatif && searchPieceDifferentColorOrNull(x, y-i))
            {
                int[] moove4 = {0, -i};
                mouvements.put(compteur, moove4);
                compteur++;
                if(searchPieceDifferentColorNotNull(x, y-i))
                    {
                        ynegatif = false;
                    }
            }
            else
            {
                ynegatif = false;
            }
            if(xPositifyPositif && searchPieceDifferentColorOrNull(x+i,y+i))
            {
                int[] moove1 = {i, i};
                mouvements.put(compteur, moove1);
                compteur++;
                if(searchPieceDifferentColorNotNull(x+i, y+i))
                {
                    xPositifyPositif = false;
                }
            }
            else
            {
                xPositifyPositif = false;
            }
            if(xPositifyNegatif && searchPieceDifferentColorOrNull(x+i,y-i))
            {
                int[] moove2 = {i, -i};
                mouvements.put(compteur, moove2);
                compteur++;
                if(searchPieceDifferentColorNotNull(x+i, y-i))
                {
                    xPositifyNegatif = false;
                }
            }
            else
            {
                xPositifyNegatif = false;
            }
            if(xNegatifyPositif && searchPieceDifferentColorOrNull(x-i,y+i))
            {
                int[] moove3 = {-i, i};
                mouvements.put(compteur, moove3);
                compteur++;
                if(searchPieceDifferentColorNotNull(x-i, y+i))
                {
                    xNegatifyPositif = false;
                }
            }
            else
            {
                xNegatifyPositif = false;
            }
            if(xNegatifyNegatif && searchPieceDifferentColorOrNull(x-i,y-i))
            {
            int[] moove4 = {-i, -i};
            mouvements.put(compteur, moove4);
            compteur++;
            if(searchPieceDifferentColorNotNull(x-i, y-i))
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
