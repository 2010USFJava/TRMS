package com.revature.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controller.EmployeeController;
import com.revature.controller.ManagerController;
import com.revature.controller.ReimbursementController;
import com.revature.model.Employee;

public class JSONRequestHelper {

	public static void process(HttpServletRequest req, HttpServletResponse res)
			throws JsonProcessingException, IOException, SQLException {
		switch (req.getRequestURI()) {

//		case "/ProjectOne/getsession.json":
//			EmployeeController.getSessionEmployee(req, res);
//			break;


		case "/ProjectOne/getsession.json":
			System.out.println("in getsession.json request helper ");
			EmployeeController.getSessionEmp(req, res);
			break;
			
		case "/ProjectOne/viewemployees.json":
			System.out.println("in view employees request helper");
			EmployeeController.viewEmployee(req, res);
			break;
			
		case "/ProjectOne/viewreimbursements.json":
			System.out.println("in view reimbursements request helper");
			ReimbursementController.viewReimbursement(req, res);
			break;

		case "/ProjectOne/employeeview.json":
			System.out.println("in view reimbursements request helper");
			EmployeeController.viewReimbursementById(req, res);
			break;
			
		case "/ProjectOne/getmsession.json":
			ManagerController.mangetSession(req, res);
			break;

		default:
			Employee emp = new Employee("?", "?", "?", "?", 0, 0, "?");
			res.getWriter().write(new ObjectMapper().writeValueAsString(emp));

		}

	}
}
