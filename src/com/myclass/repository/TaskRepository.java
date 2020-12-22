package com.myclass.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.myclass.db.MySqlConnection;
import com.myclass.dto.TaskDto;
import com.myclass.entity.Status;
import com.myclass.entity.Task;

public class TaskRepository {
//add new task 
	public int save(Task task) {
		String query = "INSERT into tasks(name, job_id, user_id,status_id, start_date, end_date) values(?,?,?,?,?,?)";
		try {
			Connection connection = MySqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, task.getName());
			statement.setInt(2, task.getJobId());
			statement.setInt(3, task.getUserId());
			statement.setInt(4, task.getStatusId());
			statement.setDate(5, task.getStartDate());
			statement.setDate(6, task.getEndDate());
			return statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return -1;
	}
//method to get all list status
	public List<Status> getAllStatus() {
		String query = "select * from status";
		List<Status> statuses = new LinkedList<Status>();
		try {
			Connection connection = MySqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Status status = new Status();
				status.setId(result.getInt("id"));
				status.setName(result.getString("name"));
				statuses.add(status);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return statuses;
	}
//method to get list task 
	public List<TaskDto> getALlTasks() {
		String query = "SELECT t.id, t.name as task, j.name as job, u.fullname, t.end_date, t.start_date, s.name as status FROM tasks t JOIN jobs j ON j.id = t.job_id JOIN users u ON u.id = t.user_id JOIN status s ON s.id = t.status_id";
		List<TaskDto> tasks = new LinkedList<TaskDto>();
		try {
			Connection connection = MySqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				TaskDto task = new TaskDto();
				task.setId(result.getInt("id"));
				task.setName(result.getString("task"));
				task.setNameJob(result.getString("job"));
				task.setNameUser(result.getString("fullname"));
				task.setEndDate(result.getDate("end_date"));
				task.setStartDate(result.getDate("start_date"));
				task.setNameStatus(result.getString("status"));
				tasks.add(task);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return tasks;
	}
// find task by id
	public Task findById(int id) {
		String query = "select * from tasks where id =? ";
		Task task = new Task();
		try {
			Connection connection = MySqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				task.setId(result.getInt("id"));
				task.setName(result.getString("name"));
				task.setJobId(result.getInt("job_id"));
				task.setStatusId(result.getInt("status_id"));
				task.setUserId(result.getInt("user_id"));
				task.setEndDate(result.getDate("end_date"));
				task.setStartDate(result.getDate("start_date"));

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return task;
	}
//update task by id
	public int updateById(Task task) {
		String query = "UPDATE tasks SET name =? , start_date =?, end_date=?, user_id =?, job_id=?, status_id=? WHERE id = ?";
		try {
			Connection connection = MySqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, task.getName());
			statement.setDate(2, task.getStartDate());
			statement.setDate(3, task.getEndDate());
			statement.setInt(4, task.getUserId());
			statement.setInt(5, task.getJobId());
			statement.setInt(6, task.getStatusId());
			statement.setInt(7, task.getId());
			return statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return -1;
	}
//delete task
	public int deleteById(int id) {
		String query = "delete from tasks where id =?";
		try {
			Connection connection = MySqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return -1;
	}

}
