package edu.mum.waa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.mum.waa.model.User;
import edu.mum.waa.service.LoginService;
import edu.mum.waa.service.LoginServiceImpl;

@WebServlet("/authentication")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public HomeServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		User user = new User(username, password);
		LoginService ls = new LoginServiceImpl();
		
		if (ls.login(user)) {
			// success logged in
			request.getSession().setAttribute("username", username);
			response.sendRedirect("welcome.jsp");
		} else {
			// fail
			System.out.println("fail");
			request.setAttribute("error", "Login Failed!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
}
