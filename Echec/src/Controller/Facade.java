package Controller;

import model.*;

public class Facade {
    private Echec echec;
    private String player1;
    private String player2;
    private Piece pieceSelectionee;
    public Facade(Echec echec1)
    {
        echec = echec1;
        pieceSelectionee = null;
    }
    public void creationPartie()
    {
        echec.creationPartie();
    }
    public Boolean[] pieceSelectionneMouvement(int x, int y)
    {
        echec.calculMouvementPossible(x,y);
        Boolean[] result = new Boolean[8];
        return result;
    }
}
