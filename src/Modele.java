import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

public class Modele implements Subject
{
    private List<Carte> liste;
	private List<Observer> observers = new ArrayList<>();
	 
	public Modele()
	{		
		this.liste = new ArrayList<Carte>();
    }
	
    public void creerCartes(int nbCartes){
        Carte carte;
        for(int i=0; i<nbCartes/2; i++){
            carte = new Carte(i, i+1, null, null);
            this.liste.add(carte);
            carte = new Carte(i+1, null, null)
        }
    }

	public List<Carte> getList()
	{  
		return this.liste;       
	}  
	
	public Carte getCarte(int index)
	{  
		return this.liste.get(index);      
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
