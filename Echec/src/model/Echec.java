package model;


import java.awt.*;
import java.util.ArrayList;

public class Echec{
    private static Piece[][] echecquier = new Piece[8][8];
    private static ArrayList<EchecObserver> observers = new ArrayList<>();
    private static Couleur couleur;
    private static PieceFactory pieceFactory = new PieceFactory();
    public void Echec()
    {
        couleur = couleur.White;
    }
    public void addObserveur(EchecObserver echecObserver)
    {
        observers.add(echecObserver);
    }
    private void updateMouvement()
    {
        for (EchecObserver echecObserver: observers) {
            echecObserver.updateMouvement(this);
        }
    }
    public Piece[][] getEchecquier() {
        return echecquier;
    }
    private void setPiece(Piece piece, int x, int y)
    {
        try{
            echecquier[x][y] = piece;
            this.updateMouvement();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }
    public void creationPartie()
    {
        Piece temp;

        //tour
        temp = pieceFactory.createTour(Couleur.Black);
        setPiece(temp,0,0);
        setPiece(temp,7,0);
        temp = pieceFactory.createTour(Couleur.White);
        setPiece(temp,0,7);
        setPiece(temp,7,7);
        //cavalier
        temp = pieceFactory.createCavalier(Couleur.Black);
        setPiece(temp,1,0);
        setPiece(temp,6,0);
        temp = pieceFactory.createCavalier(Couleur.White);
        setPiece(temp,1,7);
        setPiece(temp,6,7);
        //fou
        temp = pieceFactory.createFou(Couleur.Black);
        setPiece(temp,2,0);
        setPiece(temp,5,0);
        temp = pieceFactory.createFou(Couleur.White);
        setPiece(temp,2,7);
        setPiece(temp,5,7);
        //dame
        temp = pieceFactory.createDame(Couleur.Black);
        setPiece(temp,3,0);
        temp = pieceFactory.createDame(Couleur.White);
        setPiece(temp,3,7);
        //Roi
        temp = pieceFactory.createRoi(Couleur.Black);
        setPiece(temp,4,0);
        temp = pieceFactory.createRoi(Couleur.White);
        setPiece(temp,4,7);
        //Pion
        temp = pieceFactory.createPion(Couleur.Black);
        for(int i = 0; i<8 ; i++)
        {
            setPiece(temp,i,1);
        }
        temp = pieceFactory.createPion(Couleur.White);
        for(int i = 0; i<8 ; i++)
        {
            setPiece(temp,i,6);
        }
    }
    public Boolean[][] calculMouvementPossible(int x,int y)
    {
        Boolean[][] result = new Boolean[8][8];
        return result;
    }
    public void FintourJoueur()
    {
        if(couleur == Couleur.White)
        {
            couleur = Couleur.Black;
        }
        else
        {
            couleur = Couleur.White;
        }
    }
    public Boolean verifEchec()
    {
        return true;
    }
    public Boolean verifEchecMath()
    {
        return true;
    }
}
