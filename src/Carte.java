import javax.swing.ImageIcon;

public class Carte {
    

    // Attributs
    private int id;
    private ImageIcon image_visible;
    private ImageIcon image_cache;
    private boolean visible;

    // Constructeurs
    public Carte(int id, ImageIcon image_visible, ImageIcon image_cache){
        this.id = id;
        this.image_visible = image_visible;
        this.image_cache = image_cache;
        this.visible = false;
    }

    // Méthode
    public void reveler(){
        this.visible = true;
    }

    public void cacher(){
        this.visible = false;
    }

    public boolean identique(Carte carte){
        return this.image_visible == carte.getImage_visible();
    }

    // Getter/Setter

    private ImageIcon getImage_visible() {
        return image_visible;
    }

    private void setImage_visible(ImageIcon image_visible){
        this.image_visible = image_visible;
    }
}
