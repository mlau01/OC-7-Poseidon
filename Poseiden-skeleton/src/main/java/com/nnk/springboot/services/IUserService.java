package com.nnk.springboot.services;

import java.util.List;

import javax.validation.Valid;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.domain.UserForm;

public interface IUserService {

	User save(UserForm userForm);

	void delete(User savedUser);

	List<User> findAll();

	User findById(Integer id);

	User update(@Valid UserForm userForm);

}
