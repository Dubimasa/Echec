package model;

public class PieceFactory {

    public Piece createCavalier(Couleur couleur){
        return new Cavalier(couleur);
    }

    public Piece createDame(Couleur couleur) {
        return new Dame(couleur);
    }

    public Piece createTour(Couleur couleur){
        return new Tour(couleur);
    }

    public Piece createFou(Couleur couleur){
        return new Fou(couleur);
    }

    public Piece createPion(Couleur couleur){
        return new Pion(couleur);
    }

    public Piece createRoi(Couleur couleur){
        return new Roi(couleur);
    }
}
