import java.awt.*;

public class Joueur {

    //attributs
    private String nom;
    private int score;
    private Boolean jouer;
    
    //Constructeur
    public Joueur(String nom, Boolean jouer){
        this.nom = nom;
        this.score = 0;
        this.jouer= jouer;

    }

    //méthode
    public void incrementerScore(){
        this.score += 1;
    }

    public void changerJoueur(){
        this.jouer = !(this.jouer);
    }

    //setter
    public void setNom(String nom){
        this.nom = nom;
    }

    public void setScore(int score){
        this.score = score;
    }

    public void setJouer(Boolean jouer){
        this.jouer = jouer;
    }

    //getter
    public String getNom(){
        return this.nom;
    }

    public int getScore(){
        return this.score;
    }

    public Boolean getJouer(){
        return this.jouer;
    }
}
