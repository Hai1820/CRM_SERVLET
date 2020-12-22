package com.myclass.common.helper;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimeHelper {
	
	public static Date convertStringToSQLDate(String date) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			java.sql.Date sqlDate = 
					new java.sql.Date(
							df
							.parse(date)
							.getTime());
			
			return sqlDate;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
