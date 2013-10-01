package edu.eetac.dxat.companyManager.test;

import java.util.ArrayList;

import edu.eetac.dxat.companyManager.classes.Comercial;
import edu.eetac.dxat.companyManager.classes.Company;
import edu.eetac.dxat.companyManager.classes.CompanyManager;
import edu.eetac.dxat.companyManager.classes.Director;
import edu.eetac.dxat.companyManager.classes.Secretary;

public class testCompany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello wolrd!!");
		CompanyManager myManager = new CompanyManager();
		
		try {
			myManager.addCompany("myCompany");
			/*myManager.addCompany("PepeGoterasHotilio");
			myManager.addCompany("PollosHermanos");
			myManager.addCompany("EspañaEsLaMejor");
			myManager.addCompany("EstaEslaCausaDe");
			myManager.addCompany("HoyMeHanPreguntadoPorTi");
			myManager.addCompany("MañanaNoEsHoy");*/
		} catch (Exception e) {
			System.out.println(e);
			return;
		}

		try {
			myManager.addEmployee("myCompany", "Company", new Director("Jesus"));
			myManager.addEmployee("myCompany", "Company", new Director("Xavier"));
			myManager.addEmployee("myCompany", "Xavier", new Director("Marco"));
			myManager.addEmployee("myCompany", "Jesus", new Comercial("Gerard"));
			myManager.addEmployee("myCompany", "Marco", new Secretary("Alex"));
			myManager.addEmployee("myCompany", "Xavier", new Secretary("Cristian"));
			//myManager.delEmployee("myCompany", "Toni");
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
