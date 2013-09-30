package edu.eetac.dxat.companyManager.classes;

import java.util.ArrayList;

public class Company {

	private String idCompany;
	private ArrayList<Director> employees;

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

	@Override
	public String toString() {
		return "Company [employees=" + employees
				+ "]";
	}

}
