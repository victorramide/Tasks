package dev.ramide.tasks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.ramide.tasks.model.Task;

public class TaskDAO {

	private Connection connection;

	public TaskDAO(Connection connection) {
		this.connection = connection;
	}

	public void create(Task task) {
		try {
			String sql = "INSERT INTO task (TITLE, DESCRIPTION, STATUS, USERID) VALUES (?, ?, ?, ?)";
			try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				pstmt.setString(1, task.getTitle());
				pstmt.setString(2, task.getDescription());
				pstmt.setString(3, task.getStatus());
				pstmt.setInt(4, task.getUserId());

				pstmt.execute();

				try (ResultSet rst = pstmt.getGeneratedKeys()) {
					while (rst.next()) {
						task.setId(rst.getInt(1));
					}
				}
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Task searchTaskById(Integer id) {
		try {
			Task task = new Task();
			String sql = "SELECT ID, TITLE, DESCRIPTION, STATUS FROM task WHERE ID = ?";

			try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
				pstmt.setInt(1, id);
				pstmt.execute();
				try (ResultSet rst = pstmt.getResultSet()) {
					while (rst.next()) {
						task.setId(rst.getInt("id"));
						task.setTitle(rst.getString("title"));
						task.setDescription(rst.getString("description"));
						task.setStatus(rst.getString("status"));
					}
				}

			}
			return task;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Task> searchTasksByUser(int userId) {
		try {
			List<Task> tasks = new ArrayList<Task>();
			String sql = "SELECT ID, TITLE, DESCRIPTION, STATUS FROM task WHERE USERID = ?";
			try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
				pstmt.setInt(1, userId);
				pstmt.execute();
				try (ResultSet rst = pstmt.getResultSet()) {
					while (rst.next()) {
						Task task = new Task();
						task.setId(rst.getInt("id"));
						task.setTitle(rst.getString("title"));
						task.setDescription(rst.getString("description"));
						task.setStatus(rst.getString("status"));
						tasks.add(task);
					}
				}
			}
			return tasks;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Task> listAll() {
		try {
			List<Task> tasks = new ArrayList<Task>();
			String sql = "SELECT ID, TITLE, DESCRIPTION, STATUS, USERID FROM task";
			try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
				pstmt.execute();

				try (ResultSet rst = pstmt.getResultSet()) {
					while (rst.next()) {
						Task task = new Task();
						task.setId(rst.getInt("id"));
						task.setTitle(rst.getString("title"));
						task.setDescription(rst.getString("description"));
						task.setStatus(rst.getString("status"));
						task.setUserId(rst.getInt("userId"));
						tasks.add(task);
					}
				}
			}
			return tasks;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Integer id, String title, String description, String status) {
		try {
			String sql = "UPDATE task SET TITLE = ?, DESCRIPTION = ?, STATUS = ? WHERE ID = ?";
			try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
				pstmt.setString(1, title);
				pstmt.setString(2, description);
				pstmt.setString(3, status);
				pstmt.setInt(4, id);

				pstmt.execute();
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(Integer id) {
		try {
			String sql = "DELETE FROM task WHERE ID = ?";
			try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
				pstmt.setInt(1, id);
				pstmt.execute();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
