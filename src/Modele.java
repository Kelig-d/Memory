import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Modele implements Subject
{
    private List<Carte> liste;
	private List<Observer> observers = new ArrayList<>();

    private int Num_dos;
    private Icon dos = new ImageIcon();

	private List<String> themes = new ArrayList<>(Arrays.asList(new String[]{"theme 1", "theme 2"}));
	private List<String> sizes = new ArrayList<>(Arrays.asList(new String[]{"4x3", "4x4", "5x4", "6x5", "6x6", "7x6"}));

    private int nb_dos = 1;
    private int nb_face_flowers = 13;

	private String firstPlayer;
	private String secondPlayer;
	private String selectedTheme;
	private int[] selectedSize;

	public Modele()
	{		
		this.liste = new ArrayList<Carte>();
        this.Num_dos = ((int) Math.random())%((this.nb_dos));
        dos = new ImageIcon("Images/Dos" + Num_dos +".png");
    }

    public void creerCartes(int nbCartes){
        Carte carte;
		int Num_face = ((int) Math.random())%((this.nb_face_flowers));
        for(int i=0; i<nbCartes; i+=2){
			ImageIcon face = new ImageIcon("Images/Flowers/face" + Num_face%this.nb_face_flowers +".png");
            carte = new Carte(i, i+1, face, dos);
			Image img = face.getImage();
			Image newimg = img.getScaledInstance( carte.getWidth(), carte.getHeight()-100,  java.awt.Image.SCALE_SMOOTH ) ;
			face = new ImageIcon( newimg );
			carte.setImage_visible(face);
            this.liste.add(carte);
            carte = new Carte(i+1, i, face, dos);
			img = face.getImage();
			newimg = img.getScaledInstance( carte.getWidth(), carte.getHeight()-100,  java.awt.Image.SCALE_SMOOTH ) ;
			face = new ImageIcon( newimg );
			carte.setImage_visible(face);
            this.liste.add(carte);
			Num_face+=1;
        }
		Collections.shuffle(this.liste);
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

	public String getFirstPlayer() {
		return firstPlayer;
	}

	public String getSecondPlayer() {
		return secondPlayer;
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
		notifyObservers();
    }

	public void setThemes(List<String> themes) {
		this.themes = themes;
	}

	public void setSizes(List<String> sizes) {
		this.sizes = sizes;
	}

	public void setFirstPlayer(String firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	public void setSecondPlayer(String secondPlayer) {
		this.secondPlayer = secondPlayer;
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
