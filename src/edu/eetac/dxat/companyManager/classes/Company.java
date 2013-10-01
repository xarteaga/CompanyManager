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
			}
		}
		return false;
	}

	public void addEmployee(String idDirector, String idEmployee, String type)
			throws Exception {

		if (this.existEmployee(idEmployee)) {
			throw new Exception("Employee has beeen already added");
		}

		if (type == "Director") {
			employees.add(new Director(idEmployee));
		} else {
			if (!this.existEmployee(idDirector)) {
				throw new Exception("Director does not exist");
			}
			for (Director d : employees) {
				if (d.getId() == idDirector) {
					d.addEmployee(idEmployee, type);
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
	
}
