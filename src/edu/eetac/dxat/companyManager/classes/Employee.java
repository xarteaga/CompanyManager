package edu.eetac.dxat.companyManager.classes;

public abstract class Employee implements Comparable<Employee> {

	protected String id;
	private String name;

	public String getId() {
		return id;
	}

	public String getName() {
		return this.name;
	}

	public Employee(String id, String name) {
		super();
		this.id = id;
		this.name = name;
		// TODO Auto-generated constructor stub
	}

	public abstract double getSalary();

	public int compareTo(Employee e) {
		return this.getId().compareTo(e.getId());
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + " name=" + name + " salary="
				+ this.getSalary() + "]";
	}

}
