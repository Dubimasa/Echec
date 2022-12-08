package view;

import Controller.Facade;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class EchecWindow extends JFrame implements EchecObserver{
    private static Button_piece[][] Echecquier = new Button_piece[8][8];
    private JPanel Affiche;
    private Facade facade;

    public EchecWindow(Facade facade1)
    {
        facade = facade1;
        setTitle("Echec");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Affiche = new JPanel();
        Affiche.setLayout( new GridLayout(8,8));
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
                    System.out.println(button.getText() + " " + button.recupx() + " " + button.recupy());
                });
                temp.setBackground(Color.WHITE);
                if(color == false)
                {
                    temp.setBackground(new Color(53, 75, 1));
                }

                Echecquier[x][y] = temp;
                Affiche.add(temp);
            }
            color = !color;
        }
        setLayout(new GridLayout(1, 1));
        add(Affiche);
        setVisible(true);



    }

    @Override
    public void updateMouvementPossible(Echec echec) {

    }

    @Override
    public void updateMouvement(Echec echec) {
        Piece[][] echecEchecquier = echec.getEchecquier();
        System.out.println();
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
