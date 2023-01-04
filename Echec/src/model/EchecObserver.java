package model;

import model.Echec;

public interface EchecObserver {
    public void updateMouvementPossible(Boolean[][] mouvementPossible);
    public void updateMouvement(Piece[][] echecquier);
    public void updateEchec(int roix, int roiy, int attaquantx , int attaquanty);
    public void updateEchecMath(Couleur couleur);
    public void updatePromotionPion(int x, int y);
}
