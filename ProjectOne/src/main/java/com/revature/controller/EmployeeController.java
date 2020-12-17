package com.revature.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDAO;
import com.revature.dao.ReimbursementDAO;
import com.revature.daoimpl.EmployeeDAOImpl;
import com.revature.daoimpl.ReimbursementDAOImpl;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.service.EmployeeService;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeController {

	static EmployeeDAO edao = new EmployeeDAOImpl();
	static EmployeeService eServ = new EmployeeService();
	static ReimbursementDAO rdao = new ReimbursementDAOImpl();
	
	public static void getSessionEmployee(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		Employee emp = (Employee) req.getSession().getAttribute("currentemp");
			res.getWriter().write(new ObjectMapper().writeValueAsString(emp));
	}
	
	public static void getSessionEmp(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		HttpSession session = req.getSession();
		int emp= (int) session.getAttribute("currentemp");
		Employee empObj = eServ.getSessionEmp(emp);
		System.out.println("in employee controller");
		System.out.println(empObj);
		ObjectMapper mapper = new ObjectMapper ();
		String empString = mapper.writeValueAsString(empObj);
		String newString = "{\"employee\":" + empString + "}";
		System.out.println(newString);
		res.getWriter().write(newString);
	}
	
	public static String updateEmployee(HttpServletRequest req) throws SQLException {
        if (!req.getMethod().equals("POST")) {
            return "resources/html/updateEmployeeProfile.html";
        }

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String eid = req.getParameter("eid");
        Integer id = Integer.valueOf(eid);

        if (username != null) {
            edao.updateEmployeeUsername(username, id);
        } 
        if (password != null){
            edao.updateEmployeePassword(password, id);
        }

        return "updatesuccess.change";

        }
	public static void viewEmployee(HttpServletRequest req, HttpServletResponse res) throws SQLException, JsonGenerationException, JsonMappingException, IOException {
		List<Employee> employees = new ArrayList<Employee>();
		employees = edao.getEmployees();
		System.out.println(employees);
		System.out.println("getting employees");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(out, employees);
		byte [] data = out.toByteArray();
		System.out.println(new String(data));
		res.getWriter().write(new String(data));
	}
	public static void viewReimbursementById(HttpServletRequest req, HttpServletResponse res) throws SQLException, JsonGenerationException, JsonMappingException, IOException {
		HttpSession session = req.getSession();
		int emp= (int) session.getAttribute("currentemp");
		System.out.println("in view by id");
		System.out.println(emp);	
		List<Reimbursement> reimbursement = new ArrayList<Reimbursement>();
		reimbursement = rdao.getReimbursementByEmpID(emp);
		System.out.println(reimbursement);
		System.out.println("getting reimbursements");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(out, reimbursement);
		byte [] data = out.toByteArray();
		System.out.println(new String(data));
		res.getWriter().write(new String(data));
	}
}



