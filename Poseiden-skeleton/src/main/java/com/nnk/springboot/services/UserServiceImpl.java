package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nnk.springboot.PasswordPatternException;
import com.nnk.springboot.UsernameExistException;
import com.nnk.springboot.domain.User;
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
	 * @throws PasswordPatternException 
	 * @throws UsernameExistException 
	 */
	public User save(User user) throws PasswordPatternException, UsernameExistException {
		if(userRepository.existsByUsername(user.getUsername())) {
			throw new UsernameExistException("This user name already exist");
		}
		
		if( ! user.getPassword().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")) {
			throw new PasswordPatternException("At least 8 chars, one digits, one uppercase and one special char");
		}

         user.setPassword(encoder.encode(user.getPassword()));
         
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
