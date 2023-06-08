import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Modele implements Subject
{
    private List<Carte> liste;
	private List<Observer> observers = new ArrayList<>();

    private double Num_dos;
    private JLabel dos = new JLabel();

	private List<String> themes = new ArrayList<>(Arrays.asList(new String[]{"theme 1", "theme 2"}));
	private List<String> sizes = new ArrayList<>(Arrays.asList(new String[]{"4x3", "4x4", "5x4", "6x5", "6x6", "7x6"}));

    private int nb_dos = 1;
    private int nb_face = 0;

	public Modele()
	{		
		this.liste = new ArrayList<Carte>();
        this.Num_dos = (Math.random())%((double)(this.nb_dos));
    }

    public void creerCartes(int nbCartes){
        Carte carte;
        for(int i=0; i<nbCartes; i+=2){
            // A compléter
            dos.setIcon(new ImageIcon("Images/Dos" + Num_dos +"png"));
            carte = new Carte(i, i+1, null, dos);
            this.liste.add(carte);
            // A compléter
            carte = new Carte(i+1, i, null, dos);
            this.liste.add(carte);
        }
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
       
    public void setCarte(int index,int id, int id_paire, JLabel image_verso, JLabel image_recto) 
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
