package com.journaldev.spring.resolver;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class MySimpleMappingExceptionResolver extends
		SimpleMappingExceptionResolver {

	@Override
	public String buildLogMessage(Exception ex, HttpServletRequest request) {
		logger.info("Spring MVC exception: " + ex.getLocalizedMessage());
        return "Spring MVC exception: " + ex.getLocalizedMessage();
    }
}
