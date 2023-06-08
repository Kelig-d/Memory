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
        int[] si = {Integer.parseInt(size.charAt(0)+""),Integer.parseInt(size.charAt(2)+"")};
        modele.setSelectedSize(si);
        modele.setSelectedTheme(theme);
        modele.setFirstPlayer(first);
        modele.setSecondPlayer(second);
        this.gameFrame = new FenetreJeu(this, this.modele);
        configFrame.setVisible(false);

    }
}
