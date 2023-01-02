package view;


import javax.swing.*;

public class Button_piece extends JButton {
    private int x;
    private int y;

    public Button_piece(int x1, int y1) {
        x = x1;
        y= y1;
    }
    public int recupx()
    {
        return x;
    }
    public int recupy()
    {
        return y;
    }

}
