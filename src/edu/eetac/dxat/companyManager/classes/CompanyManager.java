package edu.eetac.dxat.companyManager.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import edu.eetac.dxat.companyManager.interfaces.CompanyManagement;

public class CompanyManager implements CompanyManagement {
	
	private HashMap <String, Company> companies;

	
	
	public CompanyManager() {
		super();
		this.companies = new HashMap <String, Company>();
	}

	@Override
	public void addCompany(String idCompany) throws Exception {
		if (companies.containsKey(idCompany)){
			throw new Exception("Company Id already exist");
		}
		companies.put(idCompany, new Company(idCompany));
	}

	@Override
	public void delCompany(String idCompany) throws Exception {
		if (!companies.containsKey(idCompany)){
			throw new Exception("Company Id does not exist");
		}
		companies.remove(idCompany);
	}

	@Override
	public void addEmployee(String idCompany, String idDirector, Employee employee) throws Exception {
		
		if (!companies.containsKey(idCompany)){
			throw new Exception("Company does not exist");
		}
		
		Company c = companies.get(idCompany);
		c.addEmployee(idDirector, employee);
		
	}

	@Override
	public void delEmployee(String idCompany, String idEmployee) throws Exception {
		companies.get(idCompany).delEmployee(idEmployee);
	}

	@Override
	public List<Company> listCompaniesById() {
		List<Company> companies = new ArrayList<Company>(this.companies.values());
		Collections.sort(companies);
		
		return companies;
	}

	@Override
	public List<Employee> listEmployeesByName(String idCompany) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> listEmployeesBySalary(String idCompanyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> listSubDirectorByName(String idEmployeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addSell(String idCompany, String idEmployee, double sellValue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "CompanyManager [companies=" + companies + "]";
	}

}
