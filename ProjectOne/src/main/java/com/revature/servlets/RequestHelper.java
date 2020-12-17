package com.revature.servlets;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.EmployeeController;
import com.revature.controller.LoginController;
import com.revature.controller.ManagerController;
import com.revature.controller.ManagerLoginController;
import com.revature.controller.ManagerProfileController;
import com.revature.controller.ProfileController;
import com.revature.controller.ReimbursementController;

public class RequestHelper {

	public static String process(HttpServletRequest req) throws SQLException {
		System.out.println(req.getRequestURI());
		switch (req.getRequestURI()) {
		case "/ProjectOne/login.change":
			System.out.println("in login.change rhelper");
			return LoginController.login(req);

		case "/ProjectOne/managerlogin.change":
			System.out.println("in managerlogin.change rhelper");
			return ManagerLoginController.login(req);
			
		case "/ProjectOne/deptheadlogin.change":
			System.out.println("in depthead login.change rhelper");
			return ManagerLoginController.login2(req);
			
		case "/ProjectOne/bencologin.change":
			System.out.println("in benco login.change rhelper");
			return ManagerLoginController.login3(req);

		case "/ProjectOne/managerhomepage.change":
			System.out.println("in managerhomepage.change rhelper");
			return ManagerProfileController.profile(req);
			
		case "/ProjectOne/deptheadhomepage.change":
			System.out.println("in managerhomepage.change rhelper");
			return ManagerProfileController.profile2(req);
			
		case "/ProjectOne/bencohomepage.change":
			System.out.println("in managerhomepage.change rhelper");
			return ManagerProfileController.profile3(req);

		case "/ProjectOne/profile.change":
			System.out.println("in profile.change rhelper");
			return ProfileController.profile(req);

		case "/ProjectOne/reimbursement.change":
			System.out.println("in reimbursement.change rhelper");
			return "resources/html/reimbursement.html";
			
		case "/ProjectOne/successreimbursement.change":
			System.out.println("in success reimbursement.change rhelper");
			ReimbursementController.withdrawEmpBalance(req);
			ReimbursementController.addReimbursement(req);
			return "resources/html/successreimbursement.html";
			
		case "/ProjectOne/updateEmployeeProfile.change":
			System.out.println("in update employee profile.change rhelper");
			return "resources/html/updateEmployeeProfile.html";
	
		case "/ProjectOne/updatesuccess.change":
			System.out.println("in updatesuccess.change rhelper");
			EmployeeController.updateEmployee(req);
			return "/resources/html/updatesuccess.html";
			
		case "/ProjectOne/managerUpdateForm.change":
			System.out.println("in managerupdateform.change rhelper");
			return "resources/html/managerUpdateForm.html";
		
		case "/ProjectOne/reupdatesuccess.change":
			System.out.println("in success reupdatesuccess.change rhelper");
			ReimbursementController.updateReimbursementStatus(req);
			return "/resources/html/reupdatesuccess.html";
			
		case "/ProjectOne/updatereimbursement.change":
			System.out.println("in update reimbursement.change rhelper");
			return "/resources/html/updatereimbursement.html";
			
		case "/ProjectOne/reupdateemp.change":
			System.out.println("In re update emp.change");
			ReimbursementController.updateReimbursementGrade(req);
			ReimbursementController.updateReimbursementDescription(req);
			return "/resources/html/reupdateemp.html";
		
		case "/ProjectOne/deptheadUpdateForm.change":
			System.out.println("In depthead update form");
			return "/resources/html/deptheadUpdateForm.html";
			
		case "/ProjectOne/reupdatesuccessdepth.change":
			System.out.println("In re upate success depthead.change");
			ReimbursementController.updateReimbursementStatus2(req);
			return "/resources/html/reupdatesuccessdepth.html";
			
		case "/ProjectOne/bencoUpdaetForm.change":
			System.out.println("In benco update form");
			return "/resources/html/bencoUpdateForm.html";
			
		case "/ProjectOne/reupdatesuccessbenco.change":
			ReimbursementController.updateReimbursementStatus3(req);
			ReimbursementController.updateReimbursementAmount(req);
			return "/resources/html/reupdatesuccessbenco.html";
			
		default:
			System.out.println("in default case");
			return "resources/html/unsuccessfullogin.html";
		}

	}

}
