package model;


import java.util.*;

public class Joueur {
    private int[][]  mouvements= new int[8][8];

    protected String nom;
    protected int score;
    protected Couleur color;
    protected Piece roi;

    public Joueur(Couleur color1)
    {
        color = color1;
        setScore(0);
    }
    public void setNom(String init_nom)
    {
        nom = init_nom;
    }
    public String getNom() {
        return nom;
    }
    public Couleur getColor() {
        return color;
    }

    public void setScore(int score1){
        score= score1;
    }
    public void addScore(int score1)
    {
        score = score + score1;
    }
    public void addtoScore(int value){
        score = score+value;
    }

    public int getScore(){ return score;}
    public Piece getRoi() {
        return roi;
    }
    public void setRoi(Piece roi) {
        this.roi = roi;
    }
}