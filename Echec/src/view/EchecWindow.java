package view;

import Controller.Facade;
import model.*;

import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class EchecWindow extends JFrame implements EchecObserver{
    private static JButton[][] Echecquier = new JButton[8][8];
    private JPanel Affiche;

    public EchecWindow()
    {
        setTitle("Echec");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Affiche = new JPanel();
        Affiche.setLayout( new GridLayout(8,8));
        JButton temp;
        Boolean color = false;
        for(int x = 0; x<8; x++)
        {
            //JPanel tempAffiche = new JPanel();
            for(int y =0; y<8;y++)
            {
                color = !color;
                temp = new JButton();

                temp.addActionListener(actionEvent -> {
                    JButton button = (JButton) actionEvent.getSource();
                });
                temp.setBackground(Color.WHITE);
                if(color == false)
                {
                    temp.setBackground(Color.BLACK);
                }

                Echecquier[x][y] = temp;
                Affiche.add(temp);
            }
            color = !color;
        }
        setLayout(new GridLayout(1, 1));
        add(Affiche);
        setVisible(true);

        System.out.println("Nom = " + Echecquier[3][3].getText());
        Echecquier[3][3].setText("Touché");
        System.out.println("Nom = " + Echecquier[3][3].getText());



    }

    @Override
    public void updateMouvementPossible(Echec echec) {

    }

    @Override
    public void updateMouvement(Echec echec) {
        Piece[][] echecEchecquier = echec.getEchecquier();
        for(int x = 0; x<8;x++)
        {
            for (int y =0; y<8; y++)
            {
                Piece temp = echecEchecquier[x][y];
                if(temp != null)
                {
                    Echecquier[x][y].setText(temp.getClass().getName());
                    System.out.println(temp.getClass().getName());
                }

            }
        }
    }

    @Override
    public void updateEchec(Echec echec) {

    }
}
