package dev.ramide.tasks.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.ramide.tasks.controller.TaskController;

public class UpdateTask implements Action {


	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String status = request.getParameter("status");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		TaskController taskController = new TaskController();
		taskController.update(id, title, description, status);
		
		return "redirect:entry?action=TaskList";
	}

}
