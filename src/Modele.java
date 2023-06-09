import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.List;

import javax.swing.Icon;

public class Modele implements Subject
{
    private List<Carte> liste;
	private List<Observer> observers = new ArrayList<>();

    private int Num_dos;
    private StretchIcon dos;

	private List<String> themes = new ArrayList<>();
	private List<String> sizes = new ArrayList<>();

    private int nb_dos = 1;
    private int nb_face = 21;

	private int remainingCards = 0;

	private Joueur firstPlayer;
	private Joueur secondPlayer;
	private String selectedTheme;
	private int[] selectedSize;

	public Modele()
	{
		this.liste = new ArrayList<Carte>();
        this.Num_dos = ((int) Math.random())%((this.nb_dos));
        dos = new StretchIcon("Images/Dos" + Num_dos +".png", true);
		Properties props = new Properties();
		try(FileInputStream file = new FileInputStream("memory.config")){
			props.load(file);
		}
		catch (FileNotFoundException ex){
			System.out.println("Fichier non trouvé");
		}
		catch (IOException ex){
			System.out.println("Erreur de lecture");
		}
		this.themes.addAll(new ArrayList<String>(Arrays.asList(props.getProperty("themes").split(","))));
		this.sizes.addAll(new ArrayList<String>(Arrays.asList(props.getProperty("sizes").split(","))));

    }

    public void creerCartes(int nbCartes){
        Carte carte;
		int Num_face = ((int) (Math.random()*100))%((this.nb_face));
        for(int i=0; i<nbCartes; i+=2){
			StretchIcon face = new StretchIcon("Images/"+selectedTheme+"/face" + Num_face%this.nb_face +".png", true);
            carte = new Carte(i, i+1, face, dos);
            this.liste.add(carte);
            carte = new Carte(i+1, i, face, dos);
            this.liste.add(carte);
			Num_face+=1;
        }
		Collections.shuffle(this.liste);
    }

	public void creerJoueur(String nom1, String nom2){
		Boolean Premier = (int)(Math.random()*10)%2 == 0;
		firstPlayer = new Joueur(nom1, Premier);
		secondPlayer = new Joueur(nom2, !Premier);
	}


	public List<Carte> getList()
	{  
		return this.liste;       
	}

	public List<String> getThemes() {
		return themes;
	}

	public Carte getCarte(int index)
	{  
		return this.liste.get(index);      
	}

	public List<String> getSizes() {
		return sizes;
	}

	public Joueur getFirstPlayer() {
		return firstPlayer;
	}

	public Joueur getSecondPlayer() {
		return secondPlayer;
	}

	public String getNomFirstPlayer() {
		return firstPlayer.getNom();
	}

	public String getNomSecondPlayer() {
		return secondPlayer.getNom();
	}

	public String getSelectedTheme() {
		return selectedTheme;
	}

	public int[] getSelectedSize() {
		return selectedSize;
	}

	public void setCarte(int index, int id, int id_paire, Icon image_verso, Icon image_recto)
    {  
    	Carte carte = liste.get(index);
		carte.setID(id);
		carte.setID_paire(id_paire);
		carte.setImage_visible(image_verso);
        carte.setImage_cache(image_recto);
        carte.setVisible(false);

    }

	public void setThemes(List<String> themes) {
		this.themes = themes;
	}

	public void setSizes(List<String> sizes) {
		this.sizes = sizes;
	}

	public void setFirstPlayer(Joueur firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	public void setSecondPlayer(Joueur secondPlayer) {
		this.secondPlayer = secondPlayer;
	}

	public void setNomFirstPlayer(String nomFirstPlayer) {
		this.firstPlayer.setNom(nomFirstPlayer);
	}

	public void setNomSecondPlayer(String nomSecondPlayer) {
		this.secondPlayer.setNom(nomSecondPlayer);
	}

	public void setSelectedTheme(String selectedTheme) {
		this.selectedTheme = selectedTheme;
	}

	public void setSelectedSize(int[] selectedSize) {
		this.selectedSize = selectedSize;
	}

	public void registerObserver(Observer o)
	{
		observers.add(o);
	}
 
	public void removeObserver(Observer o) 
	{
		observers.remove(o);
	}
 
	public void notifyObservers() 
	{
		for(Observer o: observers) 
		{
			o.update(this);
		}
	}





}
