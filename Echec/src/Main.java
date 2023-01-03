import Controller.Facade;
import model.Echec;
import model.Joueur;
import view.EchecWindow;

import model.Couleur;

public class Main {
    public static void main(String[] args) {
        Joueur player1 =  new Joueur();
        player1.setColor(Couleur.White);
        Joueur player2 =  new Joueur();
        player2.setColor(Couleur.Black);
        Echec echec = new Echec(player1,player2);
        Facade facade = new Facade(echec,player1,player2);
        EchecWindow affiche = new EchecWindow(facade);
        echec.addObserveur(affiche);
        facade.creationPartie();
    }
}