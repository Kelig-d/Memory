import javax.swing.*;
import java.awt.*;

public class FenetreJeu extends JFrame {

    // Attributs
    private Controller controller;
	private Modele modele;

    public FenetreJeu(Controller control, Modele model ) {
        this.controller = control;
        this.modele = model;
        this.setTitle("Memory");
        this.setMinimumSize(new Dimension(250,240));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.construct();
        this.setVisible(true);

    }

    public void construct(){
        JPanel game = new JPanel();
        game.setLayout(new GridLayout(modele.getSelectedSize()[0],modele.getSelectedSize()[1] ));
        modele.creerCartes(modele.getSelectedSize()[0]*modele.getSelectedSize()[1]);
        for(Carte card: modele.getList()){
            game.add(card.getImage_cache());
        }
        this.setContentPane(game);
    }
}
