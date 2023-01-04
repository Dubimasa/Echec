package model;


import java.util.*;

public abstract class Piece implements Cloneable {
    //private int[][]  mouvements= new int[8][8];
    protected int x;
    protected int y;
    protected boolean not_play = true; //Boolean étant a true si la piece n'est pas encore joué
    protected Couleur color;
    protected int switch_color;

    public Piece(Couleur color1)
    {
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
    public abstract Map<Integer, int[]> calculmouvementPossible(Piece[][] echequier);
    public boolean searchPieceDifferentColorOrNull(Piece[][] echequier,int search_x , int search_y)
    {
        //System.out.println(search_x + " "+ search_y);
        if(search_x<0 || search_x>7 || search_y<0 || search_y>7)
        {
            return false;
        }
        if(echequier[search_x][search_y] == null)
        {
            return true;
        }
        if(this.getColor() != echequier[search_x][search_y].getColor())
        {
            return true;
        }
        return false;
    }
    public boolean searchPieceDifferentColorNotNull(Piece[][] echequier,int search_x , int search_y)
    {
        //System.out.println(search_x + " "+ search_y);
        if(search_x<0 || search_x>7 || search_y<0 || search_y>7)
        {
            return false;
        }
        if(echequier[search_x][search_y] == null)
        {
            return false;
        }
        if(this.getColor() != echequier[search_x][search_y].getColor())
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
    public int getY() {
        return y;
    }
    public void setNot_play(boolean not_play) {
        this.not_play = not_play;
    }
    public boolean getNot_play()
    {
        return not_play;
    }
    
    public Piece clonee() throws CloneNotSupportedException
    {
        return (Piece) this.clone();
    }
}