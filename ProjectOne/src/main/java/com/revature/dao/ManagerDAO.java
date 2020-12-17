package com.revature.dao;

import java.util.List;

import com.revature.model.Manager;

public interface ManagerDAO {

	public Manager getManagerByUsername(String username);
	public List<Manager> getManager();
	
}
