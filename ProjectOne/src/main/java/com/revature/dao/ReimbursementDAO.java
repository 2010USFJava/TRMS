package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.Reimbursement;

public interface ReimbursementDAO {

	public Reimbursement getReimbursementByID(int ID) throws SQLException;
	public List<Reimbursement> getReimbursement() throws SQLException;
	public void updateReimbursementStatus(String status, int reID) throws SQLException;
	public void updateReimbursementStatus2(String status, int reID) throws SQLException;
	public void updateReimbursementStatus3(String status, int reID) throws SQLException;
	public void addReimbursement(Reimbursement form) throws SQLException;
	public List<Reimbursement> getReimbursementByEmpID(int empId) throws SQLException;
	public void updateReimbursementGrade(String grade, int reID) throws SQLException;
	public void updateReimbursementDescription(String description, int reID) throws SQLException ;
	public void updateReimbursementAmount(double amount, int reID) throws SQLException;
}
