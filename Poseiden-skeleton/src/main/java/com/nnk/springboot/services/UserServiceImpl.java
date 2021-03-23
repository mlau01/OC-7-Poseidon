package com.nnk.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;

@Service
public class UserServiceImpl implements IUserService {
	
	private UserRepository userRepository;
	
	
	@Autowired
	public UserServiceImpl(UserRepository p_userRepositoty) {
		userRepository = p_userRepositoty;
	}

	public User save(User user) {
		 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
         user.setPassword(encoder.encode(user.getPassword()));
         return userRepository.save(user);
	}

	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}

}
