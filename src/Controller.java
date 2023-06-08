public class Controller {
    private ConfigurationFrame configFrame;
    private FenetreJeu gameFrame;
    private Modele modele;
    public Controller(Modele model) {
        this.modele = model;
        this.configFrame = new ConfigurationFrame(this, model);
        this.gameFrame = new FenetreJeu();

    }

    public void validateParams(String firstplayer, String secondPlayer, String theme, int size){

    }
}
