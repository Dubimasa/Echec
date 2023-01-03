package view;

import Controller.Facade;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class EchecWindow extends JFrame implements EchecObserver{
    private static Button_piece[][] Echecquier = new Button_piece[8][8];
    private JPanel FicheJeu;
    private JPanel FicheStart;
    private Facade facade;

    public EchecWindow(Facade facade1){
        facade = facade1;
        setTitle("Echec");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(2, 1));

        JLabel currentPlayer = new JLabel("Tour du joueur :  ");

        AfficherEchequier();
        //Avant_Partie();
        add(FicheJeu);
        setVisible(true);


    }
    /*private void Avant_Partie()
    {
        facade = facade1;
        setTitle("Echec");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        FicheStart = new JPanel();
        FicheStart.setBackground(Color.LIGHT_GRAY);
        FicheStart.setLayout(new GridLayout(6, 1));

        JLabel player1 = new JLabel("Nom du premier joueur : ");
        FicheStart.add(player1);
        JTextField pseudo1 = new JTextField (" Joueur 1 ");
        FicheStart.add(pseudo2);

        JLabel player2 = new JLabel("Nom du second joueur : ");
        FicheStart.add(player2);
        JTextField pseudo2 = new JTextField (" Joueur 2 ");
        FicheStart.add(pseudo2);

        JCheckBox choixcolor = new JCheckBox("Le joueur 1 a les blancs");
        FicheStart.add(choixcolor);

        JButton start = new JButton();
        FicheStart.add(start);
    }
    */
    private void AfficherEchequier()
    {
        FicheJeu = new JPanel();
        FicheJeu.setLayout( new GridLayout(8,8));
        Button_piece temp;
        Boolean color = false;
        for(int y = 0; y<8; y++)
        {
            //JPanel tempAffiche = new JPanel();
            for(int x =0; x<8;x++)
            {
                color = !color;
                temp = new Button_piece(x,y);

                temp.addActionListener(actionEvent -> {
                    Button_piece button = (Button_piece) actionEvent.getSource();
                    facade.pieceSelectionneMouvement(button.recupx(), button.recupy());
                    
                });
                temp.setBackground(Color.WHITE);
                if(!color)
                {
                    temp.setBackground(new Color(53, 75, 1));
                }
                Echecquier[x][y] = temp;
                FicheJeu.add(temp);
            }
            color = !color;
        }
    }
    private void backgroundEchequierBlackWhite()
    {
        Boolean color = true;
        for(int y = 0; y<8; y++)
        {
            //JPanel tempAffiche = new JPanel();
            for(int x =0; x<8;x++) {
                if(!color) {
                    Echecquier[x][y].setBackground(new Color(53, 75, 1));
                }
                else
                {
                    Echecquier[x][y].setBackground(Color.WHITE);
                }
                color = !color;
            }
            color = !color;
        }
    }
    private void cleanBord()
    {
        backgroundEchequierBlackWhite();
        for(int x = 0; x<8;x++)
        {
            for (int y =0; y<8; y++)
            {
                Echecquier[x][y].setText("");
                //Echecquier[x][y].setIcon(null);
            }
        }
    }
    @Override
    public void updateMouvementPossible(Boolean[][] mouvementPossible) {
        backgroundEchequierBlackWhite();
        for(int y = 0; y<8; y++)
        {
            //JPanel tempAffiche = new JPanel();
            for(int x =0; x<8;x++) {
                //System.out.println(mouvementPossible[x][y]);
                if(mouvementPossible[x][y] != null && mouvementPossible[x][y])
                {
                    Echecquier[x][y].setBackground(Color.GREEN);
                }
            }
        }

    }

    @Override
    public void updateMouvement(Echec echec) {
        cleanBord();
        Piece[][] echecEchecquier = echec.getEchecquier();
        for(int x = 0; x<8;x++)
        {
            for (int y =0; y<8; y++)
            {
                Piece temp = echecEchecquier[x][y];
                if(temp != null)
                {
                    Echecquier[x][y].setText(temp.getClass().getSimpleName() + temp.getColor());
                    //Icon icon = new ImageIcon("images/Tour_Blanc.png");
                    //Echecquier[x][y].setIcon(icon);
                }

            }
        }
    }

    @Override
    public void updateEchec(Echec echec) {

    }
}
