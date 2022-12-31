import Controller.Facade;
import model.Echec;
import view.EchecWindow;

import model.Couleur;

public class Main {
    public static void main(String[] args) {
        Echec echec = new Echec();
        Facade facade = new Facade(echec);
        EchecWindow affiche = new EchecWindow(facade);
        echec.addObserveur(affiche);
        facade.creationPartie();
    }
}