package Controller;

import model.*;

public class Facade {
    private Echec echec;
    private Joueur player1;
    private Joueur player2;
    private Piece pieceSelectionee;
    public Facade(Echec echec1,Joueur initplayer1, Joueur initplayer2)
    {
        echec = echec1;
        pieceSelectionee = null;
        player1 = initplayer1;
        player2 = initplayer2;
    }
    public void creationPartie()
    {
        echec.creationPartie();
    }
    public void pieceSelectionneMouvement(int x, int y)
    {
        Piece temp = echec.getPiece(x,y);
        //System.out.println(temp.getClass().getSimpleName()+ " " + temp.getColor() +" " + echec.getCouleur() + "pieceX: " + temp.getX());
        
        if(temp == null || temp.getColor() != echec.getCouleur())
        {
            
            if(pieceSelectionee != null)
            {
                //System.out.println(pieceSelectionee.getClass().getSimpleName()+ " " + pieceSelectionee.getColor() +" " + echec.getCouleur());
                if(echec.mouvement(pieceSelectionee.getX(),pieceSelectionee.getY(),x,y))
                {
                    pieceSelectionee = null;
                }
            }
        }
        else
        {
            pieceSelectionee = temp;
            echec.calculMouvementPossible(x,y);
        }
    }
}
