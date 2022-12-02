package Controller;

import model.*;

public class Facade {
    private Echec echec;
    public Facade(Echec echec1)
    {
        echec = echec1;
    }
    public void CreationPartie()
    {
        echec.creationPartie();
    }
}
