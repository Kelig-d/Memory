import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreJeu extends JFrame implements Observer {

    // Attributs
    private Controller controller;
	private Modele modele;

    private JLabel scorePlayerOne, scorePlayerTwo;
    public JLabel playerOne, playerTwo;

    public FenetreJeu(Controller control, Modele model ) {
        this.controller = control;
        this.modele = model;
        this.setTitle("Memory");
        this.setMinimumSize(new Dimension(500,500));
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.construct();
        this.setVisible(true);

    }

    public void construct() {
        JPanel fenetre = new JPanel();
        JPanel game = new JPanel();
        JPanel joueurs = new JPanel();
        JPanel playerOnePanel = new JPanel();
        JPanel playerTwoPanel = new JPanel();

        fenetre.setLayout(new BorderLayout());
        game.setLayout(new GridLayout(modele.getSelectedSize()[0], modele.getSelectedSize()[1], 10,10));
        joueurs.setLayout(new GridLayout(1,2));
        playerOnePanel.setLayout(new GridLayout(2,1));
        playerTwoPanel.setLayout(new GridLayout(2,1));

        playerOne = new JLabel(modele.getNomFirstPlayer());
        playerTwo = new JLabel(modele.getNomSecondPlayer());
        scorePlayerOne = new JLabel(modele.getFirstPlayer().getScore()+"");
        scorePlayerTwo = new JLabel(modele.getSecondPlayer().getScore()+"");

        playerOnePanel.add(playerOne);
        playerOnePanel.add(scorePlayerOne);

        playerTwoPanel.add(playerTwo);
        playerTwoPanel.add(scorePlayerTwo);

        //if(modele.getFirstPlayer().getJouer()) playerOnePanel.setBackground(Color.red);
        //else playerTwoPanel.setBackground(Color.red);

        JButton quitButton = new JButton("Terminer");
        quitButton.addActionListener(new quitgame(this));

        joueurs.add(playerOnePanel);
        joueurs.add(playerTwoPanel);

        fenetre.add(game, BorderLayout.CENTER);
        fenetre.add(joueurs,BorderLayout.NORTH);
        fenetre.add(quitButton,BorderLayout.SOUTH);

        for (Carte card : modele.getList()) {
            card.addActionListener(new flipAction(this));
            game.add(card);

        }

        this.setContentPane(fenetre);
    }

    public void incrementScorePlayers(){
        scorePlayerOne.setText(modele.getFirstPlayer().getScore()+"");
        scorePlayerTwo.setText(modele.getSecondPlayer().getScore()+"");
    }

    @Override
    public void update(Subject o) {
        this.construct();
    }

    public class flipAction implements ActionListener{
        private FenetreJeu f;

        public flipAction(FenetreJeu win){
            f = win;

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            controller.doFlip(((Carte)e.getSource()));

        }
    }
    private class quitgame implements ActionListener {
        private FenetreJeu f;
        public quitgame(FenetreJeu win){
            f = win;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            controller.quitGame();
        }
    }
}
