package com.myclass.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	private static final String url = "jdbc:mysql://localhost:3306/crm_servlet";
	private static final String username = "root";
	private static final String password = "010820";

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO: handle driver exception
			System.out.println("========EXCEPTION========");
			System.out.println("=CAN NOT FIND THE DRIVER=");
			System.out.println(e.getMessage());
			System.out.println("=========================");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("========EXCEPTION========");
			System.out.println("==CAN NOT FIND DATABASE==");
			System.out.println(e.getMessage());
			System.out.println("=========================");
		}

		return null;
	}
}
