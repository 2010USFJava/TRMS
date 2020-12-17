package com.revature.service;


import java.util.List;

import com.revature.dao.EmployeeDAO;
import com.revature.daoimpl.EmployeeDAOImpl;
import com.revature.model.Employee;

public class EmployeeService {

		EmployeeDAO edao = new EmployeeDAOImpl();
		
		public boolean loginVerify(String username, String password){
			List<Employee> eList= edao.getEmployees();
			boolean verify = false;
			for(Employee emp: eList) {
				if(emp.getUsername().equals(username)&& emp.getPassword().equals(password)) {
					verify = true;
				}
			}
			System.out.println(verify);
			return verify;
			
		}
		
		public Employee loginGetEmployee(String username, String password){
			
			if(loginVerify(username,password)) {
				return edao.getEmployeeByUsername(username);
			}
			return null;
		}
		
		public void addEmployee(Employee emp) {
			edao.addEmployee(emp);
		}
		
		public Employee getSessionEmp(int empID) {
			return edao.getEmployeeByID(empID);
		}


	}

