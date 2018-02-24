package com.cts;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cts.annotation.HelloWorldConfig;

public class MainApp {
   public static void main(String[] args) {
	   ConfigurableApplicationContext context	   = new ClassPathXmlApplicationContext("Beans.xml");
  //ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfig.class);	   
// context.register(AppConfig.class, OtherConfig.class);
 //  context.register(AdditionalConfig.class);
   	   
 //context.start();
      HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
    
      obj.getMessage();
      obj.setMessage("Swarup ");
      obj.getMessage();
      
      HelloWorld obj1 = (HelloWorld) context.getBean("helloWorld");
      HelloWorld obj2 = (HelloWorld) context.getBean("helloWorld");
      HelloWorld obj3 = (HelloWorld) context.getBean("helloWorld");
      HelloWorld obj4= (HelloWorld) context.getBean("helloWorld");
      obj1.getMessage();
      

     //context.stop();
   }
}