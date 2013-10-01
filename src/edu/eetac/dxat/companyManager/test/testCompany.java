package edu.eetac.dxat.companyManager.test;

import java.util.ArrayList;

import edu.eetac.dxat.companyManager.classes.Company;
import edu.eetac.dxat.companyManager.classes.CompanyManager;
import edu.eetac.dxat.companyManager.classes.Employee;

public class testCompany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello wolrd!!");
		CompanyManager myManager = new CompanyManager();
		
		try {
			myManager.addCompany("myCompany");
			myManager.addCompany("EADS");
			myManager.addCompany("PepeGoterasHotilio");
			myManager.addCompany("PollosHermanos");
			myManager.addCompany("EspañaEsLaMejor");
			myManager.addCompany("EstaEslaCausaDe");
			myManager.addCompany("HoyMeHanPreguntadoPorTi");
			myManager.addCompany("MañanaNoEsHoy");
		} catch (Exception e) {
			System.out.println(e);
			return;
		}

		try {
			myManager.addEmployee("myCompany", null, "Jesus", Employee.typeDirector);
			myManager.addEmployee("myCompany", null, "Xavier", Employee.typeDirector);
			myManager.addEmployee("myCompany", "Jesus", "Gerard", Employee.typeComercial);
			myManager.addEmployee("myCompany", "Xavier", "Alex", Employee.typeSecretary);
			myManager.delEmployee("myCompany", "Toni");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		System.out.println(myManager);
		
		ArrayList<Company> companies = (ArrayList<Company>) myManager.listCompaniesById();
		System.out.println("My companies:");
		for(Company c:companies){
			System.out.println("\t" + c.getId());
		}
		
		
	}

}
