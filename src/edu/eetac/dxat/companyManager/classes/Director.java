package edu.eetac.dxat.companyManager.classes;

import java.util.ArrayList;

public class Director extends Employee {
	private final static double baseSalary = 28000.0;
	private final static double comision = 5; // in %

	private ArrayList <Employee> employees;
	
	public boolean existEmployee(String idEmployee){

		for (Employee e:employees){
			if (e.getId()==idEmployee){
				return true;
			} else if (e.getClass()==Director.class){
				if (((Director)e).existEmployee(idEmployee)){
					return true;
				}
			}
		}
		return false;
	}
	
	public Director (String id) {
		super(id, "<No Name>");
		employees = new ArrayList<Employee>();
	}
	
	public Director (String id, String name) {
		super(id, name);
	}
	
	public void addEmployee (Employee employee) throws Exception {
		if (this.existEmployee(employee.getId())){
			throw new Exception("The employee " + employee.getId() + "already exists under " + this.id);
		}
		this.employees.add(employee);
	}
	
	public void addEmployee (String idDirector, Employee employee) throws Exception {
		if (this.existEmployee(employee.getId())){
			throw new Exception("The employee " + employee.getId() + "already exists under " + this.id);
		} else if (!this.existEmployee(idDirector)){
			throw new Exception("The director " + idDirector + "does not exist under " + this.id);
		} else if (idDirector == this.id){
			this.employees.add(employee);
			return;
		}
				
		for (Employee e:employees){
			if (e.getClass()==Director.class){
				Director d = (Director)e;
				if (d.getId()==idDirector){
					d.addEmployee(employee);
					return;
				} else if(d.existEmployee(idDirector)){
					d.addEmployee(idDirector, employee);
					return;
				}
			}
		}
		throw new Exception("The employee " + employee.getId() + " can not be added");
	}
	
	public void delEmployee (String idEmployee) throws Exception{
	
		for (Employee e:employees){
			if (e.getId()==idEmployee){
				this.employees.remove(e);
				return;
			}
		}
		throw new Exception("Employee does not exist in the director: " + id);

	}

	@Override
	public String toString() {
		return "Director [" + super.toString() + " employees=" + employees + "]";
	}

	public double getSubsEarns (){
		double sum = 0.0;
		
		for(Employee e:employees){
			sum += e.getSalary();
			if (e.getClass()==Director.class){
				sum += ((Director)e).getSubsEarns();
			}
		}
		
		return sum;
	}
	
	@Override
	public double getSalary() {
		return baseSalary + this.getSubsEarns()*comision/100.0;
	}

}
