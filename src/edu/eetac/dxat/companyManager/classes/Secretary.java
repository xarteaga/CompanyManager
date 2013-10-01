package edu.eetac.dxat.companyManager.classes;

public class Secretary extends Employee {
	protected final static double baseSalary = 18000;
	
	public Secretary(String id) {
		super(id, "<No Name>");
	}

	public Secretary(String id, String name) {
		super(id, name);
	}

	@Override
	public String toString() {
		return "Secretary ["+ super.toString() +"]";
	}
	
	@Override
	public double getSalary() {
		return baseSalary;
	}

}
