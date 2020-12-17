package com.revature.controller;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.ReimbursementDAO;
import com.revature.daoimpl.EmployeeDAOImpl;
import com.revature.daoimpl.ReimbursementDAOImpl;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.service.ReimbursementService;

public class ReimbursementController {
	
	static ReimbursementService rServ = new ReimbursementService();
	static ReimbursementDAO rdao = new ReimbursementDAOImpl();
	static EmployeeDAO edao = new EmployeeDAOImpl();
	
	public static String addReimbursement(HttpServletRequest req) throws SQLException {
		if(!req.getMethod().equals("POST")) {
			return "resources/html/reimbursement.html";
			
		}

		//int formID = Integer.parseInt(req.getParameter("formID"));
		String empID = req.getParameter("empID");
		Integer intempID = Integer.valueOf(empID);
		String eventDate = req.getParameter("eventDate");
		//Date dateeventDate = Date.valueOf(eventDate);
		String requestDate = req.getParameter("requestDate");
		String location = req.getParameter("location");
		String amount = req.getParameter("amount");
		String description = req.getParameter("description");
		String eventType = req.getParameter("eventType");
		String gradeType = req.getParameter("gradeType");
		Double intAmount = Double.valueOf(amount);
		String passingGrade = req.getParameter("passingGrade");
		String urgent = req.getParameter("urgent");
		//String status = Boolean.parseBoolean(req.getParameter("status"));
		
		Reimbursement r = new Reimbursement(1, intempID, eventDate, requestDate, location, intAmount,
				description, eventType, gradeType, "pending", "pending", "pending", "--", passingGrade, urgent);
		
		rdao.addReimbursement(r);

		return "sucessreimbursement.change";
	}
//	
//	public static String addReimbursement(HttpServletRequest req) throws SQLException {
//		if(!req.getMethod().equals("POST")) {
//			return "resources/html/reimbursement.html";
//			
//		}
//
//		//int formID = Integer.parseInt(req.getParameter("formID"));
//		String empID = req.getParameter("empID");
//		Integer intempID = Integer.valueOf(empID);
//		String eventDate = req.getParameter("eventDate");
//		//Date dateeventDate = Date.valueOf(eventDate);
//		String requestDate = req.getParameter("requestDate");
//		String location = req.getParameter("location");
//		//String amount = req.getParameter("amount");
//		String description = req.getParameter("description");
//		String eventType = req.getParameter("eventType");
//		String gradeType = req.getParameter("gradeType");
//		//Integer intAmount = Integer.valueOf(amount);
//		String passingGrade = req.getParameter("passingGrade");
//		//String status = Boolean.parseBoolean(req.getParameter("status"));
//		
//		switch (eventType) {
//		case "UniversityCourses":
//			String amount = req.getParameter("amount");
//			Integer intAmount = (Integer.valueOf(amount)) * (int) (0.80);
//			Reimbursement r = new Reimbursement(1, intempID, eventDate, requestDate, location, intAmount,
//					description, eventType, gradeType, "pending", "pending", "pending", "--", passingGrade, "--");
//			
//			rdao.addReimbursement(r);
//			break;
//		case "Seminars":
//			String amount2 = req.getParameter("amount");
//			Integer intAmount2 = (Integer.valueOf(amount2)) * (int) (0.60);
//			Reimbursement r2 = new Reimbursement(1, intempID, eventDate, requestDate, location, intAmount2,
//					description, eventType, gradeType, "pending", "pending", "pending", "--", passingGrade, "--");
//			
//			rdao.addReimbursement(r2);
//			break;
//		case "Certification Preparation Classes":
//			String amount3 = req.getParameter("amount");
//			Integer intAmount3 = (Integer.valueOf(amount3)) * (int) (0.75);
//			Reimbursement r3 = new Reimbursement(1, intempID, eventDate, requestDate, location, intAmount3,
//					description, eventType, gradeType, "pending", "pending", "pending", "--", passingGrade, "--");
//			
//			rdao.addReimbursement(r3);
//			break;
//		case "Certification":
//			String amount4 = req.getParameter("amount");
//			Integer intAmount4 = (Integer.valueOf(amount4));
//			Reimbursement r4 = new Reimbursement(1, intempID, eventDate, requestDate, location, intAmount4,
//					description, eventType, gradeType, "pending", "pending", "pending", "--", passingGrade, "--");
//			
//			rdao.addReimbursement(r4);
//			
//			break;
//		case "Technical Training":
//			String amount5 = req.getParameter("amount");
//			Integer intAmount5 = (Integer.valueOf(amount5)) * (int)  (0.90);
//			Reimbursement r5 = new Reimbursement(1, intempID, eventDate, requestDate, location, intAmount5,
//					description, eventType, gradeType, "pending", "pending", "pending", "--", passingGrade, "--");
//			
//			rdao.addReimbursement(r5);
//			break;
//		case "Other":
//			String amount6 = req.getParameter("amount");
//			Integer intAmount6 = (Integer.valueOf(amount6)) * (int) (0.30);
//			Reimbursement r6 = new Reimbursement(1, intempID, eventDate, requestDate, location, intAmount6,
//					description, eventType, gradeType, "pending", "pending", "pending", "--", passingGrade, "--");
//			
//			rdao.addReimbursement(r6);
//			break;
//		default:
//			break;
//		}
//
//		return "sucessreimbursement.change";
//	}
	

