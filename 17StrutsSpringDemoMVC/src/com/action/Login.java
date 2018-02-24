package com.action;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.cts.delegates.SampleDelegate;

public class Login {

	private String message;
	private DataSource dataSource;
	private SampleDelegate sampleDelegate;

	public SampleDelegate getSampleDelegate() {
		return sampleDelegate;
	}

	public void setSampleDelegate(SampleDelegate sampleDelegate) {
		this.sampleDelegate = sampleDelegate;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String execute() throws Exception {
		System.out.println("dataSource::"+dataSource.getConnection());
		sampleDelegate.testCredentials();
		ArrayList  ar = checkValidUser("SCOTT");
		System.out.println("Size is::"+ar.size());
		if(ar.size()==0){
			return "failure";
		}
        return "SUCCESS";
    }
	
	private ArrayList checkValidUser(String  userID) {
		ArrayList<User> ar = new ArrayList<User>();
		
		System.out.println("user ID::"+userID);		
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);		
		String query = "select * from dba_users where USERNAME=? ";
		return (ArrayList) jdbcTemplate.queryForList(query, new Object[] {userID});
		
	}
	
	
}
