package com.revature.test;


import java.sql.SQLException;
import java.util.Scanner;

import com.revature.dao.EmployeeDAO;
import com.revature.dao.ReimbursementDAO;
import com.revature.daoimpl.EmployeeDAOImpl;
import com.revature.daoimpl.ReimbursementDAOImpl;
import com.revature.model.Reimbursement;

public class Driver {
	public static void main(String[] args) throws SQLException {
		EmployeeDAO edao = new EmployeeDAOImpl();
		ReimbursementDAO rdao = new ReimbursementDAOImpl();
		System.out.println(edao.getEmployeeByID(1));
		//edao.withdraw(4);
		//System.out.println(rdao.getReimbursement());
		System.out.println(edao.getEmployeeByID(1));
		
		//Scanner scanner = new Scanner(System.in);
		
//		String eventType = "University Courses";
//		int intAmount = 20;
//		int intAmount2 = (int) Math.round(intAmount * 0.80);
//		System.out.println(intAmount2);
		
//		switch (eventType) {
//		case "University Courses":
//			int amt = (int) Math.round(intAmount * 0.80);
//			Reimbursement r = new Reimbursement(1, 1, 12/12/12, 12/12/12, "TEST", amt,
//					"test", eventType, "A", "pending", "pending", "pending", "--", "A", "--");
//			
//			rdao.addReimbursement(r);
//			break;
//		case "Seminars":
//			int amt2 = (int) Math.round(intAmount * 0.60);
//			Reimbursement r2 = new Reimbursement(1, intempID, eventDate, requestDate, location, amt2,
//					description, eventType, gradeType, "pending", "pending", "pending", "--", passingGrade, "--");
//			
//			rdao.addReimbursement(r2);
//			break;
//		case "Certification Preparation Classes":
//			int amt3 = (int) Math.round(intAmount * 0.75);
//			Reimbursement r3 = new Reimbursement(1, intempID, eventDate, requestDate, location, amt3,
//					description, eventType, gradeType, "pending", "pending", "pending", "--", passingGrade, "--");
//			
//			rdao.addReimbursement(r3);
//			break;
//		case "Certification":
//			int amt4 = intAmount;
//			Reimbursement r4 = new Reimbursement(1, intempID, eventDate, requestDate, location, amt4,
//					description, eventType, gradeType, "pending", "pending", "pending", "--", passingGrade, "--");
//			
//			rdao.addReimbursement(r4);
//			
//			break;
//		case "Technical Training":
//			int amt5 = (int) Math.round(intAmount * 0.90);
//			Reimbursement r5 = new Reimbursement(1, intempID, eventDate, requestDate, location, amt5,
//					description, eventType, gradeType, "pending", "pending", "pending", "--", passingGrade, "--");
//			
//			rdao.addReimbursement(r5);
//			break;
//		case "Other":
//			int amt6 = (int) Math.round(intAmount * 0.30);
//			Reimbursement r6 = new Reimbursement(1, intempID, eventDate, requestDate, location, amt6,
//					description, eventType, gradeType, "pending", "pending", "pending", "--", passingGrade, "--");
//			
//			rdao.addReimbursement(r6);
//			break;
//		default:
//			break;
//		}
		
		
	}
}
