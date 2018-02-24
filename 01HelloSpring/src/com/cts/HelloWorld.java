package com.cts;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component

public class HelloWorld {
   private String message;

   public void setMessage(String message){
      this.message  = message;
   }
   public void getMessage(){
      System.out.println("Your Message : " + message);
   }
   @PostConstruct
   void testPostConstruct(){
	   System.out.println(" I am hello world PostConstruct");
   }
   
   @PreDestroy
   void testPreDestroy(){
	   System.out.println(" I am hello world PreDestroy");
   }
}