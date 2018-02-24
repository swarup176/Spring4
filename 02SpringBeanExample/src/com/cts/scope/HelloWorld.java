package com.cts.scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class HelloWorld {
   private String message;

   public void setMessage(String message){
      this.message  = message;
   }
   public void getMessage(){
      System.out.println("Your Message : " + message);
   }
   @PostConstruct
   void postInit(){
	   System.out.println("I am post costruct");
   }
   
   @PreDestroy
   void preInit(){
	   System.out.println("I am pre destroy");
   }
}