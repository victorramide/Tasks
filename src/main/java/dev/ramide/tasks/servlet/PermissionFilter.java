package dev.ramide.tasks.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class PermissionFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String paramAction = request.getParameter("action");
		
		HttpSession session = request.getSession();
		
		boolean userNotLogged = (session.getAttribute("logged") == null);
		boolean isProtected = !(paramAction.equals("Login") || paramAction.equals("LoginForm") || paramAction.equals("NewUser") || paramAction.equals("NewUserForm") || paramAction.equals("Home"));
		
		if(userNotLogged && isProtected) {
			response.sendRedirect("entry?action=LoginForm");
			return;
		}
		
		chain.doFilter(request, response);
	}

}
