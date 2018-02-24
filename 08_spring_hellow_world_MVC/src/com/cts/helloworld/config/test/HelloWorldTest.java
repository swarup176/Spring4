package com.cts.helloworld.config.test;




import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cts.helloworld.config.AppConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class HelloWorldTest {
	@Autowired
	private Environment environment;
	

    @Test
    public void test_ml_always_return_true() {
    	
    	assertNotNull("my.name is null.",
    			environment.getProperty("my.name"));


    }
}