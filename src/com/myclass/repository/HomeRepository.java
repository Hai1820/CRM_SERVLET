package com.myclass.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.myclass.db.MySqlConnection;
import com.myclass.entity.Task;

public class HomeRepository {
//method getCount to count task  group by status_id
	public List<Task> getCount() {
		List<Task> counts = new ArrayList<Task>();
		String query = "select count(id) counts, status_id from tasks group by status_id ";
		try {
			Connection connection = MySqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Task count = new Task();
				count.setId(result.getInt("counts"));
				count.setStatusId(result.getInt("status_id"));
				counts.add(count);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return counts;
	}
// method getAllCount to get all all task 
	public Task getAllCount() {
		Task allCount = new Task();
		String query = "select count(*) as counts from tasks";
		try {
			Connection connection = MySqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				allCount.setId(result.getInt("count"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return allCount;
	}
}
