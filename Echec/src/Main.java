import Controller.Facade;
import model.Echec;
import model.Joueur;
import view.EchecWindow;

import model.Couleur;

public class Main extends Thread{
    public static void main(String[] args) {
        Joueur playerWhite =  new Joueur(Couleur.White);
        Joueur playerBlack =  new Joueur(Couleur.Black);
        Echec echec = new Echec(playerWhite,playerBlack);
        Facade facade = new Facade(echec,playerWhite,playerBlack);
        EchecWindow affiche = new EchecWindow(facade,playerWhite,playerBlack);
        echec.addObserveur(affiche);
    }
}