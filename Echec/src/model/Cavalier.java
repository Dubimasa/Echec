package model;
import java.util.HashMap;
import java.util.Map;
public class Cavalier extends Piece {;
    public Cavalier(Couleur couleur1,Echec echec1)
    {
        super(couleur1,echec1);

    }

    //Méthode initialisant tous les mouvements possibles
    public Map<Integer, int[]> calculmouvementPossible(){
        Map<Integer, int[]> mouvements = new HashMap<Integer, int[]>();

        if(searchPieceDifferentColorOrNull(x+2, y+1))
        {
            int[] moove1 = {2, 1};
            mouvements.put(0, moove1);
        }
        if(searchPieceDifferentColorOrNull(x+2, y-1))
        {
            int[] moove2 = {2, -1};
            mouvements.put(1, moove2);
        }
        if(searchPieceDifferentColorOrNull(x+1, y+2))
        {
            int[] moove3 = {1, 2};
            mouvements.put(2, moove3);
        }
        if(searchPieceDifferentColorOrNull(x+1, y-2))
        {
            int[] moove4 = {1, -2};
            mouvements.put(3, moove4);
        }
        if(searchPieceDifferentColorOrNull(x-2, y+1))
        {
            int[] moove5 = {-2, 1};
            mouvements.put(4, moove5);
        }
        if(searchPieceDifferentColorOrNull(x-2, y-1))
        {
            int[] moove6 = {-2, -1};
            mouvements.put(5, moove6);
        }
        if(searchPieceDifferentColorOrNull(x-1, y+2))
        {
            int[] moove7 = {-1, 2};
            mouvements.put(6, moove7);
        }
        if(searchPieceDifferentColorOrNull(x-1, y-2))
        {
            int[] moove8 = {-1, -2};
            mouvements.put(7, moove8);
        }

        return mouvements;
    }
}