	 public static String getReimbursement(HttpServletRequest req) throws SQLException {
		// if(!req.getMethod().equals("POST")) {
		//		return "resources/html/viewreimbursement.html";
				
		//	}
		 //Reimbursement reim = (Reimbursement) req.getSession().getAttribute("currentreim");
		// res.getWriter().write(new ObjectMapper().writeValueAsString(reim));
		 List<Reimbursement> rList;
		 rList = rdao.getReimbursement();
		 String rStringList = rList.toString();
		 return rStringList;
		  
	}
	
	 public static String withdrawEmpBalance(HttpServletRequest req) throws SQLException{
		 if(!req.getMethod().equals("POST")) {
				return "resources/html/reimbursement.html";
				
		 }
		 String empID = req.getParameter("empID");
		 Integer intempID = Integer.valueOf(empID);
		 String amount = req.getParameter("amount");
		 Double intAmount = Double.valueOf(amount);
		 
		 edao.withdraw(intAmount, intempID);
		 return "sucessreimbursement.change";
	 }
	 
	 public static String updateReimbursementStatus(HttpServletRequest req) throws SQLException{
		 if(!req.getMethod().equals("POST")) {
				return "resources/html/managerUpdateForm.html";
				
		 }
		 String reID = req.getParameter("reID");
		 Integer intreID = Integer.valueOf(reID);
		 String status = req.getParameter("status");
		 rdao.updateReimbursementStatus(status, intreID);
		 
		if(status.equalsIgnoreCase("denied")) {
			 edao.deposit(intreID);
			 return "reupdatesuccess.html";
		 }
		 return "reupdatesuccess.html";
	 }
	 public static String updateReimbursementStatus2(HttpServletRequest req) throws SQLException{
		 if(!req.getMethod().equals("POST")) {
				return "resources/html/deptheadUpdateForm.html";
				
		 }
		 String reID = req.getParameter("reID");
		 Integer intreID = Integer.valueOf(reID);
		 String status = req.getParameter("status");
		 rdao.updateReimbursementStatus2(status, intreID);
		 
		if(status.equalsIgnoreCase("denied")) {
			 edao.deposit(intreID);
			 return "reupdatesuccessdepth.html";
		 }
		 return "reupdatesuccessdepth.html";
	 }
	 public static String updateReimbursementStatus3(HttpServletRequest req) throws SQLException{
		 if(!req.getMethod().equals("POST")) {
				return "resources/html/deptheadUpdateForm.html";
				
		 }
		 String reID = req.getParameter("reID");
		 Integer intreID = Integer.valueOf(reID);
		 String status = req.getParameter("status");
		 rdao.updateReimbursementStatus3(status, intreID);
		 
		if(status.equalsIgnoreCase("denied")) {
			 edao.deposit(intreID);
			 return "reupdatesuccessbenco.html";
		 }
		 return "reupdatesuccessbenco.html";
	 }
	 public static String updateReimbursementGrade(HttpServletRequest req) throws SQLException{
		 if(!req.getMethod().equals("POST")) {
				return "resources/html/updatereimbursement.html";
				
		 }
		 String reID = req.getParameter("reID");
		 Integer intreID = Integer.valueOf(reID);
		 String grade = req.getParameter("grade");
		 if (grade == null) {
			 return "reupdateemp.html";
		 }if(grade != null) {
			 rdao.updateReimbursementGrade(grade, intreID);
		 }
		 return "reupdateemp.html";
		 
	 }
	 public static String updateReimbursementDescription(HttpServletRequest req) throws SQLException{
		 if(!req.getMethod().equals("POST")) {
				return "resources/html/updatereimbursement.html";
				
		 }
		 String reID = req.getParameter("reID");
		 Integer intreID = Integer.valueOf(reID);
		 String description = req.getParameter("description");
		 if (description == null) {
			 return "reupdateemp.html";
		 }if(description != null) {
			 rdao.updateReimbursementDescription(description, intreID);
		 }
		 return "reupdateemp.html";
			 
	 }
	 public static String updateReimbursementAmount(HttpServletRequest req) throws SQLException{
		 if(!req.getMethod().equals("POST")) {
				return "resources/html/updatereimbursement.html";
				
		 }
		 String reID = req.getParameter("reID");
		 Integer intreID = Integer.valueOf(reID);
		 String amount = req.getParameter("amount");
		 if (amount==null) {
			 System.out.println("nothing");
		 }else {
		 Double intAmount = Double.valueOf(amount);
		 rdao.updateReimbursementAmount(intAmount, intreID);
		 return "reupdatesuccessbenco.html";
		 }
		 return "reupdatesuccessbenco.html";
			 
	 }
	 public static void viewReimbursement(HttpServletRequest req, HttpServletResponse res) throws SQLException, JsonGenerationException, JsonMappingException, IOException {
			List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
			reimbursements = rdao.getReimbursement();
			System.out.println(reimbursements);
			System.out.println("getting reimbursements");
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(out, reimbursements);
			byte [] data = out.toByteArray();
			System.out.println(new String(data));
			res.getWriter().write(new String(data));
		}

}
