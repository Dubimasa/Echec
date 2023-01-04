import Controller.Facade;
import model.Echec;
import model.Joueur;
import view.EchecWindow;

import model.Couleur;

public class Main extends Thread{
    public static void main(String[] args) {
        Joueur playerWhite =  new Joueur();
        playerWhite.setColor(Couleur.White);
        Joueur playerBlack =  new Joueur();
        playerBlack.setColor(Couleur.Black);
        Echec echec = new Echec(playerWhite,playerBlack);
        Facade facade = new Facade(echec,playerWhite,playerBlack);
        EchecWindow affiche = new EchecWindow(facade,playerWhite,playerBlack,echec);
        echec.addObserveur(affiche);
        facade.creationPartie();
    }
}