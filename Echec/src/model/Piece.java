package model;


import java.util.*;

public abstract class Piece {
    private int[][]  mouvements= new int[8][8];
    protected int x;
    protected int y;
    protected boolean not_play = true; //Boolean étant a true si la piece n'est pas encore joué
    protected Couleur color;
    protected int switch_color;
    protected Echec echec;

    public Piece(Couleur color1,Echec echec1)
    {
        echec = echec1;
        color = color1;
        if(color == Couleur.Black)
        {
            switch_color = 1;
        }
        else
        {
            switch_color = -1;
        }
    }

    public Couleur getColor() {
        return color;
    }
    public abstract Map<Integer, int[]> calculmouvementPossible();
    public boolean searchPieceDifferentColor(int search_x , int search_y)
    {
        System.out.println(search_x + " "+ search_y);
        if(search_x<0 || search_x>7 || search_y<0 || search_y>7)
        {
            return false;
        }
        if(echec.getPiece(search_x,search_y) == null)
        {
            return false;
        }
        if(this.getColor() != echec.getPiece(search_x,search_y).getColor())
        {
            return true;
        }
        return false;
    }
    public void setXY(int init_x,int init_y)
    {
        x = init_x;
        y = init_y;
        //System.out.println("Piece " +this.getClass().getSimpleName()+ " couleur "+ getColor() +" setX = " + x + " setY = " + y);
    }
    public int getX() {
        return x;
    }
}