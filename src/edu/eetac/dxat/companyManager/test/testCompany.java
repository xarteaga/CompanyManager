package edu.eetac.dxat.companyManager.test;

import edu.eetac.dxat.companyManager.classes.CompanyManager;
import edu.eetac.dxat.companyManager.classes.Employee;

public class testCompany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello wolrd!!");
		CompanyManager myManager = new CompanyManager();
		
		try {
			myManager.addCompany("myCompany");
		} catch (Exception e) {
			System.out.println(e);
			return;
		}

		try {
			myManager.addEmployee("myCompany", null, "Jesus", Employee.typeDirector);
			myManager.addEmployee("myCompany", null, "Xavier", Employee.typeDirector);
			myManager.addEmployee("myCompany", "Jesus", "Gerard", Employee.typeComercial);
			myManager.addEmployee("myCompany", "Xavier", "Alex", Employee.typeSecretary);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		System.out.println(myManager);
	}

}
