import Controller.Facade;
import model.Echec;
import view.EchecWindow;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        EchecWindow affiche = new EchecWindow();
        Echec echec = new Echec();
        echec.addObserveur(affiche);
        Facade facade = new Facade(echec);
        facade.CreationPartie();
    }
}