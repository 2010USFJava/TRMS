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
import com.revature.dao.ManagerDAO;
import com.revature.daoimpl.ManagerDAOImpl;
import com.revature.model.Employee;
import com.revature.model.Manager;

public class ManagerController {

	static ManagerDAO mdao = new ManagerDAOImpl();
	
//	public static void getSessionManager(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
//		Manager man = (Manager) req.getSession().getAttribute("currentman");
//			res.getWriter().write(new ObjectMapper().writeValueAsString(man));
//	}
//	public static String managerhome(HttpServletRequest req) {
//		return "resources/html/managerhomepage.html";
//	}
	public static void mangetSession(HttpServletRequest req, HttpServletResponse res) throws SQLException, JsonGenerationException, JsonMappingException, IOException {
		List<Manager> manager = new ArrayList<Manager>();
		manager = mdao.getManager();
		System.out.println(manager);
		System.out.println("getting managers");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(out, manager);
		byte [] data = out.toByteArray();
		System.out.println(new String(data));
		res.getWriter().write(new String(data));
	}
}
