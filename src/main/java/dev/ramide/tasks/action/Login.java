package dev.ramide.tasks.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.ramide.tasks.controller.UserController;
import dev.ramide.tasks.model.User;

public class Login implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String passwd = request.getParameter("passwd");
		
		UserController userController = new UserController();
		User user = userController.validate(login, passwd);

		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("logged", user);
			return "redirect:entry?action=TaskList";
		}
		
		return "redirect:entry?action=LoginForm";
	}
}
