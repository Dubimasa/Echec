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
    public void pieceSelectionneMouvement(int x, int y)
    {
        Piece temp = echec.getPiece(x,y);
        System.out.println(temp.getClass().getSimpleName()+ " " + temp.getColor() +" " + echec.getCouleur() + "pieceX: " + temp.getX());
        if(temp == null || temp.getColor() != echec.getCouleur())
        {
            if(pieceSelectionee != null)
            {
                echec.mouvement(x,y);
            }
        }
        else
        {
            pieceSelectionee = temp;
            echec.calculMouvementPossible(x,y);
        }
    }
}
