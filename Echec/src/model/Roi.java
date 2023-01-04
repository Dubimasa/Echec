package model;

import java.util.HashMap;
import java.util.Map;

public class Roi extends Piece{
    public Roi(Couleur couleur1)
    {
        super(couleur1);
    }

    //Méthode initialisant tous les mouvements possibles
    public Map<Integer, int[]> calculmouvementPossible(Piece[][] echequier){
        Map<Integer, int[]> mouvements = new HashMap<Integer, int[]>();
        int compteur = 0;
        if(searchPieceDifferentColorOrNull(echequier,x+1, y))
        {
            int[] moove1 = {1, 0};
            mouvements.put(compteur, moove1);
            compteur++;
        }
        if(searchPieceDifferentColorOrNull(echequier,x-1, y))
        {
            int[] moove2 = {-1, 0};
            mouvements.put(compteur, moove2);
            compteur++;
        }
        if(searchPieceDifferentColorOrNull(echequier,x+1, y+1))
        {
            int[] moove3 = {1, 1};
            mouvements.put(compteur, moove3);
            compteur++;
        }
        if(searchPieceDifferentColorOrNull(echequier,x+1, y-1))
        {
            int[] moove4 = {1, -1};
            mouvements.put(compteur, moove4);
            compteur++;
        }
        if(searchPieceDifferentColorOrNull(echequier,x, y-1))
        {
            int[] moove5 = {0, -1};
            mouvements.put(compteur, moove5);
            compteur++;
        }
        if(searchPieceDifferentColorOrNull(echequier,x, y+1))
        {
            int[] moove6 = {0, 1};
            mouvements.put(compteur, moove6);
            compteur++;
        }
        if(searchPieceDifferentColorOrNull(echequier,x-1, y+1))
        {
            int[] moove7 = {-1, 1};
            mouvements.put(compteur, moove7);
            compteur++;
        }
        if(searchPieceDifferentColorOrNull(echequier,x-1, y-1))
        {
            int[] moove8 = {-1, -1};
            mouvements.put(compteur, moove8);
            compteur++;
        }
        if(not_play)
        {
            Piece temp;
            //Recherche Tour gauche
            temp = echequier[0][getY()];
            if(temp != null)
            {
                if(temp.getClass().getName() == "model.Tour"  && temp.getNot_play())
                {
                    boolean verifnull = true;
                    for(int i = 1; i< getX() && verifnull ; i++)
                    {
                        if(echequier[i][getY()] != null)
                        {
                            verifnull = false;
                        }
                    }
                    if(verifnull)
                    {
                        int[] moove9 = {-2, 0};
                        mouvements.put(compteur, moove9);
                        compteur++;
                    }
                }
            }
            //Recherche Tour Droite
            temp = echequier[7][getY()];
            if(temp != null)
            {
                if(temp.getClass().getName() == "model.Tour"  && temp.getNot_play())
                {
                    boolean verifnull = true;
                    for(int i = 6; i> getX() && verifnull ; i--)
                    {
                        if(echequier[i][getY()] != null)
                        {
                            verifnull = false;
                        }
                    }
                    if(verifnull)
                    {
                        int[] moove10 = {2, 0};
                        mouvements.put(compteur, moove10);
                        compteur++;
                    }
                }
            }
        }
        return mouvements;
    }
}
