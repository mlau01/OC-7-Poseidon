package com.nnk.springboot.services;

import com.nnk.springboot.domain.User;

public interface IUserService {

	User save(User user);

	void delete(User savedUser);

}
