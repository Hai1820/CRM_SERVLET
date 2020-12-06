package com.myclass.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.myclass.db.MySqlConnection;
import com.myclass.entity.Job;

public class JobRepository {

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
				job.setStartDate(result.getDate("start_date"));
				job.setEndDate(result.getDate("end_date"));
				jobs.add(job);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return jobs;
	}

	public int save(Job job) {
		String query = "insert into jobs (name, start_date,start_date) values (?,?,?)";
		try {
			Connection connection = MySqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, job.getName());
			statement.setDate(2, job.getStartDate());
			statement.setDate(3, job.getEndDate());
			return statement.executeUpdate();

		} catch (Exception e) {
			e.getMessage();
		}
		return -1;

	}

}
