package dev.ramide.tasks.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.ramide.tasks.controller.TaskController;
import dev.ramide.tasks.model.Task;
import dev.ramide.tasks.model.User;

public class TaskList implements Action {


	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("logged");
		
		TaskController taskController = new TaskController();
		List<Task> taskList = taskController.searchTasksByUser(user.getuserId());
		
		request.setAttribute("tasks", taskList);
		
		return "forward:taskList.jsp";
	}

}
