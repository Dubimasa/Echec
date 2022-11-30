package view;

import Controller.Facade;

import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;

public class EchecWindow extends JFrame{
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
                int finalX = x;
                int finalY = y;

                temp.addActionListener(actionEvent -> {
                    System.out.println("X = " + finalX +" Y = " + finalY);
                    //temp.setBackground(Color.green);
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
        Echecquier[3][3] = new JButton("Touché");
        System.out.println("Nom = " + Echecquier[3][3].getText());
    }
}
