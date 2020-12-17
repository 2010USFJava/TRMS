package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public class ManagerProfileController {

	public static String profile(HttpServletRequest req) {
		return "resources/html/managerhomepage.html";
		}
	public static String profile2(HttpServletRequest req) {
		return "resources/html/deptheadhomepage.html";
		}
	public static String profile3(HttpServletRequest req) {
		return "resources/html/bencohomepage.html";
		}
}
