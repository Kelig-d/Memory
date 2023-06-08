public class Controller {
    private ConfigurationFrame configFrame;
    private FenetreJeu gameFrame;
    private Modele modele;
    public Controller(Modele model) {
        this.modele = model;
        this.configFrame = new ConfigurationFrame(this, model);

    }

    public void validateParams(String firstplayer, String secondPlayer, String theme, String size){
        String first = firstplayer == "" ? "Joueur 1" : firstplayer;
        String second = secondPlayer == "" ? "Joueur 2" : secondPlayer;
        int[] si = {size.charAt(0), size.charAt(2)};
        this.gameFrame = new FenetreJeu(first, second, theme, si, this, this.modele);
        configFrame.dispose();

    }
}
