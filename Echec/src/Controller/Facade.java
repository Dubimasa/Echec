package Controller;

import model.*;

public class Facade {
    private Echec echec;
    private String player1;
    private String player2;
    public Facade(Echec echec1)
    {
        echec = echec1;
    }
    public void CreationPartie()
    {
        echec.creationPartie();
    }
    public Boolean[] pieceSelectionneMouvement(int x, int y)
    {
        echec.calculMouvementPossible(x,y);

    }
}
