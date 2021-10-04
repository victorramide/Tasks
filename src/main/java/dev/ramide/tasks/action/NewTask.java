package dev.ramide.tasks.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.ramide.tasks.controller.TaskController;
import dev.ramide.tasks.model.Task;
import dev.ramide.tasks.model.User;

public class NewTask implements Action {


	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String status = request.getParameter("status");
		User user = (User) session.getAttribute("logged");
		
		Task task = new Task();
		task.setTitle(title);
		task.setDescription(description);
		task.setStatus(status);
		task.setUserId(user.getuserId());
		
		TaskController taskController = new TaskController();
		taskController.save(task);
		
		request.setAttribute("task", task.getTitle());
		
		return "redirect:entry?action=TaskList";
	}

}
