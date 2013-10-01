package edu.eetac.dxat.companyManager.classes;

import java.util.ArrayList;

public class Company implements Comparable <Company> {

	private String idCompany;
	private ArrayList<Director> employees;

	public String getId (){
		return idCompany;
	}
	
	public Company(String idCompany) {
		this.idCompany = idCompany;
		this.employees = new ArrayList<Director>();
	}

	public boolean existEmployee(String idEmployee) {

		for (Director d : employees) {
			if (d.getId() == idEmployee) {
				return true;
			} else if (d.existEmployee(idEmployee)){
				return true;
			}
		}
		return false;
	}

	public void addEmployee(String idDirector, Employee employee)
			throws Exception {

		if (this.existEmployee(employee.getId())) {
			throw new Exception("Employee has beeen already added");
		}

		if (idDirector == "Company") {
			employees.add((Director)employee);
		} else {
			if (!this.existEmployee(idDirector)) {
				throw new Exception("Director does not exist");
			}
			for (Director d : employees) {
				if (d.getId() == idDirector) {
					d.addEmployee(employee);
					return;
				} else if (d.existEmployee(idDirector)){
					d.addEmployee(idDirector, employee);
					return;
				}
			}
		}

	}

	public void delEmployee (String idEmployee) throws Exception {
		for (Director d:employees){
			if (d.getId()==idEmployee){
				employees.remove(d);
				return;
			} else if (d.existEmployee(idEmployee)){
				d.delEmployee(idEmployee);
				return;
			}
		}
		
		throw new Exception("The employee with id " + idEmployee + " does not exist in the company " + this.idCompany);
	}
	
	@Override
	public String toString() {
		return "Company [employees=" + employees + "]";
	}

	public int compareTo (Company c){
		String str = this.getId().toLowerCase();
		return str.compareTo(c.getId().toLowerCase());
	}
	
	public double getEarns (){
		double sum = 0.0;
		
		for(Director d:employees){
			sum += d.getSalary();
			sum += d.getSubsEarns();
		}
		
		return sum;
	}
	
}
