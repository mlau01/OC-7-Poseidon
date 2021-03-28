package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.domain.UserForm;
import com.nnk.springboot.repositories.UserRepository;

@Service
public class UserServiceImpl implements IUserService {
	
	private UserRepository userRepository;
	private BCryptPasswordEncoder encoder;
	
	
	@Autowired
	public UserServiceImpl(UserRepository p_userRepositoty) {
		userRepository = p_userRepositoty;
		encoder = new BCryptPasswordEncoder();
	}

	public User save(UserForm userForm) {
		User user = new User();
		user.setFullname(userForm.getFullname());
		user.setUsername(userForm.getUsername());
		user.setRole(userForm.getRole());

		user.setPassword(encoder.encode(userForm.getPassword()));
		
		return userRepository.save(user);
	}
	
	public User update(UserForm userForm) {
		User user = new User();
		user.setId(userForm.getId());
		user.setFullname(userForm.getFullname());
		user.setUsername(userForm.getUsername());
		user.setRole(userForm.getRole());

		user.setPassword(encoder.encode(userForm.getPassword()));
		
		return userRepository.save(user);
	}

	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(Integer id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}

}
