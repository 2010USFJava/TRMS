package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.ManagerDAO;
import com.revature.model.Manager;
import com.revature.util.ConnFactory;

public class ManagerDAOImpl implements ManagerDAO {
	public static ConnFactory cf = ConnFactory.getInstance();
	static {
		try { Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
	}
	}

	@Override
	public Manager getManagerByUsername(String username) {
		Manager man = new Manager();
		try {
			Connection conn = cf.getConnection();
			String sql = "SELECT * FROM manager WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				man.setFirstName(rs.getString(1));
				man.setLastName(rs.getString(2));
				man.setUsername(rs.getString(3));
				man.setPassword(rs.getString(4));
				man.setManID(rs.getInt(5));
				
			}
				
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return man;
	}
	public List<Manager> getManager() {
		List<Manager> mList = new ArrayList<Manager>();

		try {
			Connection conn = cf.getConnection();
			String sql = "SELECT * FROM manager";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				mList.add(new Manager(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getBoolean(6),rs.getBoolean(7),rs.getBoolean(8)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mList;
	}


}
