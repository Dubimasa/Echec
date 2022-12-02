package model;

import view.EchecObserver;

import java.util.ArrayList;

public class Echec{
    private static Piece[][] echecquier = new Piece[8][8];
    private static ArrayList<EchecObserver> observers = new ArrayList<>();
    public void Echec()
    {

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
        setPiece(temp,0,7);
    }
}
