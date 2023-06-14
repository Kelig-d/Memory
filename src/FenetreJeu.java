import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreJeu extends JFrame {

    // Attributs
    private Controller controller;
	private Modele modele;

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
        fenetre.setLayout(new BorderLayout());
        game.setLayout(new GridLayout(modele.getSelectedSize()[0], modele.getSelectedSize()[1], 10,10));
        joueurs.setLayout(new GridLayout());
        modele.creerCartes(modele.getSelectedSize()[0] * modele.getSelectedSize()[1]);
        fenetre.add(game, BorderLayout.CENTER);
        fenetre.add(joueurs,BorderLayout.NORTH);
        fenetre.add(new JLabel(modele.getNomFirstPlayer()));
        fenetre.add(new JLabel(modele.getNomSecondPlayer()));
        for (Carte card : modele.getList()) {
            card.addActionListener(new flipAction(this));
            game.add(card);

        }
        this.setContentPane(game);
    }

    private class flipAction implements ActionListener{
        private FenetreJeu f;

        public flipAction(FenetreJeu win){
            f = win;

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            controller.doFlip(((Carte)e.getSource()));

        }
    }
}
