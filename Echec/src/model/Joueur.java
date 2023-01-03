package model;


import java.util.*;

public class Joueur {
    private int[][]  mouvements= new int[8][8];

    protected String nom;
    protected int score;
    protected Couleur color;
    protected Roi roi;

    public Joueur()
    {

    }
    public void setNom(String init_nom)
    {
        this.nom = init_nom;
    }
    public String getNom() {
        return nom;
    }

    public void setScore(){
        this.score=0;
    }
    public void setColor(Couleur color) {
        this.color = color;
    }
    public void addtoScore(int value){
        this.score=this.score+value;
    }

    public int getScore(){ return score;}
    public Roi getRoi() {
        return roi;
    }
    public void setRoi(Roi roi) {
        this.roi = roi;
    }
}