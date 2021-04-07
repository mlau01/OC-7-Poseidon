package com.nnk.springboot.security;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
        	//UserDetailsService anonymous implementation
            .userDetailsService(new UserDetailsService() {
            	@Override
            	public UserDetails loadUserByUsername(String username){
            		Objects.requireNonNull(username);
            		User user = (userRepository.findByUsername(username)).orElseThrow(() -> new UsernameNotFoundException("User not found"));
            		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
            		authorities.add(new SimpleGrantedAuthority(user.getRole()));
            		
            		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
            	}
            	
            })
            .passwordEncoder(new BCryptPasswordEncoder());
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
        authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/login").permitAll()
        .antMatchers("/user/**").hasAuthority("ADMIN").anyRequest()
        .authenticated().and().csrf().disable().formLogin()
        .failureUrl("/login?error=true")
        .defaultSuccessUrl("/bidList/list")
        .and().logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/app-logout"))
        .logoutSuccessUrl("/login").and()
        .exceptionHandling()
        .accessDeniedPage("/app/error");
	}
}
