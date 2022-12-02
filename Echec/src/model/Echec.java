package model;

import view.EchecObserver;

import java.util.ArrayList;

public class Echec{
    private Piece[][] echecquier = new Piece[8][8];
    private ArrayList<EchecObserver> observers = new ArrayList<>();
    public void Echec()
    {
        PieceFactory pieceFactory = new PieceFactory();
        //Création de l'échequier
        Piece temp;

        //tour
        temp = pieceFactory.createTour(Color.Black);
        setPiece(temp,8,8);
    }
    public void addObserveur(EchecObserver echecObserver)
    {
        observers.add(echecObserver);
    }
    public void envoie()
    {
        for (EchecObserver echecObserver: observers) {
            echecObserver.update(this);
        }
    }
    public Piece[][] getEchecquier() {
        return echecquier;
    }
    private void setPiece(Piece piece , int x, int y)
    {
        try{
            echecquier[x][y] = piece;
            envoie();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }
}
