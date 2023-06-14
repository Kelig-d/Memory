import javax.swing.JButton;
import javax.swing.Icon;
import java.awt.*;

public class Carte extends JButton{

    // Attributs
    private int id;
    private int id_paire;
    private Icon image_visible;
    private Icon image_cache;

    // Constructeurs
    public Carte(int id, int id_paire, Icon image_visible, Icon image_cache){
        // Initialisation de tous les attributs de cartes
        this.id = id;
        this.id_paire = id_paire;
        this.image_visible = image_visible;
        this.image_cache = image_cache;
        this.setIcon(image_cache);
        this.setOpaque(false);
        this.setBorderPainted(false);
        this.setBackground(Color.white);
        this.setMargin(new Insets(0,0,0,0));
        this.setMinimumSize(new Dimension(100,125));
        this.setPreferredSize(new Dimension(100,125));
        this.setSize(new Dimension(100,125));
    }

    // Méthode
    public void reveler(){
        // On rend visible la carte
        this.setIcon(image_visible);

    }

    public void cacher(){
        // On montre le dos de la carte
        this.setIcon(image_cache);
    }

    public void retirer(){
        // On etire la carte du jeu en la rendant invisible (A changer sans doute ?)
        this.setVisible(false);
    }

    public boolean identique(Carte carte){
        // On regarde si deux cartes sont identiques
        return (this.id_paire == carte.getID_paire());
    }

    // Getter/Setter

    public int getID() {
        return id;
    }

    public int getID_paire() {
        return id_paire;
    }

    public Icon getImage_visible() {
        return image_visible;
    }
 
    public Icon getImage_cache() {
        return image_cache;
    }

    public void setID(int id){
        this.id = id;
    }

    public void setID_paire(int id_paire){
        this.id_paire = id_paire;
    }

    public void setImage_visible(Icon image_visible){
        this.image_visible = image_visible;
    }

    public void setImage_cache(Icon image_cache){
        this.image_cache = image_cache;
    }
}
