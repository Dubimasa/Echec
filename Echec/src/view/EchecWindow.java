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
        setSize(600, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Affiche = new JPanel();
        JButton temp;
        for(int x = 0; x<8; x++)
        {
            for(int y =0; y<8;y++)
            {
                temp = new JButton();
                int finalX = x;
                int finalY = y;

                temp.addActionListener(actionEvent -> {
                    System.out.println("X = " + finalX +" Y = " + finalY);
                });
                Echecquier[x][y] = temp;
            }
        }

    }
}
