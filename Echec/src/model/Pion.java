package model;

import java.util.HashMap;
import java.util.Map;

public class Pion extends Piece {
    

    public Pion(Couleur color1,Echec echec1)
    {
        super(color1,echec1);
    }

    //Méthode initialisant tous les mouvements possibles
    public Map<Integer, int[]> calculmouvementPossible(){
        Map<Integer, int[]> mouvements = new HashMap<Integer, int[]>();
        //Vérifie si le déplacement avant de 1 case est possible
        if(echec.getPiece(x,y+(1*switch_color)) == null)
        {
            int[] moove1 = {0, 1*switch_color};
            mouvements.put(0, moove1);

            //Vérifie si le déplacement avant de 2 case est possible
            if (this.not_play && echec.getPiece(x,y+(2*switch_color)) == null){
                int[] moove2 = {0, 2*switch_color};
                mouvements.put(1, moove2);
            }
        }
        
        //Vérifie si ennemi dans le coin au dessus à droite du pion
        if(searchPieceDifferentColor(x+1, y+1*switch_color)){
            int[] moove3 = {1, 1*switch_color};
            mouvements.put(2, moove3);
        }
        //Vérifie si ennemi dans le coin au dessus  à gauche
        if (searchPieceDifferentColor(x-1, y+1*switch_color)){
            int[] moove4 = {-1, 1*switch_color};
            mouvements.put(3, moove4);
        }
        
        return mouvements;
    }


}
