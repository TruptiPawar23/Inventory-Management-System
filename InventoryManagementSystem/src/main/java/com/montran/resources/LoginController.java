package com.montran.resources;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.montran.services.AdminDao;
import com.montran.services.UserDao;

@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao u;
     
	public void init() {
		u = new UserDao();
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		String role = request.getParameter("role");
		
		if(role.equals("Admin")) {
			if(AdminDao.authenticate(uname, pass)) {
				RequestDispatcher req1 = request.getRequestDispatcher("adminHome.jsp");
				req1.forward(request, response);
			}else {
				response.setContentType("text/html");
				RequestDispatcher req1 = request.getRequestDispatcher("login.jsp");
				request.setAttribute("fail", "true");
				req1.include(request, response);
			}
		}else {
			if(u.validate(uname, pass)) {
				response.sendRedirect("userView.jsp");
			}else {
				request.setAttribute("fail", "true");
				RequestDispatcher res = request.getRequestDispatcher("login.jsp");
				res.include(request, response);
			}
		}
	}

}