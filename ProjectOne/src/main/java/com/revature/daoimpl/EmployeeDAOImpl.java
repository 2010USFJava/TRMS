package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.EmployeeDAO;
import com.revature.model.Employee;
import com.revature.util.ConnFactory;

public class EmployeeDAOImpl implements EmployeeDAO {

	public static ConnFactory cf = ConnFactory.getInstance();
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Employee getEmployeeByID(int id) {
		Employee emp = new Employee();
		try {
			Connection conn = cf.getConnection();
			String sql = "SELECT * FROM employee WHERE emp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				emp.setFirstName(rs.getString(1));
				emp.setLastName(rs.getString(2));
				emp.setUsername(rs.getString(3));
				emp.setPassword(rs.getString(4));
				emp.setEmpID(rs.getInt(5));
				emp.setBalance(rs.getDouble(6));
				emp.setEmail(rs.getString(7));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return emp;
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> eList = new ArrayList<Employee>();

		try {
			Connection conn = cf.getConnection();
			String sql = "SELECT * FROM employee";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				eList.add(new Employee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getDouble(6), rs.getString(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eList;
	}

	@Override
	public void updateEmployeeUsername(String newUsername, int id) throws SQLException {
		if(newUsername.equalsIgnoreCase("")) {
		System.out.println("nothing");
		}else {
		Connection conn = cf.getConnection();
		String sql = "update employee set username =? where emp_id=?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, newUsername);
		ps.setInt(2, id);
		ps.executeUpdate();
		// LogThis.LogIt("info", " A customer has an updated password: " +
		// a.getPassword());
		}
	}

	public void updateEmployeePassword(String newPassword, int id) throws SQLException {
		if(newPassword.equalsIgnoreCase("")) {
			System.out.println("nothing");
		}else {
		Connection conn = cf.getConnection();
		String sql = "update employee set password =? where emp_id=?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, newPassword);
		ps.setInt(2, id);
		ps.executeUpdate();
		// LogThis.LogIt("info", " A customer has an updated password: " +
		// a.getPassword());
		}
	}

	public void addEmployee(Employee emp) {
		try {
			Connection conn = cf.getConnection();
			String sql = "INSERT INTO employee values(?,?,?,?,DEFAULT)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emp.getFirstName());
			ps.setString(2, emp.getLastName());
			ps.setString(3, emp.getUsername());
			ps.setString(4, emp.getPassword());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Employee getEmployeeByUsername(String username) {
		Employee emp = new Employee();
		try {
			Connection conn = cf.getConnection();
			String sql = "SELECT * FROM employee WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				emp.setFirstName(rs.getString(1));
				emp.setLastName(rs.getString(2));
				emp.setUsername(rs.getString(3));
				emp.setPassword(rs.getString(4));
				emp.setEmpID(rs.getInt(5));
				emp.setBalance(rs.getDouble(6));
				emp.setEmail(rs.getString(7));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return emp;
	}

	public void withdraw2(int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select amount, employee_id from reimbursement where reimbursement_id=?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Double amount = rs.getDouble("amount");
			int empID = rs.getInt("employee_id");
			if (amount >= 1) {
				String sql2 = "select balance from employee where emp_id=?;";
				PreparedStatement ps2 = conn.prepareStatement(sql2);
				ps2.setDouble(1, empID);
				ResultSet rs2 = ps2.executeQuery();
				while (rs2.next()) {
					Double balance = rs2.getDouble("balance");
					double modBalance = balance - amount;
					String sql3 = "update employee set balance =? where emp_id=?;";
					PreparedStatement ps3 = conn.prepareStatement(sql3);
					ps3.setDouble(1, modBalance);
					ps3.setInt(2, id);
					ps3.executeUpdate();
				}
			}
		}
	}
	
	public void withdraw(double amount, int eid) throws SQLException {
		Connection conn = cf.getConnection();
		if (amount >= 1) {
			String sql2 = "select balance from employee where emp_id=?;";
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setDouble(1, eid);
			ResultSet rs2 = ps2.executeQuery();
			while (rs2.next()) {
				Double balance = rs2.getDouble("balance");
				double modBalance = balance - amount;
				String sql3 = "update employee set balance =? where emp_id=?;";
				PreparedStatement ps3 = conn.prepareStatement(sql3);
				ps3.setDouble(1, modBalance);
				ps3.setInt(2, eid);
				ps3.executeUpdate();
			}
		}
	}
	
	public void deposit(int rid) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select amount, employee_id from reimbursement where reimbursement_id=?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDouble(1, rid);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Double amount = rs.getDouble("amount");
			int empid = rs.getInt("employee_id");
			String sql1 = "select balance from employee where emp_id=?;";
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			ps1.setInt(1, empid);
			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {
				Double balance = rs1.getDouble(1);
				System.out.println(rs1.getDouble(1));
				double modBalance = balance + amount;
				if (modBalance >= 1000) {
					String sql3 = "update employee set balance =? where emp_id=?;";
					PreparedStatement ps3 = conn.prepareStatement(sql3);
					ps3.setDouble(1, 1000);
					ps3.setInt(2, empid);
					ps3.executeUpdate();
				}else {
				String sql2 = "update employee set balance =? where emp_id=?;";
				PreparedStatement ps2 = conn.prepareStatement(sql2);
				ps2.setDouble(1, modBalance);
				ps2.setInt(2, empid);
				ps2.executeUpdate();
				}
			}
		}
	}
	
}
