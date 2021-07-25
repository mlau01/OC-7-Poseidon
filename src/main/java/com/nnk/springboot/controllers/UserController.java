package com.nnk.springboot.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.exceptions.PasswordPatternException;
import com.nnk.springboot.exceptions.UsernameExistException;
import com.nnk.springboot.services.IUserService;

@Controller
public class UserController {
	private static Logger log = LoggerFactory.getLogger(UserController.class);

    private IUserService userService;
    
    @Autowired
    public UserController(IUserService p_userService) {
		userService = p_userService;
	}

    @RequestMapping("/user/list")
    public String home(Model model)
    {
    	log.info("GET Request to /user/list");
    	
        model.addAttribute("users", userService.findAll());
        
        return "user/list";
    }

    @GetMapping("/user/add")

    public String addUser(User bid) {
    	log.info("GET Request to /user/add");
    	
        return "user/add";
    }

    @PostMapping("/user/validate")

    public String validate(@Valid User user, BindingResult result, Model model) {
    	log.info("POST Request to /user/validate");
    	
        if (result.hasErrors()) {
        	return "user/add";
        }
        
        try {
			userService.save(user);
		} catch (PasswordPatternException e) {
			log.info("POST Request to /user/validate, error: " + e.getMessage());
			result.addError(new FieldError("password", "password", e.getMessage()));
	        return "user/add";
		} catch (UsernameExistException e) {
			log.info("POST Request to /user/validate, error: " + e.getMessage());
			result.addError(new FieldError("username", "username", e.getMessage()));
			return "user/add";
		}
        
        return "redirect:/user/list";
    }

    @GetMapping("/user/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
    	log.info("GET Request to /user/update/" + id);
    	
        User user = userService.findById(id);
        if(user != null) {
	        user.setPassword("");
	        model.addAttribute("user", user);
        }
        
        return "user/update";
    }

    @PostMapping("/user/update/{id}")
    public String updateUser(@PathVariable("id") Integer id, @Valid User user,
                             BindingResult result, Model model) {
    	log.info("POST Request to /user/update/" + id);
    	
        if (result.hasErrors()) {
            return "user/update";
        }

        try {
			userService.save(user);
		} catch (PasswordPatternException e) {
			log.info("POST Request to /user/update" + id + ", error: " + e.getMessage());
			result.addError(new FieldError("password", "password", e.getMessage()));
			return "user/update";
		} catch (UsernameExistException e) {
			log.info("POST Request to /user/update" + id + ", error: " + e.getMessage());
			result.addError(new FieldError("username", "username", e.getMessage()));
			return "user/update";
		}
        
        return "redirect:/user/list";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model) {
    	log.info("GET Request to /user/delete/" + id);
    	
        User user = userService.findById(id);
        if(user != null) {
        	userService.delete(user);
        }
   
        return "redirect:/user/list";
    }
}
