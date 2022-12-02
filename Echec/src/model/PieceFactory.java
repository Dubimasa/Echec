package model;

public class PieceFactory {

    public Piece createCavalier(Color color){
        return new Cavalier(color);
    }

    public Piece createDame(Color color) {
        return new Dame(color);
    }

    public Piece createTour(Color color){
        return new Tour(color);
    }

    public Piece createFou(Color color){
        return new Fou(color);
    }

    public Piece createPion(Color color){
        return new Pion(color);
    }

    public Piece createRoi(Color color){
        return new Roi(color);
    }
}
