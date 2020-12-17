package com.revature.service;

import java.sql.SQLException;
import java.util.List;

import com.revature.dao.ReimbursementDAO;
import com.revature.daoimpl.ReimbursementDAOImpl;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;

public class ReimbursementService {

	ReimbursementDAO rdao = new ReimbursementDAOImpl();
	//adds reimbursements 
	public void addReimbursement(Reimbursement re) throws SQLException {
		rdao.addReimbursement(re);
	}
	// get list of reimbursements by employee id 
	public List<Reimbursement> getReimbursementByID(Employee id) throws SQLException {
		 List<Reimbursement> reimbursements;
	      reimbursements = rdao.getReimbursement();
	    
	        return reimbursements;
	}
	//get reimbursement by reim id 
	  public Reimbursement viewReimbursementById(int id) throws SQLException {
	        return rdao.getReimbursementByID(id);
	    }
	  //get all reimbursements from all employees 
	  public List<Reimbursement> getReimbursement() throws SQLException {
		  List<Reimbursement> rList;
		  rList = rdao.getReimbursement();
		  return rList;
	  }
	
	
		
}
