package com.myclass.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.myclass.db.MySqlConnection;
import com.myclass.entity.Task;

public class TaskRepository {

	public List<Task> getAllTask() {
		List<Task> tasks = new LinkedList<Task>();
		String query = "select * from tasks";
		try {
			Connection connection = MySqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Task task = new Task();
				task.setId(result.getInt("id"));
				task.setName(result.getString("name"));
				task.setStartDate(result.getTimestamp("start_date"));
				task.setEndDate(result.getTimestamp("end_date"));
				tasks.add(task);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return tasks;
	}

}
