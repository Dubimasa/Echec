package view;

import Controller.Facade;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class EchecWindow extends JFrame implements EchecObserver{
    private static Button_piece[][] Echecquier = new Button_piece[8][8];
    private JPanel FicheJeu;
    private JPanel FichePromotion;
    private JPanel FicheStart;
    private JPanel FicheEnd;
    private JLabel scoreBlack;
    private JLabel scoreWhite;
    private Joueur joueurWhite;
    private Joueur joueurBlack;
    private Facade facade;
    private boolean decisionPion = false;

    public EchecWindow(Facade facade1, Joueur joueur1, Joueur joueur2){
        facade = facade1;
        joueurWhite = joueur1;
        joueurBlack = joueur2;
        setTitle("Echec");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(1, 1));

        startFicheStart();
        CreationPannelPromotion();
        setVisible(true);
    }
    private void CreationPannelPromotion()
    {
        FichePromotion = new JPanel();
        FichePromotion.setLayout( new BoxLayout(FichePromotion,BoxLayout.Y_AXIS) );
        //Création des 4 button
        Button_piece cavalier = boutonPromotion("model.Cavalier");
        Button_piece Tour = boutonPromotion("model.Tour");
        Button_piece Fou = boutonPromotion("model.Fou");
        Button_piece dame = boutonPromotion("model.Dame");
        FichePromotion.add(cavalier);
        FichePromotion.add(Tour);
        FichePromotion.add(Fou);
        FichePromotion.add(dame);
        FichePromotion.setVisible(false);
    }
    private void startFicheStart()
    {
        setSize(250,200);
        creationFicheStart();
        add(FicheStart);
    }
    private void startEchec(Joueur white, Joueur black)
    {
        remove(FicheStart);
        setSize(700,400);
        creationEchec(white,black);
        add(FicheJeu);
        facade.creationPartie();
    }
    private void creationFicheStart()
    {
        FicheStart = new JPanel();
        //FicheStart.setSize(600, 600);


        FicheStart.setBackground(Color.LIGHT_GRAY);
        FicheStart.setLayout(new BoxLayout(FicheStart,BoxLayout.Y_AXIS));

        JLabel player1 = new JLabel("Nom du premier joueur : ");
        JTextField pseudo1 = new JTextField (" Joueur 1 ");

        JLabel player2 = new JLabel("Nom du second joueur : ");
        JTextField pseudo2 = new JTextField (" Joueur 2 ");

        JCheckBox choixcolor = new JCheckBox("Le joueur 1 a les blancs",true);

        JButton start = new JButton("Start the Game");
        start.addActionListener(actionEvent -> {
            //Start Echec
            //Verifier si le pseudo1 et pseudo2 ne sont pas vide
            if(pseudo1.getText() != "" && pseudo2.getText() != "")
            {
                if(choixcolor.isSelected()) //Joueur1 est le blanc
                {
                    joueurWhite.setNom(pseudo1.getText());
                    joueurBlack.setNom(pseudo2.getText());
                }
                else //Joueur2 est le blanc
                {
                    joueurWhite.setNom(pseudo2.getText());
                    joueurBlack.setNom(pseudo1.getText());
                }
                startEchec(joueurWhite, joueurBlack);
            }
        });
        player1.setAlignmentX(Component.CENTER_ALIGNMENT);
        pseudo1.setAlignmentX(Component.CENTER_ALIGNMENT);
        player2.setAlignmentX(Component.CENTER_ALIGNMENT);
        pseudo2.setAlignmentX(Component.CENTER_ALIGNMENT);
        choixcolor.setAlignmentX(Component.CENTER_ALIGNMENT);
        start.setAlignmentX(Component.CENTER_ALIGNMENT);
        FicheStart.add(player1);
        FicheStart.add(pseudo1);
        FicheStart.add(player2);
        FicheStart.add(pseudo2);
        FicheStart.add(choixcolor);
        FicheStart.add(start);
        setVisible(true);
    }

    public void creationFicheEnd(Joueur vainqueur){
        FicheEnd = new JPanel();
        setSize(400, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setBackground(Color.LIGHT_GRAY);
        FicheEnd.setLayout( new BoxLayout(FicheEnd,BoxLayout.Y_AXIS) );

        JLabel Winner = new JLabel("Le vainqueur est " + vainqueur.getNom());
        Winner.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Ajout Jbutton retry et Quittez
        JButton Retry = new JButton("Retry");
        Retry.addActionListener(actionEvent -> {
            startFicheStart();
            remove(FicheEnd);
        });
        Retry.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton Quitter = new JButton("Quitter");
        Quitter.setAlignmentX(Component.CENTER_ALIGNMENT);
        Quitter.addActionListener(actionEvent -> {
            dispose();
        });

        FicheEnd.add(Winner);
        FicheEnd.add(Retry);
        FicheEnd.add(Quitter);
        setVisible(true);
    }

    private void creationEchec(Joueur white, Joueur black)
    {
        FicheJeu = new JPanel();
        FicheJeu.setLayout(new FlowLayout());
        JPanel ficheEchecquier = new JPanel();
        ficheEchecquier.setLayout( new GridLayout(8,8));
        Button_piece temp;
        Boolean color = false;
        for(int y = 0; y<8; y++)
        {
            //JPanel tempAffiche = new JPanel();
            for(int x =0; x<8;x++)
            {
                color = !color;
                temp = new Button_piece(x,y);
                temp.setPreferredSize(new Dimension(50, 40));
                temp.addActionListener(actionEvent -> {
                    Button_piece button = (Button_piece) actionEvent.getSource();
                    if(!decisionPion)
                    {
                        facade.pieceSelectionneMouvement(button.recupx(), button.recupy());
                    }
                });
                temp.setBackground(Color.WHITE);
                if(!color)
                {
                    temp.setBackground(new Color(53, 75, 1));
                }
                Echecquier[x][y] = temp;
                ficheEchecquier.add(temp);
            }
            color = !color;
        }
        //Fiche Affichage des joueurs et de leur score ainsi que de qui qui joue
        JPanel ficheJoueur = new JPanel();
        //Contient 3 partie: Joueur noir, FichePromotionPion , joueur blanc
        ficheJoueur.setLayout(new BoxLayout(ficheJoueur,BoxLayout.Y_AXIS));
        JPanel fiche = createJoueur(black);
        ficheJoueur.add(fiche);
        ficheJoueur.add(FichePromotion);
        fiche = createJoueur(white);
        ficheJoueur.add(fiche);
        //Ajout des deux JPanel dans le pannel FicheJeu
        FicheJeu.add(ficheEchecquier);
        FicheJeu.add(ficheJoueur);
    }
    private JPanel createJoueur(Joueur joueur)
    {
        JPanel pJoueur = new JPanel();
        pJoueur.setLayout(new BoxLayout(pJoueur,BoxLayout.Y_AXIS));
        JLabel nameJoueur = new JLabel(joueur.getNom());
        JLabel couleurJoueur = new JLabel(joueur.getColor().toString());
        JLabel score = new JLabel();
        if(joueur.getColor() == Couleur.White)
        {
            scoreWhite = score;
        }
        else
        {
            scoreBlack = score;
        }
        score.setText(joueur.getScore()+ "");
        score.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));
        pJoueur.add(nameJoueur);
        pJoueur.add(couleurJoueur);
        pJoueur.add(score);
        return pJoueur;
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
    public void updateMouvement(Piece[][] echecquier) {
        cleanBord();
        for(int x = 0; x<8;x++)
        {
            for (int y =0; y<8; y++)
            {
                Piece temp = echecquier[x][y];
                if(temp != null)
                {
                    Echecquier[x][y].metName(temp.getClass().getName(), temp.getColor());
                    //Echecquier[x][y].setText(temp.getClass().getSimpleName() + temp.getColor());
                }
                else
                {
                    Echecquier[x][y].metName(null, null);
                }

            }
        }
    }

    @Override
    public void updateEchec(int roix, int roiy, int attaquantx , int attaquanty) {
        backgroundEchequierBlackWhite();
        Echecquier[roix][roiy].setBackground(Color.RED);
        Echecquier[attaquantx][attaquanty].setBackground(Color.RED);
    }
    public void updateEchecMath(Couleur couleur)
    {
        remove(FicheJeu);
        if(couleur == Couleur.White)
        {
            creationFicheEnd(joueurWhite);
        }
        else
        {
            creationFicheEnd(joueurBlack);
        }
        add(FicheEnd);
    }
    public void updatePromotionPion(int x, int y)
    {
        FichePromotion.setVisible(true);
        decisionPion = true;
    }
    public void updateScore(int score,Couleur couleur)
    {
        if(couleur == Couleur.White)
        {
            joueurWhite.addScore(score);
            scoreWhite.setText(joueurWhite.getScore() + "");
        }
        else
        {
            joueurBlack.addScore(score);
            scoreBlack.setText(joueurBlack.getScore() + "");
        }
    }
    private Button_piece boutonPromotion(String name)
    {
        Button_piece result = new Button_piece(name,Couleur.White);
        result.addActionListener(actionEvent -> {
            Button_piece button = (Button_piece) actionEvent.getSource();
            facade.PionPromotion(button.recupName());
            decisionPion = false;
            FichePromotion.setVisible(false);
            //Ajout de disparition
        });
        return result;
    }
}
