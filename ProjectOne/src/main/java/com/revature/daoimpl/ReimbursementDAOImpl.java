package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.ReimbursementDAO;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.util.ConnFactory;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public Reimbursement getReimbursementByID(int id) throws SQLException {
		Reimbursement form = new Reimbursement();
		try {
			Connection conn = cf.getConnection();
			String sql = "SELECT * FROM reimbursement WHERE employee_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				form.setFormID(rs.getInt(1));
				form.setEmpID(rs.getInt(2));
				form.setEventDate(rs.getString(3));
				form.setRequestDate(rs.getString(4));
				form.setLocation(rs.getString(5));
				form.setAmount(rs.getInt(6));
				form.setDescription(rs.getString(7));
				form.setEventType(rs.getString(8));
				form.setGradeType(rs.getString(9));
				form.setStatus(rs.getString(10));
				form.setStatusdepthead(rs.getString(11));
				form.setStatusbenco(rs.getString(12));
				form.setGradeValue(rs.getString(13));
				form.setPassingGrade(rs.getString(14));
				form.setUrgent( rs.getString(15));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return form;
	}

	@Override
	public List<Reimbursement> getReimbursement() throws SQLException {
		List<Reimbursement> rList = new ArrayList<Reimbursement>();
		try {
			Connection conn = cf.getConnection();
			String sql = "SELECT * FROM reimbursement";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				rList.add(new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
						rs.getString(15)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rList;
	}

	@Override
	public List<Reimbursement> getReimbursementByEmpID(int empID) throws SQLException {
		List<Reimbursement> rList = new ArrayList<Reimbursement>();
		try {
			Connection conn = cf.getConnection();
			String sql = "SELECT * FROM reimbursement WHERE employee_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, empID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				rList.add(new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
						rs.getString(15)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rList;
	}

	@Override
	public void updateReimbursementStatus(String status, int reID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "update reimbursement set status =? where reimbursement_id=?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, status);
		ps.setInt(2, reID);
		ps.executeUpdate();
	}

	public void updateReimbursementStatus2(String status, int reID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "update reimbursement set statusdepthead =? where reimbursement_id=?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, status);
		ps.setInt(2, reID);
		ps.executeUpdate();
	}

	public void updateReimbursementStatus3(String status, int reID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "update reimbursement set statusbenco =? where reimbursement_id=?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, status);
		ps.setInt(2, reID);
		ps.executeUpdate();
	}

	@Override
	public void addReimbursement(Reimbursement form) throws SQLException {
		System.out.println("this adds");
		try {
			Connection conn = cf.getConnection();
			String sql = "INSERT INTO reimbursement values(DEFAULT,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, form.getEmpID());
			ps.setString(2, form.getEventDate());
			ps.setString(3, form.getRequestDate());
			ps.setString(4, form.getLocation());
			ps.setDouble(5, form.getAmount());
			ps.setString(6, form.getDescription());
			ps.setString(7, form.getEventType());
			ps.setString(8, form.getGradeType());
			ps.setString(9, form.getStatus());
			ps.setString(10, form.getStatusdepthead());
			ps.setString(11, form.getStatusbenco());
			ps.setString(12, form.getGradeValue());
			ps.setString(13, form.getPassingGrade());
			ps.setString(14, form.getUrgent());

			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public void updateReimbursementGrade(String grade, int reID) throws SQLException {
		if (grade.equalsIgnoreCase("")) {
			System.out.println("nothing");
		} else {
			Connection conn = cf.getConnection();
			String sql = "update reimbursement set grade_value =? where reimbursement_id=?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, grade);
			ps.setInt(2, reID);
			ps.executeUpdate();
		}
	}

	public void updateReimbursementDescription(String description, int reID) throws SQLException {
		if (description.equalsIgnoreCase("")) {
			System.out.println("nothing");
		} else {
			Connection conn = cf.getConnection();
			String sql = "update reimbursement set description =? where reimbursement_id=?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, description);
			ps.setInt(2, reID);
			ps.executeUpdate();
		}
	}

	public void updateReimbursementAmount(double amount, int reID) throws SQLException {
		if (amount == 0) { 
			System.out.println("nothing");
		} else {
			Connection conn = cf.getConnection();
			String sql = "update reimbursement set amount =? where reimbursement_id=?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, amount);
			ps.setInt(2, reID);
			ps.executeUpdate();
			System.out.println(amount);
		}
	}

}
