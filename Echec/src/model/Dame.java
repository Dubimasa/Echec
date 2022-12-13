package model;

public class Dame extends Piece {
    public Dame(Couleur couleur1)
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

             int[] moove5 = {i, 0};
            mouvements.put(compteur, moove5);
            compteur++;

            int[] moove6 = {-i, 0};
            mouvements.put(compteur, moove6);
            compteur++;

            int[] moove7 = {0, i};
            mouvements.put(compteur, moove7);
            compteur++;

            int[] moove8 = {0, -i};
            mouvements.put(compteur, moove8);
            compteur++;
        }


        return mouvements;
    }
}
