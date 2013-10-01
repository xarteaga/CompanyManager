package edu.eetac.dxat.companyManager.classes;

import java.util.ArrayList;

public class Director extends Employee {

	private ArrayList <Employee> employees;
	
	public boolean existEmployee(String idEmployee){

		for (Employee e:employees){
			if (e.getId()==idEmployee){
				return true;
			}
		}
		return false;
	}
	
	public Director (String id) {
		super(id);
		employees = new ArrayList<Employee>();
	}
	
	public void addEmployee (String id, String type) throws Exception{
		if (type == "Comercial"){
			this.employees.add(new Comercial(id));
		} else if (type == "Secretary"){
			this.employees.add(new Secretary(id));
		} else {
			throw new Exception("Is not possible add this kind of employee: " + type);
		}
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
		return "Director [id=" + super.id + " employees=" + employees + "]";
	}

}
