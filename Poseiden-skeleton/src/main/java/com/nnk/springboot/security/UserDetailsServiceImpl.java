package com.nnk.springboot.security;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;

/**
 * Used by Spring Security for login
 * @author Mathias Lauer
 * 17 mars 2021
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private UserRepository userRepository;
	
	@Autowired
	public UserDetailsServiceImpl(UserRepository p_userRepo) {
		userRepository = p_userRepo;
	}
	/**
	 * Used by Spring Security for login
	 * Encapsulation of an User retrieved by User name
	 * @param username User name
	 * @return UserDetails object encapsulate the User
	 * @author Mathias Lauer
	 * 5 mars 2021
	 */
	@Override
	public UserDetails loadUserByUsername(String username){
		Objects.requireNonNull(username);
		User user = (userRepository.findAllByUsername(username)).orElseThrow(() -> new UsernameNotFoundException("User not found"));
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(user.getRole()));
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
	}
	
	

}
