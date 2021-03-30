package com.nnk.springboot.services;

import java.util.List;

import com.nnk.springboot.PasswordPatternException;
import com.nnk.springboot.domain.User;

public interface IUserService {

	User save(User user) throws PasswordPatternException;

	void delete(User savedUser);
	public User findById(Integer id) ;
	public List<User> findAll();
}
