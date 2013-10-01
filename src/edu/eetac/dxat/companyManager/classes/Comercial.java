package edu.eetac.dxat.companyManager.classes;

public class Comercial extends Employee {
	private final static double baseSalary = 18000.0; // In €
	private final static double comision = 5; // in %
	private double sells;

	public Comercial(String id) {
		super(id, "<No Name>");
		this.sells = 0.0;
	}

	public void sell(double price) throws Exception {
		if (price <= 0) {
			throw new Exception("The proce can not be a negative value");
		}
		this.sells += price;
	}

	public double getSells() {
		return this.sells;
	}

	public Comercial(String id, String name) {
		super(id, name);
	}

	@Override
	public String toString() {
		return "Comercial [" + super.toString() + " sells=" + this.sells + "]";
	}
	
	@Override
	public double getSalary() {
		return baseSalary+sells*comision/100.0;
	}
}
