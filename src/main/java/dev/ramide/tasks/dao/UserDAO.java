package dev.ramide.tasks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.ramide.tasks.model.User;

public class UserDAO {

	private Connection connection;

	public UserDAO(Connection connection) {
		this.connection = connection;
	}

	public void create(User user) {

		try {
			String sql = "INSERT INTO user (FIRSTNAME, LASTNAME, USERNAME, PASSWRD) VALUES (?, ?, ?, ?)";

			try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				pstmt.setString(1, user.getFirstName());
				pstmt.setString(2, user.getLastName());
				pstmt.setString(3, user.getUsername());
				pstmt.setString(4, user.getPassword());

				pstmt.execute();

				try (ResultSet rst = pstmt.getGeneratedKeys()) {
					while (rst.next()) {
						user.setuserId(rst.getInt(1));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public User searchUserByUsername(User user) {

		try {
			User resultUser = new User();
			String sql = "SELECT USERID, FIRSTNAME, LASTNAME, USERNAME, PASSWRD FROM user WHERE USERNAME = ?";
			try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
				pstmt.setString(1, user.getUsername());
				pstmt.execute();

				try (ResultSet rst = pstmt.getResultSet()) {

					while (rst.next()) {

						resultUser.setuserId(rst.getInt("userId"));
						resultUser.setFirstName(rst.getString("firstName"));
						resultUser.setLastName(rst.getString("lastName"));
						resultUser.setUsername(rst.getString("username"));
						resultUser.setPassword(rst.getString("PASSWRD"));
					}
				} 
			}
			return resultUser;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public User searchUserbyId(Integer userId) {

		try {
			User resultUser = new User();
			String sql = "SELECT USERID, FIRSTNAME, LASTNAME, USERNAME, PASSWRD FROM user WHERE USERID = ?";
			try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
				pstmt.setInt(1, userId);
				pstmt.execute();
				try (ResultSet rst = pstmt.getResultSet()) {

					while (rst.next()) {

						resultUser.setuserId(rst.getInt("userId"));
						resultUser.setFirstName(rst.getString("firstName"));
						resultUser.setLastName(rst.getString("lastName"));
						resultUser.setUsername(rst.getString("username"));
						resultUser.setPassword(rst.getString("PASSWRD"));
					}
				} 
			}
			return resultUser;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<User> listAll() {

		try {
			List<User> users = new ArrayList<User>();
			String sql = "SELECT USERID, FIRSTNAME, LASTNAME, USERNAME, PASSWRD FROM user";

			try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
				pstmt.execute();
				try (ResultSet rst = pstmt.getResultSet()) {
					while (rst.next()) {
						User user = new User(rst.getInt("userId"), rst.getString("firstName"), rst.getString("lastName"), rst.getString("username"),
								rst.getString("passwrd"));

						users.add(user);
					}
				}
			}
			return users;
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
	}

	public void update(Integer userId, String firstName, String lastName, String username, String password) {

		try {
			String sql = "UPDATE user SET FIRSTNAME = ?, LASTNAME = ?, USERNAME = ?, PASSWRD = ? WHERE USERID = ?";

			try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
				pstmt.setString(1, firstName);
				pstmt.setString(2, lastName);
				pstmt.setString(3, username);
				pstmt.setString(4, password);
				pstmt.setInt(5, userId);

				pstmt.execute();
			}
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
	}
	
	public void updatePassword(Integer userId, String password) {
		try {
			String sql = "UPDATE user SET PASSWRD = ? WHERE USERID = ?";

			try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
				pstmt.setString(1, password);
				pstmt.setInt(2, userId);

				pstmt.execute();
			}
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
	}

	public void delete(Integer userId) {

		try {
			String sql = "DELETE FROM user WHERE USERID = ?";
			try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
				pstmt.setInt(1, userId);
				pstmt.execute();
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public User validateUser(String username, String password) {
		List<User> users = this.listAll();
		
		for (User user : users) {
			if(user.equals(username, password)) {
				return user;
			}
		}
		return null;
	}
}
