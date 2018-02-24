package com.cts.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cts.HelloWorld;



public class HelloWorldConfig1 {
  @Bean 
 //@Scope("prototype")  // singleton  prototype
   public HelloWorld helloWorld(){
	   HelloWorld h=   new HelloWorld();
	   h.setMessage("HI I am hellowworld");
      return h;
   }
   
}