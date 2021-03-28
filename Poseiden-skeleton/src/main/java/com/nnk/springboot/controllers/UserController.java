package com.nnk.springboot.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.domain.UserForm;
import com.nnk.springboot.services.IUserService;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/user/list")
    public String home(Model model)
    {
        model.addAttribute("users", userService.findAll());
        return "user/list";
    }

    @GetMapping("/user/add")
    public String addUser(UserForm userForm) {
        return "user/add";
    }

    @PostMapping("/user/validate")
    public String validate(@Valid UserForm userForm, BindingResult result, Model model) {
        if (!result.hasErrors()) {
        	userService.save(userForm);
            return "redirect:/user/list";
        }
        return "user/add";
    }

    @GetMapping("/user/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        User user = userService.findById(id);
        
        UserForm userForm = new UserForm();
        userForm.setId(user.getId());
        userForm.setFullname(user.getFullname());
        userForm.setUsername(user.getUsername());
        userForm.setRole(user.getRole());
        
        model.addAttribute("userForm", userForm);
        
        return "user/update";
    }

    @PostMapping("/user/update/{id}")
    public String updateUser(@PathVariable("id") Integer id, @Valid UserForm userForm,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/update";
        }

        userService.update(userForm);
        return "redirect:/user/list";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model) {
    	User user = userService.findById(id);
        userService.delete(user);
       
        return "redirect:/user/list";
    }
}
