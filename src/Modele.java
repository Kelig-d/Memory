import java.util.ArrayList;
import java.util.List;

public class Modele implements Subject
{
	private List<Observer> observers = new ArrayList<>();
	 
	public Modele()
	{
		Employe emp;
		
		this.liste = new ArrayList<Employe>();
		
		emp = new Employe(1,"Robert","Dupont","Comptabilit�");
		this.liste.add(emp);
		
		emp = new Employe(2,"Roger","Durand","Comptabilit�");
		this.liste.add(emp);
	
		emp = new Employe(3,"Anne-Marie","Siramis","Secr�tariat");
		this.liste.add(emp);
		
		emp = new Employe(4,"Marc-Andr�","Fouchard","Secr�tariat");
		this.liste.add(emp);
		
		emp = new Employe(5,"Laurent","Chandez","Vente");
		this.liste.add(emp);
	
		emp = new Employe(6,"Fr�d�ric","Caule","Vente");
		this.liste.add(emp);
		
		emp = new Employe(7,"Annabelle","Petitalot","Vente");
		this.liste.add(emp);
		
		emp = new Employe(8,"V�ronique","Durantin","Direction");
		this.liste.add(emp);
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
