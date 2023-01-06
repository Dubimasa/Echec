package view;


import javax.swing.*;

import model.Couleur;

public class Button_piece extends JButton {
    private int x;
    private int y;
    private String name;

    public Button_piece(int x1, int y1) {
        x = x1;
        y= y1;
        //setSize(10,10);
    }
    public Button_piece(String name1, Couleur couleur)
    {
        name = name1;
        placeImage(couleur);

    }
    public int recupx()
    {
        return x;
    }
    public int recupy()
    {
        return y;
    }
    public void metName(String name1, Couleur couleur)
    {
        name = name1;
        placeImage(couleur);
    }
    private void placeImage(Couleur couleur)
    {
        String cheminImage = "/";
        if(name ==null)
        {
            cheminImage = cheminImage + "Rien.png";
        }
        else
        {
            //System.out.println(name);//model.
            cheminImage = cheminImage + name.substring(6) +couleur.toString() + ".png";
        }
        //System.out.println(cheminImage);
        //Icon icon = new ImageIcon(cheminImage);
        Icon icon = new ImageIcon(getClass().getResource(cheminImage));
        setIcon(icon);
    }
    public String recupName()
    {
        return name;
    }

}
