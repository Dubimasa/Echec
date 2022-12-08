package model;

import model.Echec;

public interface EchecObserver {
    public void updateMouvementPossible(Echec echec);
    public void updateMouvement(Echec echec);
    public void updateEchec(Echec echec);
}
