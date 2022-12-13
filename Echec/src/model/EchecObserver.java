package model;

import model.Echec;

public interface EchecObserver {
    public void updateMouvementPossible(Boolean[][] mouvementPossible);
    public void updateMouvement(Echec echec);
    public void updateEchec(Echec echec);
}
