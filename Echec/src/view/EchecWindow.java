package view;

import Controller.Facade;
import model.*;

import javax.annotation.processing.Generated;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

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
        for(int y = 0; y<8; y++)
        {
            //JPanel tempAffiche = new JPanel();
            for(int x =0; x<8;x++)
            {
                color = !color;
                temp = new JButton();

                temp.addActionListener(actionEvent -> {
                    JButton button = (JButton) actionEvent.getSource();
                    System.out.println(button.getText());
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
                    /*Image image = null;
                    try {
<<<<<<< HEAD
                        image = ImageIO.read(new File("../../images/Tour_Noir.png"));
                        image = ImageIO.read(new File("Tour_noir.png"));
=======
                        image = ImageIO.read(new File("$PROJECT_DIR$" +"images/Tour_noir.png"));
                        //image = ImageIO.read(new File("Tour_noir.png"));
>>>>>>> b799dc52aeb53c65287ae94c89bddbeafac8f483
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    ImageIcon icone = new ImageIcon(image);
<<<<<<< HEAD
                    Echecquier[x][y].setIcon(icone);
=======
                     */
                    Icon icon = new ImageIcon("images/Tour_Blanc.png");
                    Echecquier[x][y].setIcon(icon);
>>>>>>> b799dc52aeb53c65287ae94c89bddbeafac8f483
                }

            }
        }
    }

    @Override
    public void updateEchec(Echec echec) {

    }
}
