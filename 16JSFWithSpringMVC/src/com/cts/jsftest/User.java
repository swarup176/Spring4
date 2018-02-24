package com.cts.jsftest;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.jsf.FacesContextUtils;

import com.cts.delegates.SampleDelegate;


public class User {
	
	private String id;
	private String password;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String login() {
		String outcome = "";
		
		/*ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		*/
		ApplicationContext context = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		
		SampleDelegate delegate = (SampleDelegate) context.getBean("sampleDelegate");
		if (delegate.testCredentials(id, password)) {
			outcome = "loginSuccessful";
		}
		
		return outcome;
	}

}
