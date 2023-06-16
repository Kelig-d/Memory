import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Controller {
    public ConfigurationFrame configFrame;
    private FenetreJeu gameFrame;
    private Modele modele;
    private ArrayList<Carte> cardsReturned;

    private int remainingCards = 0;
    public Controller(Modele model) {
        this.modele = model;
        this.configFrame = new ConfigurationFrame(this, model);
        this.cardsReturned = new ArrayList<>();

    }

    public void validateParams(String firstplayer, String secondPlayer, String theme, String size){
        String first = firstplayer.isEmpty() ? "Joueur 1" : firstplayer;
        String second = secondPlayer.isEmpty() ? "Joueur 2" : secondPlayer;
        int[] si = {Integer.parseInt(size.charAt(0)+""),Integer.parseInt(size.charAt(2)+"")};
        modele.setSelectedSize(si);
        remainingCards = (si[0]*si[1]/2);
        modele.setSelectedTheme(theme);
        modele.creerJoueur(first,second);
        modele.creerCartes(modele.getSelectedSize()[0] * modele.getSelectedSize()[1]);
        this.gameFrame = new FenetreJeu(this, this.modele);
        modele.registerObserver(gameFrame);
        configFrame.setVisible(false);

    }

    public  void doFlip(Carte card){
        if(cardsReturned.stream().count() <2){
            if(!cardsReturned.contains(card)) flipCard(card);
        }
        if(cardsReturned.stream().count() == 2){
            changeButtonState();
            if(cardsReturned.get(0).identique(cardsReturned.get(1))){
                new Thread(() ->{
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {

                    }
                    for(Carte c : cardsReturned){
                        c.retirer();
                    }
                    cardsReturned.clear();
                    remainingCards-=1;

                    if(remainingCards==0){
                        endGame();
                    }
                    changeButtonState();
                }).start();
                if(modele.getFirstPlayer().getJouer()) modele.getFirstPlayer().incrementerScore();
                else modele.getSecondPlayer().incrementerScore();
                gameFrame.incrementScorePlayers();
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
                    modele.getFirstPlayer().changerJoueur();
                    modele.getSecondPlayer().changerJoueur();
                    cardsReturned.clear();
                    changeButtonState();
                    //modele.notifyObservers();
                }).start();


            }

        }

    }

    private void flipCard(Carte card){
        card.reveler();
        cardsReturned.add(card);
    }

    public void changeButtonState(){
        for(Carte c:modele.getList()){
            c.setEnabled(!c.isEnabled());
            c.setDisabledIcon(c.getIcon());
        }
    }
    public void endGame(){
        JPanel winPanel = new JPanel();
        winPanel.setMinimumSize(new Dimension(250,20));
        JLabel winText = new JLabel("Partie terminée");
        winText.setMinimumSize(new Dimension(250,20));
        JLabel playerWin = new JLabel();
        if(modele.getFirstPlayer().getScore()>modele.getSecondPlayer().getScore()) playerWin.setText(modele.getNomFirstPlayer()+" a gagné !");
        else playerWin.setText(modele.getNomSecondPlayer()+" a gagné !");
        winPanel.setLayout(new BorderLayout());
        winPanel.add(winText, BorderLayout.NORTH);
        winPanel.add(playerWin, BorderLayout.CENTER);
        gameFrame.setContentPane(winPanel);
        gameFrame.setSize(gameFrame.getWidth()+1,gameFrame.getHeight()+1);
    }

    public void quitGame(){
        configFrame.setVisible(true);
        gameFrame.dispose();
    }
}
