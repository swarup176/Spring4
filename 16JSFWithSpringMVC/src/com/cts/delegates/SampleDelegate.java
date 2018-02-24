package com.cts.delegates;

public class SampleDelegate {
	
	public boolean testCredentials(String id, String password) {
		// Call the relevant service/dao here 
		// to validate the credentials
		System.out.println("I am inside Spring 3");
		return true;
	}

}
