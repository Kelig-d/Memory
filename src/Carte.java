import javax.swing.JLabel;

public class Carte {
    

    // Attributs
    private int id;
    private JLabel image_visible;
    private JLabel image_cache;
    private boolean visible;

    // Constructeurs
    public Carte(int id, JLabel image_visible, JLabel image_cache){
        this.id = id;
        this.image_visible = image_visible;
        this.image_cache = image_cache;
        this.visible = false;
    }

    // Méthode
    public void reveler(){
        this.visible = true;
        image_visible.setVisible(visible);
        image_cache.setVisible(!visible);
    }

    public void cacher(){
        this.visible = false;
        image_visible.setVisible(visible);
        image_cache.setVisible(!visible);
    }

    public boolean identique(Carte carte){
        return this.image_visible == carte.getImage_visible();
    }

    // Getter/Setter

    private JLabel getImage_visible() {
        return image_visible;
    }

    private void setImage_visible(JLabel image_visible){
        this.image_visible = image_visible;
    }
}
