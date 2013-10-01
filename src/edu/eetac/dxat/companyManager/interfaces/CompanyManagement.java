package edu.eetac.dxat.companyManager.interfaces;

import java.util.List;

import edu.eetac.dxat.companyManager.classes.*;

public interface CompanyManagement {

	/* ADD/DELETE COmpanies */
	public void addCompany(String idCompany) throws Exception;

	public void delCompany(String idCompany) throws Exception;

	/* ADD/DELETE Employees */
	public void addEmployee(String idCompany, String idDirector,
			Employee employee) throws Exception;

	public void delEmployee(String idCompany, String idEmployee)
			throws Exception;

	/* Listings */
	public List<Company> listCompaniesById();

	public List<Employee> listEmployeesByName(String idCompany);

	public List<Employee> listEmployeesBySalary(String idCompanyId);

	public List<Employee> listSubDirectorByName(String idEmployeeId);

	/* Sells */
	public void addSell(String idCompany, String idEmployee, double sellValue);

}
