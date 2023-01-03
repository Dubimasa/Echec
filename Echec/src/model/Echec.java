package model;


import java.awt.*;
import java.util.*;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

public class Echec{
    private static Piece[][] echecquier = new Piece[8][8];
    
    private static ArrayList<EchecObserver> observers = new ArrayList<>();
    private Couleur couleur;
    private static PieceFactory pieceFactory = new PieceFactory();
    private Joueur playerWhite;
    private Joueur playerBlack;
    public Echec(Joueur initPlayer1, Joueur initPlayer2)
    {
        couleur = Couleur.White;
        playerWhite = initPlayer1;
        playerBlack = initPlayer2;
    }

    public Couleur getCouleur() {
        return couleur;
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
    private void updateMouvementPossible(Boolean[][] envoie)
    {
        for (EchecObserver echecObserver: observers) {
            echecObserver.updateMouvementPossible(envoie);
        }
    }
    public Piece[][] getEchecquier() {
        return echecquier;
    }
    private void setPiece(Piece piece, int x, int y)
    {
        
        try{
            echecquier[x][y] = piece;
            piece.setXY(x,y);
            this.updateMouvement();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }
    public Piece getPiece(int x, int y)
    {
        Piece temp = echecquier[x][y];
        return temp;
    }
    public void creationPartie()
    {
        Piece temp;
        echecquier = new Piece[8][8];

        //tour
        temp = pieceFactory.createTour(Couleur.Black,this);
        setPiece(temp,0,0);
        temp = pieceFactory.createTour(Couleur.Black,this);
        setPiece(temp,7,0);
        temp = pieceFactory.createTour(Couleur.White,this);
        setPiece(temp,0,7);
        temp = pieceFactory.createTour(Couleur.White,this);
        setPiece(temp,7,7);
        //cavalier
        temp = pieceFactory.createCavalier(Couleur.Black,this);
        setPiece(temp,1,0);
        temp = pieceFactory.createCavalier(Couleur.Black,this);
        setPiece(temp,6,0);
        temp = pieceFactory.createCavalier(Couleur.White,this);
        setPiece(temp,1,7);
        temp = pieceFactory.createCavalier(Couleur.White,this);
        setPiece(temp,6,7);
        //fou
        temp = pieceFactory.createFou(Couleur.Black,this);
        setPiece(temp,2,0);
        temp = pieceFactory.createFou(Couleur.Black,this);
        setPiece(temp,5,0);
        temp = pieceFactory.createFou(Couleur.White,this);
        setPiece(temp,2,7);
        temp = pieceFactory.createFou(Couleur.White,this);
        setPiece(temp,5,7);
        //dame
        temp = pieceFactory.createDame(Couleur.Black,this);
        setPiece(temp,4,0);
        temp = pieceFactory.createDame(Couleur.White,this);
        setPiece(temp,3,7);
        //Roi
        temp = pieceFactory.createRoi(Couleur.Black,this);
        setPiece(temp,3,0);
        temp = pieceFactory.createRoi(Couleur.White,this);
        setPiece(temp,4,7);
        //Pion
        for(int i = 0; i<8 ; i++)
        {
            temp = pieceFactory.createPion(Couleur.Black,this);
            setPiece(temp,i,1);
        }
        for(int i = 0; i<8 ; i++)
        {
            temp = pieceFactory.createPion(Couleur.White,this);
            setPiece(temp,i,6);
        }
    }
    public Boolean[][] calculMouvementPossible(int x,int y)
    {
        Boolean[][] mouvementPossible = new Boolean[8][8];
        Piece pieceSelectionne = getPiece(x, y);
        
        System.out.println("La classe sélectionné est :" + pieceSelectionne.getClass().getSimpleName() + " La couleur est : "
         + pieceSelectionne.getColor() + " et la position est " + x+" "+ y);
        
        Map<Integer, int[]> mouvements = pieceSelectionne.calculmouvementPossible();
        System.out.println("Les mouvement sont :");
        for(int[] value : mouvements.values())
        {
            System.out.println(value[0] + " " + value[1]);
            
            //Ajouter un verifEchec

            mouvementPossible[x+value[0]][y+value[1]] = true;
        }
        updateMouvementPossible(mouvementPossible);
        return mouvementPossible;
    }
    public void mouvement(int pieceSelectionex, int pieceSelectioney, int newEmplacementx, int newEmplacementy)
    {
        //Changer l'échequier
        echecquier[pieceSelectionex][pieceSelectioney].setXY(newEmplacementx, newEmplacementy);
        echecquier[pieceSelectionex][pieceSelectioney].setNot_play(false);
        echecquier[newEmplacementx][newEmplacementy] = echecquier[pieceSelectionex][pieceSelectioney];
        echecquier[pieceSelectionex][pieceSelectioney] = null;
        //Changer l'affichage de l'échequier
        updateMouvement();
        FintourJoueur();
    }
    public void FintourJoueur()
    {
        //Detection d'échec
        if(verifEchec(echecquier,couleur))
        {
            if(verifEchecMath())
            {
                //Win du joueur actuel
            }
        }
        else //Tour suivant
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
    }
    public Boolean verifEchec(Piece[][] tempEchequier, Couleur couleur)
    {
        
        return false;
    }
    public Boolean verifEchecMath()
    {
        return true;
    }
}
