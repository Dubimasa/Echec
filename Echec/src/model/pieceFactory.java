package model;

public class pieceFactory{
    
    public Piece createCavalier(){
        return new Cavalier();
    }

    public Piece createDame() {
        return new Dame();
    }

    public Piece createTour(){
        return new Tour();
    }

    public Piece createFou(){
        return new Fou();
    }

    public Piece createPion(){
        return new Pion();
    }

    public Piece createRoi(){
        return new Roi();
    }
}
