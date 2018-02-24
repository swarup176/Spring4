package cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cts.domain.Course;
import cts.exception.SpringException;
import cts.model.student.Registration;
import cts.service.AppService;

@Controller
public class AppController {

	@Autowired
	private AppService service;

	public void setService(AppService service) {
		this.service = service;
	}

	@ModelAttribute("courses")
	public List<Course> getAllCourses() {
		return service.getAllCourses();
	}

	@RequestMapping(value = "/load-form")
	public String loadForm(Model model, Registration registration) {
		model.addAttribute("registration", registration);
		return "registration";
	}

	@RequestMapping(value = "/add-form")
	@ExceptionHandler(SpringException.class)
	public String addStudent(@ModelAttribute("registration") Registration registration, ModelMap model) {
		try {
			if (registration.getName().length() < 5) {
				throw new SpringException("Given name is too short");
			} else {
				model.addAttribute("name", registration.getName());
			}
			if (registration.getAge() < 10) {
				throw new SpringException("Given age is too low");
			} else {
				model.addAttribute("age", registration.getAge());
			}
		} catch (Exception exception) {
			if(exception instanceof SpringException){
				throw exception;
			}else{
			throw new SpringException("Custom exception to catch allother exception");
			}
		}
		model.addAttribute("id", registration.getRollNo());
		service.addStudent(registration);
		return "success";
	}
}