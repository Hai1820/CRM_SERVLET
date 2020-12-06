package com.myclass.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;


import com.myclass.db.MySqlConnection;
import com.myclass.entity.Role;

public class RoleRepository {

	public List<Role> getAllRole() {
		String query = "SELECT * from roles";
		List<Role> roles = new LinkedList<Role>();

		try {
			Connection connection = MySqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Role role = new Role();
				role.setId(result.getInt("id"));
				role.setDescription(result.getString("description"));
				role.setName(result.getString("name"));
				roles.add(role);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return roles;
	}

	public int save(Role role) {
		String query = "insert into roles (name, description) values(?,?)";
		try {
			Connection connection = MySqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, role.getName());
			statement.setString(2, role.getDescription());
			return statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return 0;
	}

	public Role getRoleById(int id) {
		if (id == 0) {
			return new Role();
		}

		try {
			String query = "select * from roles where id = ?";
			Connection connection = MySqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Role role = new Role();
				role.setDescription(result.getString("description"));
				role.setName(result.getString("name"));
				return role;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return new Role();
	}

	public void updateRoleById(int id, Role role) {
		if (id == 0) {
			return;
		}
		String query = "update roles set name = ?, description=? where id = ?";
		try {
			Connection connection = MySqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, role.getName());
			statement.setString(2, role.getDescription());
			statement.setInt(3, role.getId());
			int result = statement.executeUpdate();
			if (result < 0) {
				System.out.println("UPDATE ROLE BY ID UNSUCCESFULLY");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}

	}

	public void deleteRoleById(int id) {
		String query = "delete from roles where id =?";
		try {
			Connection connection = MySqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			int result= statement.executeUpdate();
			if(result<1) {
				System.out.println("DELETE FROM ROLE UNSUCCESFULLY");
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

}
