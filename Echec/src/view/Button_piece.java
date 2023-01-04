package view;


import javax.swing.*;

public class Button_piece extends JButton {
    private int x;
    private int y;
    private String name;

    public Button_piece(int x1, int y1, String name1) {
        x = x1;
        y= y1;
        name = name1;
        //setSize(10,10);
    }
    public Button_piece(String name1)
    {
        name = name1;
    }
    public int recupx()
    {
        return x;
    }
    public int recupy()
    {
        return y;
    }
    public String recupName()
    {
        return name;
    }

}
