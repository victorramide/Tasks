package dev.ramide.tasks.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.ramide.tasks.controller.TaskController;
import dev.ramide.tasks.model.Task;

public class ShowTask implements Action {


	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		TaskController taskController = new TaskController();
		Task task = taskController.searchTaskById(id);
		
		request.setAttribute("task", task);
		
		
		return "forward:formUpdateTask.jsp";
	}

}
