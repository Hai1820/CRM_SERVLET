package com.myclass.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.myclass.db.MySqlConnection;
import com.myclass.dto.TaskDto;
import com.myclass.dto.UserDto;
import com.myclass.entity.Task;
import com.myclass.entity.User;

/*
 * created on 2/12/2020 by Nguyen Hoang Hai
 * */
public class UserRepository {
//method save to add new user
	public int save(User user) {
		// TODO Auto-generated method stub
		String query = "INSERT into users(email, fullname, password, avatar, role_id) values(?,?,?,?,?)";
		try {
			Connection connection = MySqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getFullName());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getAvatar());
			statement.setInt(5, (int) user.getRoleId());
			return statement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return -1;
	}

// method to get all list
	public List<UserDto> getAllUsers() {
		String query = "SELECT u.id, u.email, u.fullname, u.avatar, r.description FROM users u JOIN roles r ON u.role_id = r.id";
		List<UserDto> users = new LinkedList<UserDto>();
		try {
			Connection connnection = MySqlConnection.getConnection();
			PreparedStatement statement = connnection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				UserDto user = new UserDto();
				user.setId(result.getInt("id"));
				user.setEmail(result.getString("email"));
				user.setFullName(result.getString("fullname"));
				user.setRoleDesc(result.getString("description"));
				user.setAvatar(result.getString("avatar"));
				users.add(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return users;
	}

//methode to get user by id
	public User findById(int id) {
		User user = new User();
		try {
			String query = "select * from users where id =?";
			Connection connection = MySqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				user.setId(result.getInt("id"));
				user.setEmail(result.getString("email"));
				user.setFullName(result.getString("fullname"));
				user.setAvatar(result.getString("avatar"));
				user.setPassword(result.getString("password"));
				user.setRoleId(result.getInt("role_id"));
				break;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return user;
	}

// method to update user
	public int update(User user) {
		final String query = "UPDATE users SET email = ?, password = ?, fullname = ?, avatar = ?, role_id = ? WHERE id = ? ";
		try {
			Connection connection = MySqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFullName());
			statement.setString(4, user.getAvatar());
			statement.setInt(5, user.getRoleId());
			statement.setInt(6, user.getId());
			return statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return -1;
	}

// method to delete user
	public int deleteById(int idDelete) {
		String query = "delete from users where id =?";
		try {
			Connection connection = MySqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, idDelete);
			return statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return -1;
		// TODO Auto-generated method stub

	}

// method to get task that user is doing
	public List<Task> getUserDetail(int id) {
		List<Task> tasks = new ArrayList<Task>();
		String query = "  SELECT t.name, t.status_id, t.end_date, t.start_date FROM tasks t JOIN users u ON u.id = t.user_id WHERE u.id = ?";
		try {
			Connection connection = MySqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Task task = new Task();
				task.setName(result.getString("name"));
				task.setStatusId(result.getInt("status_id"));
				task.setStartDate(result.getDate("start_date"));
				task.setEndDate(result.getDate("end_date"));
				tasks.add(task);
			}
		} catch (Exception e) {
			// TODO: handle exceptione
			e.getMessage();
		}
		return tasks;
	}

//method to count task user doing group by status_id
	public List<Task> countTask(int id) {

		String query = "select count(t.id) as count, status_id from tasks t where t.user_id =? group by  t.status_id";
		List<Task> counts = new ArrayList<Task>();
		try {
			Connection connection = MySqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Task task = new Task();
				task.setId(result.getInt("count"));
				task.setStatusId(result.getInt("status_id"));
				counts.add(task);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return counts;
	}

// method to count all task user is doing
	public TaskDto count(int id) {
		TaskDto task = new TaskDto();
		String query = "select count(*) as count from tasks where user_id = ?";
		try {
			Connection connection = MySqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				task.setCount(result.getInt("count"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return task;
	}

	public User findByEmail(String email) {
		User user = null;
		try {
			Connection conn = MySqlConnection.getConnection();
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM users WHERE email = ?");
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				user = new User(resultSet.getInt("id"), resultSet.getString("email"), resultSet.getString("password"),
						resultSet.getString("fullname"), resultSet.getString("avatar"), resultSet.getInt("role_id"));
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
