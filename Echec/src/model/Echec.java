package model;


import java.awt.*;
import java.util.ArrayList;

public class Echec{
    private static Piece[][] echecquier = new Piece[8][8];
    private static ArrayList<EchecObserver> observers = new ArrayList<>();
    private static Couleur couleur;
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
        PieceFactory pieceFactory = new PieceFactory();
        //Création de l'échequier
        Piece temp;

        //tour
        temp = pieceFactory.createTour(Couleur.Black);
        setPiece(temp,0,0);
        setPiece(temp,7,0);
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
