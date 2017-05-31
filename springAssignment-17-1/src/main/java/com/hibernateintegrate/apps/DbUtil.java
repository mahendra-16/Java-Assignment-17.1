package com.hibernateintegrate.apps;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class DbUtil {

	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void initialize(){
		DataSource dataSource = getDataSource();
		try {
			Connection conn = dataSource.getConnection();
			Statement statement = conn.createStatement();
			statement.executeUpdate("create table person(id integer Not Null, name varchar(50), email varchar(100))");
			statement.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
