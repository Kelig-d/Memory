import java.util.ArrayList;
import java.util.List;

public class Modele implements Subject
{
    private List<Carte> cartes = new ArrayList<>()
	private List<Observer> observers = new ArrayList<>();
	 
	public Modele()
	{
    }
	
	public List<Employe> getList()
	{  
		return this.liste;       
	}  
	
	public Employe getEmploye(int index)
	{  
		return this.liste.get(index);      
	}   
       
    public void setEmploye(int index,String firstname, String name,String department) 
    {  
    	Employe emp = liste.get(index);
		emp.setFirstName(firstname);
		emp.setName(name);
		emp.setDepartment(department);
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
