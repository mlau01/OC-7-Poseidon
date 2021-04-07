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

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
   		Objects.requireNonNull(username);
		
		//Getting user via Spring Data JPA
		User user = (userRepository.findByUsername(username))
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		
		//Set authorities
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(user.getRole()));
		
		//Return a Spring Security User object
		return new org.springframework.security.core.userdetails
				.User(user.getUsername(), user.getPassword(), 
						true, true, true, true, authorities);
	}

}
