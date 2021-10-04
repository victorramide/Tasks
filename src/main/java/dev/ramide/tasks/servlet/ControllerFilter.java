package dev.ramide.tasks.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.ramide.tasks.action.Action;



public class ControllerFilter implements Filter{

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String paramAction = request.getParameter("action");
		String className = "dev.ramide.tasks.action."+paramAction;
		String name;
		
		try {
			
			Class genericalClass = Class.forName(className);
			Action action = (Action) genericalClass.newInstance();
			name = action.execute(request, response);
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}
		
		String[] typeAndAddress = name.split(":");
		
		if (typeAndAddress[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+typeAndAddress[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(typeAndAddress[1]);
		}
		
	}

}
