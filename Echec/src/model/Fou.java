package model;

public class Fou extends Piece{
    public Fou(Couleur couleur1)
    {
        super(couleur1);
    }

    //Méthode initialisant tous les mouvements possibles
    public Map< class="hljs-built_in">int, int[]> calculmouvementPossible(Echec echec){
        Map< class="hljs-built_in">int, int[]> mouvements = new HashMap<int, int[]>();

        int compteur=0;
        for(int i=1; i<7; i++){
            int[] moove1 = {i, i};
            mouvements.put(compteur, moove1);
            compteur++;

            int[] moove2 = {i, -i};
            mouvements.put(compteur, moove2);
            compteur++;

            int[] moove3 = {-i, i};
            mouvements.put(compteur, moove3);
            compteur++;

            int[] moove4 = {-i, -i};
            mouvements.put(compteur, moove4);
            compteur++;
        }

        return mouvements;
    }
}
