package model;


import java.awt.*;
import java.util.*;
import java.util.List;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

public class Echec{
    private static Piece[][] echecquier = new Piece[8][8];
    
    private static ArrayList<EchecObserver> observers = new ArrayList<>();
    private Couleur couleur;
    private static PieceFactory pieceFactory = new PieceFactory();
    private Joueur playerWhite;
    private Joueur playerBlack;
    private String NomPiecePromu;
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
    private void updateEchecMath(Couleur couleur)
    {
        for (EchecObserver echecObserver: observers) {
            echecObserver.updateEchecMath(couleur);
        }
    }
    private void updatePromotionPion(int x, int y)
    {
        for (EchecObserver echecObserver: observers) {
            echecObserver.updatePromotionPion(x, y);
        }
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
    public Piece getPiece(Piece[][] tempEchequier,int x, int y)
    {
        Piece temp = tempEchequier[x][y];
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
        mouvementPossible = calculMouvementPossible(echecquier,x, y,true,couleur);
        updateMouvementPossible(mouvementPossible);
        return mouvementPossible;
    }
    private Boolean[][] calculMouvementPossible(Piece[][] tempEchequier,int x,int y,boolean pieceMouvement,Couleur couleur)
    {
        Boolean[][] mouvementPossible = new Boolean[8][8];
        Piece pieceSelectionne = getPiece(tempEchequier,x, y);
        
        Map<Integer, int[]> mouvements = pieceSelectionne.calculmouvementPossible(tempEchequier);
        for(int[] value : mouvements.values())
        {
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
                    if(verifEchec(dupliEchequier, inverseCouleur).size() == 0) //Pas mise en échec
                    {
                        mouvementPossible[x+value[0]][y+value[1]] = true;
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Hey listen!\n" + e);
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
        //Verification si un pion est promu
        if(echecquier[newEmplacementx][newEmplacementy].getClass().getName() == "model.Pion")
        {
            if(echecquier[newEmplacementx][newEmplacementy].getColor() == Couleur.White)
            {
                if(echecquier[newEmplacementx][newEmplacementy].getY() == 0)
                {
                    PromotionPion(echecquier[newEmplacementx][newEmplacementy]);
                }
            }
            else // == Couleur.Black
            {
                if(echecquier[newEmplacementx][newEmplacementy].getY() == 7)
                {
                    PromotionPion(echecquier[newEmplacementx][newEmplacementy]);
                }
            }
            
        }
        FintourJoueur();
    }
    private void PromotionPion(Piece pion)
    {
        updatePromotionPion(pion.getX(),pion.getY());
        synchronized(this)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        Piece newPiece;
        switch(NomPiecePromu)
        {
            case "Cavalier":
                newPiece = pieceFactory.createCavalier(couleur, this);
                break;
            case "Tour":
                newPiece = pieceFactory.createTour(couleur, this);
                break;
            case "Fou":
                newPiece = pieceFactory.createFou(couleur, this);
                break;
            default:
                newPiece = pieceFactory.createDame(couleur, this);
                break;
        }
        newPiece.setXY(pion.getX(), pion.getY());
        newPiece.setNot_play(false);
        echecquier[pion.getX()][pion.getY()] = newPiece;
        updateMouvement();
    }
    public void pionPromu(String name)
    {
        NomPiecePromu = name;
        synchronized(this)
        {
            notify();
        }
    }
    public void FintourJoueur()
    {
        //Detection d'échec
        List<Piece> pieceAttaquant = verifEchec(echecquier,couleur);
        if(pieceAttaquant.size() > 0)
        {
            if(couleur == Couleur.White)
            {
                updateEchec(playerBlack.getRoi().getX(), playerBlack.getRoi().getY(), pieceAttaquant.get(0).getX(), pieceAttaquant.get(0).getY());
            }
            else
            {
                updateEchec(playerWhite.getRoi().getX(), playerWhite.getRoi().getY(), pieceAttaquant.get(0).getX(), pieceAttaquant.get(0).getY());
            }
            if(verifEchecMath(pieceAttaquant))
            {
                //Win du joueur actuel
                updateEchecMath(couleur);
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
    public List<Piece> verifEchec(Piece[][] tempEchequier, Couleur couleur)
    {
        List<Piece> piecesAttaquant = new ArrayList<Piece>();
        //Recherche roiAdverse
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
        for(int i =0; i<8 ; i++)
        {
            for(int j=0 ; j<8 ; j++)
            {
                if(tempEchequier[i][j] != null)
                {
                    if(tempEchequier[i][j].getColor() == couleur)
                    {
                        Boolean[][] tempMouvementPossible = calculMouvementPossible(tempEchequier,i, j,false,couleur);
                        if(tempMouvementPossible[roiAdverse.getX()][roiAdverse.getY()] != null)
                        {
                            piecesAttaquant.add(tempEchequier[i][j]);
                        }
                        
                    }
                }
                
            }
        }
        return piecesAttaquant;
    }
    public Boolean verifEchecMath(List<Piece> piecesAttaquant)
    {
        Piece RoiAdverse;
        Couleur couleurAdverse;
        //Recupérer le roi adverse
        if(couleur == Couleur.White)
        {
            RoiAdverse = playerBlack.getRoi();
            couleurAdverse = Couleur.Black;
        }
        else
        {
            RoiAdverse = playerWhite.getRoi();
            couleurAdverse = Couleur.White;
        }
        if(piecesAttaquant.size() >=2)
        {
            //Verifier si le roi peut bouger si non Perdu
            Boolean[][] mouvementPossible = calculMouvementPossible(echecquier, RoiAdverse.getX(), RoiAdverse.getY(), true,couleurAdverse);
            if(!searchMouvementpossibleEchec(mouvementPossible)) // si aucun mouvement possible alors echec et math
            {
                return true;
            }
        }
        else
        {
            //Verifier si une piece de la mème couleur que le roi a un mouvement possible si non Perdu
            for(int i =0; i<8 ; i++)
            {
                for(int j=0 ; j<8 ; j++)
                {
                    Piece pieceSelectionne = echecquier[i][j]; 
                    if(pieceSelectionne != null)
                    {
                        if(pieceSelectionne.getColor() == RoiAdverse.getColor())
                        {
                            Boolean[][] mouvementPossible = calculMouvementPossible(echecquier, i, j, true,couleurAdverse);
                            if(searchMouvementpossibleEchec(mouvementPossible)) // si aucun mouvement possible alors echec et math
                            {
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
    /**
     * Recherche si un mouvement est possible dont le tableau passé en 
     * paramètre est le tableau des mouvement possible d'une piece
     * @param mouvementPossible
     * @return
     */
    private boolean searchMouvementpossibleEchec(Boolean[][] mouvementPossible)
    {
        boolean temp = false;
        for(int i = 0; i<8;i++)
        {
            for(int j = 0;j<8;j++)
            {       
                if(mouvementPossible[i][j] != null)
                {
                    temp = true;
                }
            }
        }
        return temp;
    }
}
