package com.cts.annotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(HelloWorldConfig1.class)
public class HelloWorldConfig {
  
   
}