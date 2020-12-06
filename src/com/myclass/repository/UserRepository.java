package com.myclass.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.myclass.db.MySqlConnection;
import com.myclass.dto.UserDto;
import com.myclass.entity.User;

public class UserRepository {

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

	public User findById(int id) {
		User user = new User();
		try {
			String query = "select * from users where id =?";
			Connection connection = MySqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
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

}
