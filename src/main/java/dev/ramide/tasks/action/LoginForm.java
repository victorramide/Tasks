package dev.ramide.tasks.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.ramide.tasks.model.User;

public class LoginForm implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("logged");
		
		if(user != null) {
			return "redirect:entry?action=TaskList";
		}
		
		return "forward:formLogin.jsp";
	}

}
