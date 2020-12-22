package com.myclass.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.myclass.db.MySqlConnection;
import com.myclass.entity.Job;

public class JobRepository {
//method save to add new job to database 
	public int save(Job job) {
		String query = "insert into jobs (name, start_date,end_date) values (?,?,?)";
		try {
			Connection connection = MySqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, job.getName());
			statement.setDate(2, job.getStartDate());
			statement.setDate(3, job.getEndDate());
			return statement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;

	}
// method getAllJob to get list job
	public List<Job> getAllJob() {
		List<Job> jobs = new LinkedList<Job>();
		String query = "select * from jobs";
		try {
			Connection connection = MySqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Job job = new Job();
				job.setId(result.getInt("id"));
				job.setName(result.getString("name"));
				job.setEndDate(result.getDate("end_date"));
				job.setStartDate(result.getDate("start_date"));
				jobs.add(job);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return jobs;
	}
// method findById to get job by id
	public Job findById(int id) {
		Job job = new Job();
		String query = "select * from jobs where id =?";
		try {
			Connection connection = MySqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				job.setId(result.getInt("id"));
				job.setName(result.getString("name"));
				job.setEndDate(result.getDate("end_date"));
				job.setStartDate(result.getDate("start_date"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return job;
	}
// method updateJobById to update job
	public int updateJobById(Job job) {
		String query = "UPDATE jobs SET name =?, start_date =?, end_date=? WHERE id = ?";
		try {
			Connection connection = MySqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, job.getName());
			statement.setDate(2, job.getStartDate());
			statement.setDate(3, job.getEndDate());
			statement.setInt(4, job.getId());
			return statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return -1;
	}

	public int deleteById(int id) {
		// TODO Auto-generated method stub
		String query = "delete from jobs where id =?";
		try {
			Connection connection = MySqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return -1;
	}

}
