import javax.swing.JLabel;

public class Carte {
    

    // Attributs
    private int id;
    private int id_paire;
    private JLabel image_visible;
    private JLabel image_cache;
    private boolean visible;

    // Constructeurs
    public Carte(int id, int id_paire, JLabel image_visible, JLabel image_cache){
        // Initialisation de tous les attributs de cartes
        this.id = id;
        this.id_paire = id_paire;
        this.image_visible = image_visible;
        this.image_cache = image_cache;
        this.visible = false;
        image_cache.setVisible(!visible);
    }

    // Méthode
    public void reveler(){
        // On rend visible la carte
        this.visible = true;
        image_visible.setVisible(visible);
        image_cache.setVisible(!visible);
    }

    public void cacher(){
        // On montre le dos de la carte
        this.visible = false;
        image_visible.setVisible(visible);
        image_cache.setVisible(!visible);
    }

    public void retirer(){
        // On etire la carte du jeu en la rendant invisible (A changer sans doute ?)
        this.visible = false;
        image_visible.setVisible(visible);
        image_cache.setVisible(visible);
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

    public JLabel getImage_visible() {
        return image_visible;
    }
 
    public JLabel getImage_cache() {
        return image_cache;
    }

    public Boolean getVisible(){
        return visible;
    }

    public void setID(int id){
        this.id = id;
    }

    public void setID_paire(int id_paire){
        this.id_paire = id_paire;
    }

    public void setImage_visible(JLabel image_visible){
        this.image_visible = image_visible;
    }

    public void setImage_cache(JLabel image_cache){
        this.image_cache = image_cache;
    }

    public void setVisible(Boolean visible){
        this.visible = visible;
    }
}
