package edu.eetac.dxat.companyManager.classes;

public abstract class Employee implements Comparable<Employee> {
	public final static String typeDirector = "Director";
	public final static String typeComercial = "Comercial";
	public final static String typeSecretary = "Secretary";
	
	protected String id;

	public String getId (){
		return id;
	}
	
	public Employee(String id) {
		super ();
		this.id = id;
		// TODO Auto-generated constructor stub
	}

	public int compareTo (Employee e){
		return this.getId().compareTo(e.getId());
	}
	
}
