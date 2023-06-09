package Controller;

import model.*;

public class Facade extends Thread{
    private Echec echec;
    private Joueur playerWhite;
    private Joueur playerBlack;
    private Piece pieceSelectionee;
    private Boolean[][] mouvementPossible = new Boolean[8][8];
    public Facade(Echec echec1,Joueur initplayer1, Joueur initplayer2)
    {
        echec = echec1;
        pieceSelectionee = null;
        playerWhite = initplayer1;
        playerBlack = initplayer2;
    }
    public void creationPartie()
    {
        echec.creationPartie();
    }
    public void pieceSelectionneMouvement(int x, int y)
    {
        Piece temp = echec.getPiece(echec.getEchecquier(),x,y);
        //System.out.println(temp.getClass().getSimpleName()+ " " + temp.getColor() +" " + echec.getCouleur() + "pieceX: " + temp.getX());
        
        if(temp == null || temp.getColor() != echec.getCouleur())
        {
            
            if(pieceSelectionee != null)
            {
                //System.out.println(pieceSelectionee.getClass().getSimpleName()+ " " + pieceSelectionee.getColor() +" " + echec.getCouleur());
                if(mouvementPossible[x][y] != null )
                {
                    Piece pieceselec = pieceSelectionee;
                    Echec tempEchec = echec;
                    new Thread() {
                        @Override public void run() {
                            tempEchec.mouvement(pieceselec.getX(),pieceselec.getY(),x,y);
                            }
                    }.start();
                    //echec.mouvement(pieceSelectionee.getX(),pieceSelectionee.getY(),x,y);
                    pieceSelectionee = null;
                    mouvementPossible = new Boolean[8][8];
                    
                }
            }
        }
        else
        {
            pieceSelectionee = temp;
            mouvementPossible = echec.mouvementPossible(x,y);
        }
    }
    public void PionPromotion(String name)
    {
        new Thread(){
            @Override public void run() {
                echec.pionPromu(name); 
                }
        }.start();
        //echec.pionPromu(name);        
    }
}
