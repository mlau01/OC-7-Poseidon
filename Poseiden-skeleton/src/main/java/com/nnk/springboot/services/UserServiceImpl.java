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

	/**
	 * Save an User in database based on the form data given
	 * @param userForm UserForm object
	 * @return User object saved in data base if successful
	 * @author Mathias Lauer
	 * 28 mars 2021
	 */
	public User save(UserForm userForm) {
		User user = new User();
		user.setFullname(userForm.getFullname());
		user.setUsername(userForm.getUsername());
		user.setRole(userForm.getRole());

		user.setPassword(encoder.encode(userForm.getPassword()));
		
		return userRepository.save(user);
	}
	
	/**
	 * Update an user datas based on the form data given
	 * @param userForm UserForm object
	 * @return User object updated in data base if successful
	 * @author Mathias Lauer
	 * 28 mars 2021
	 */
	public User update(UserForm userForm) {
		User user = new User();
		user.setId(userForm.getId());
		user.setFullname(userForm.getFullname());
		user.setUsername(userForm.getUsername());
		user.setRole(userForm.getRole());

		user.setPassword(encoder.encode(userForm.getPassword()));
		
		return userRepository.save(user);
	}

	/**
	 * Delete an user
	 * @param User object to delete
	 * @author Mathias Lauer
	 * 28 mars 2021
	 */
	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}

	/**
	 * List of all user
	 * @return List<User>
	 * @author Mathias Lauer
	 * 28 mars 2021
	 */
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	/**
	 * Find a specific user.
	 * @param id User ID.
	 * @return User object if found, null otherwise.
	 * @author Mathias Lauer
	 * 28 mars 2021
	 */
	@Override
	public User findById(Integer id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}

}
