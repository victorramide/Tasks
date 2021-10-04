package dev.ramide.tasks.controller;

import java.sql.Connection;
import java.util.List;

import dev.ramide.tasks.dao.UserDAO;
import dev.ramide.tasks.factory.ConnectionFactory;
import dev.ramide.tasks.model.User;

public class UserController {
	
	private UserDAO userDAO;

	public UserController() {
		Connection con = new ConnectionFactory().recoveryConnection();
		this.userDAO = new UserDAO(con);
	}
	
	public void save(User user) {
		this.userDAO.create(user);
	}
	
	public List<User> listAll() {
		
		return this.userDAO.listAll();
	}
	
	public User searchUserbyId(Integer userId) {
		User user = new User();
		user = this.userDAO.searchUserbyId(userId);
		return user;
	}
	
	public void update(Integer userId, String firstName, String lastName, String username, String password) {
		this.userDAO.update(userId, firstName, lastName, username, password);
	}
	
	public void delete(Integer userId) {
		this.userDAO.delete(userId);
	}
	
	public User validate(String username, String password) {
		return this.userDAO.validateUser(username, password);
	}
}
