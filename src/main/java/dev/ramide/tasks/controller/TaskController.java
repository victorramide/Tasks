package dev.ramide.tasks.controller;

import java.sql.Connection;
import java.util.List;

import dev.ramide.tasks.dao.TaskDAO;
import dev.ramide.tasks.factory.ConnectionFactory;
import dev.ramide.tasks.model.Task;

public class TaskController {

	private TaskDAO taskDAO;

	public TaskController() {
		Connection con = new ConnectionFactory().recoveryConnection();
		this.taskDAO = new TaskDAO(con);
	}
	
	public void save(Task task) {
		this.taskDAO.create(task);
	}
	
	public List<Task> listAll(){
		return this.taskDAO.listAll();
	}
	
	public Task searchTaskById(Integer id) {
		return this.taskDAO.searchTaskById(id);
	}
	
	public List<Task> searchTasksByUser(Integer userId){
		return this.taskDAO.searchTasksByUser(userId);
	}
	
	public void update(Integer id, String title, String description, String status) {
		this.taskDAO.update(id, title, description, status);
	}
	
	public void delete(Integer id) {
		this.taskDAO.delete(id);
	}
}
