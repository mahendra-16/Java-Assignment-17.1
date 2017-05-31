package com.hibernateintegrate.apps;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;


public class PersonDAOimpl implements PersonDAO {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public List<Person> selectALL() {
		// TODO Auto-generated method stub
		String selectAllSql = "Select * From person";
		return getJdbcTemplate().query(selectAllSql, new ResultSetExtractor<List<Person>>(){
			@Override
			public List<Person> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub

				List<Person> list = new ArrayList<Person>(); 
				while(rs.next()){
					Person person = new Person();
					person.setId(rs.getInt(1));
					person.setName(rs.getString(2));
					person.setEmail(rs.getString(3));		
					list.add(person);
				}
				
				return list;
		     	}
			
	     	});

		}

	public void insertPerson(Person person) {
		// TODO Auto-generated method stub
		String sql = "insert into person(id, name, email) values(?, ?, ?)";
		int id = person.getId();
		String name = person.getName();
		String email = person.getEmail();
		getJdbcTemplate().update(sql, new Object[]{id,name,email}); 
		
	}

}
