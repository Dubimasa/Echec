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
            echecObserver.updateMouvement(echecquier);
        }
    }
    private void updateMouvementPossible(Boolean[][] envoie)
    {
        for (EchecObserver echecObserver: observers) {
            echecObserver.updateMouvementPossible(envoie);
        }
    }
    private void updateEchec(int roix, int roiy, int attaquantx , int attaquanty)
    {
        for (EchecObserver echecObserver: observers) {
            echecObserver.updateEchec(roix,roiy,attaquantx,attaquanty);
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
    private Piece[][] dupliqueEchequier(Piece[][] tempEchequier)
    {
        Piece[][] dupli = new Piece[8][8];
        for(int i =0; i<8 ; i++)
        {
            for(int j=0 ; j<8 ; j++)
            {
                dupli[i][j] = tempEchequier[i][j];
            }
        }
        return dupli;
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
        playerBlack.setRoi(temp);
        temp = pieceFactory.createRoi(Couleur.White,this);
        setPiece(temp,4,7);
        playerWhite.setRoi(temp);
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
    public Boolean[][] mouvementPossible(int x,int y)
    {
        Boolean[][] mouvementPossible;
        mouvementPossible = calculMouvementPossible(echecquier,x, y,true);
        updateMouvementPossible(mouvementPossible);
        return mouvementPossible;
    }
    private Boolean[][] calculMouvementPossible(Piece[][] tempEchequier,int x,int y,boolean pieceMouvement)
    {
        Boolean[][] mouvementPossible = new Boolean[8][8];
        Piece pieceSelectionne = getPiece(x, y);
        
        //System.out.println("La classe sélectionné est :" + pieceSelectionne.getClass().getSimpleName() + " La couleur est : "
        // + pieceSelectionne.getColor() + " et la position est " + x+" "+ y);
        
        Map<Integer, int[]> mouvements = pieceSelectionne.calculmouvementPossible(tempEchequier);
        //System.out.println("Les mouvement sont :");
        for(int[] value : mouvements.values())
        {
            //System.out.println(value[0] + " " + value[1]);
            if(pieceMouvement)
            {
            //Ajouter un verifEchec
                try
                {
                    Piece[][] dupliEchequier = dupliqueEchequier(tempEchequier);
                    Piece clonePieceSelectionne = (Piece) pieceSelectionne.clonee();
                    clonePieceSelectionne.setXY(x+value[0], y+value[1]);
                    dupliEchequier[x+value[0]][y+value[1]] = clonePieceSelectionne;
                    dupliEchequier[x][y] = null;
                    Couleur inverseCouleur;
                    if(couleur == Couleur.White)
                    {
                        inverseCouleur = Couleur.Black;
                    }
                    else
                    {
                        inverseCouleur = Couleur.White;
                    }
                    if(!(verifEchec(dupliEchequier, inverseCouleur)))
                    {
                        mouvementPossible[x+value[0]][y+value[1]] = true;
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Personne n'est censé me voir et si c'est le cas mon créateur pue");
                }
                
            }
            else
            {
                mouvementPossible[x+value[0]][y+value[1]] = true;
            }
        }
        
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
            System.out.println("ECHEC");
            if(verifEchecMath())
            {
                //Win du joueur actuel
            }
        }
        //Tour suivant
        if(couleur == Couleur.White)
        {
            couleur = Couleur.Black;
        }
        else
        {
            couleur = Couleur.White;
        }
    }
    public Boolean verifEchec(Piece[][] tempEchequier, Couleur couleur)
    {
        //Piece forcément remplacé par le double for en dessous
        Piece roiAdverse = tempEchequier[0][0];
        boolean arretChercheRoi = true;
        for(int roii =0; roii<8 && arretChercheRoi; roii++)
        {
            for(int roij=0 ; roij<8 && arretChercheRoi; roij++)
            {
                Piece temporaire = tempEchequier[roii][roij];
                if(temporaire != null)
                {
                    if(temporaire.getClass().getName() == "model.Roi")
                    {
                        if(couleur == Couleur.White)
                        {
                            if(temporaire.getColor() == Couleur.Black)
                            {
                                roiAdverse = tempEchequier[roii][roij];
                                arretChercheRoi = false;
                            }
                        }
                        else
                        {
                            if(temporaire.getColor() == Couleur.White)
                            {
                                roiAdverse = tempEchequier[roii][roij];
                                arretChercheRoi = false;
                            }
                        }
                    }
                }
            }
        }
        //Recherche roiAdverse
        
        for(int i =0; i<8 ; i++)
        {
            for(int j=0 ; j<8 ; j++)
            {
                if(tempEchequier[i][j] != null)
                {
                    if(tempEchequier[i][j].getColor() == couleur)
                    {
                        Boolean[][] tempMouvementPossible = calculMouvementPossible(tempEchequier,i, j,false);
                        if(tempMouvementPossible[roiAdverse.getX()][roiAdverse.getY()] != null)
                        {
                            updateEchec(roiAdverse.getX(), roiAdverse.getY(), i, j);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public Boolean verifEchecMath()
    {
        return false;
    }
}
