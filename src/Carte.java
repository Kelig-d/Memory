import javax.swing.JLabel;

public class Carte {
    

    // Attributs
    private int id;
    private JLabel image_visible;
    private JLabel image_cache;
    private boolean visible;

    // Constructeurs
    public Carte(int id, JLabel image_visible, JLabel image_cache){
        // Initialisation de tous les attributs de cartes
        this.id = id;
        this.image_visible = image_visible;
        this.image_cache = image_cache;
        this.visible = false;
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
        // On regarde si deux cartes sont identiques en regardant leur ID car les cartes identiques ont un ID qui se suivent, soit 1&2, 3&4... ensembles
        boolean identique = false;
        if(id%2 == 0 && carte.getID() == (this.id - 1)){
            identique = true;
        }
        else{
            if(carte.getID() == (this.id +1)){
                identique = true;
            }
        }
        return identique;
    }

    // Getter/Setter

    public int getID() {
        return id;
    }

    public void setID(int id){
        this.id = id;
    }

    public JLabel getImage_visible() {
        return image_visible;
    }

    public void setImage_visible(JLabel image_visible){
        this.image_visible = image_visible;
    }
}
