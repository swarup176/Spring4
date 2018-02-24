package com.cts.SpringMVC;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.servlet.ModelAndView;  
@Controller  
public class HelloWorldController {  
	@Autowired
	private Environment environment;
	@Value("${my.name}")
	private  String name;
	
	@Value("${destinationLocation:c:/temp/output}")
	private String destination;
    @RequestMapping("/hello")  
    public ModelAndView helloWorld() {  
    	System.out.println("Getting property via Spring Environment :"
				+ environment.getProperty("my.name"));
    	System.out.println("Destination Location : " + destination);
    	System.out.println("Name " + name);
        String message = "HELLO SPRING MVC HOW R U";  
        return new ModelAndView("hello", "message", message);  
    }  
}  