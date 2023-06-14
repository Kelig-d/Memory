import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Controller {
    private ConfigurationFrame configFrame;
    private FenetreJeu gameFrame;
    private Modele modele;
    private ArrayList<Carte> cardsReturned;

    public Controller(Modele model) {
        this.modele = model;
        this.configFrame = new ConfigurationFrame(this, model);
        this.cardsReturned = new ArrayList<>();

    }

    public void validateParams(String firstplayer, String secondPlayer, String theme, String size){
        String first = firstplayer == "" ? "Joueur 1" : firstplayer;
        String second = secondPlayer == "" ? "Joueur 2" : secondPlayer;
        int[] si = {Integer.parseInt(size.charAt(0)+""),Integer.parseInt(size.charAt(2)+"")};
        modele.setSelectedSize(si);
        modele.setSelectedTheme(theme);
        modele.setNomFirstPlayer(first);
        modele.setNomSecondPlayer(second);
        this.gameFrame = new FenetreJeu(this, this.modele);
        configFrame.setVisible(false);

    }

    public  void doFlip(Carte card){
        flipCard(card);
        if(cardsReturned.stream().count() == 2){
            if(cardsReturned.get(0).getID_paire() == cardsReturned.get(1).getID()){
                new Thread(() ->{
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {

                    }
                    for(Carte c : cardsReturned){
                        c.retirer();
                    }
                    cardsReturned.clear();
                }).start();
                //Ajouter 1 au joueur courant

            }
            else{
                new Thread(() ->{
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    for(Carte c : cardsReturned){
                        c.cacher();
                    }
                    cardsReturned.clear();
                }).start();

            }

        }
    }

    private void flipCard(Carte card){
        card.reveler();
        cardsReturned.add(card);
    }
}
