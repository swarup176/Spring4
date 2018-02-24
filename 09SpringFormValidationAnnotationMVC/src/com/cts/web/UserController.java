package com.cts.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.cts.domain.User;
import com.cts.service.UserService;
import com.cts.validator.UserValidator;

@Controller
@RequestMapping("/userRegistration.htm")
@SessionAttributes("user")
@EnableWebMvc
public class UserController {

	private UserService userService;
	private UserValidator userValidator;

	@Autowired
	public UserController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return "userForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit( @ModelAttribute("user")   @Valid User user,
			BindingResult result) {
		//userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "userForm";
		} else {
			userService.add(user);
			return "redirect:userSuccess.htm";
		}
	}
	
	@Autowired
	private UserValidator validator;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.setValidator(validator);
	}

}
