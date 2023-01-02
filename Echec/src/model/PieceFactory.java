package model;

public class PieceFactory {

    public Piece createCavalier(Couleur couleur,Echec echec){
        return new Cavalier(couleur,echec);
    }

    public Piece createDame(Couleur couleur,Echec echec) {
        return new Dame(couleur,echec);
    }

    public Piece createTour(Couleur couleur,Echec echec){
        return new Tour(couleur,echec);
    }

    public Piece createFou(Couleur couleur,Echec echec){
        return new Fou(couleur,echec);
    }

    public Piece createPion(Couleur couleur,Echec echec){
        return new Pion(couleur,echec);
    }

    public Piece createRoi(Couleur couleur,Echec echec){
        return new Roi(couleur,echec);
    }
}
