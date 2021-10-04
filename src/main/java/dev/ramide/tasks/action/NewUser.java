package dev.ramide.tasks.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.ramide.tasks.controller.UserController;
import dev.ramide.tasks.model.User;

public class NewUser implements Action {


	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User newUser = new User();
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setUsername(username);
		newUser.setPassword(password);
		
		UserController userController = new UserController();
		userController.save(newUser);
		
		return "redirect:entry?action=LoginForm";
	}
}
