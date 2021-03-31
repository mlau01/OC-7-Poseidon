package com.nnk.springboot;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.services.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserTests {

	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private static UserServiceImpl userService;
	 
	
	@Test
	public void userSaveWithBadPasswordPattern_shouldThrowPasswordPatternException() throws PasswordPatternException {
		
		when(userRepository.existsByUsername(anyString())).thenReturn(false);
		
		User user = new User();
		user.setFullname("tester");
		user.setUsername("test");
		user.setPassword("Test");
		user.setRole("USER");

		Assertions.assertThatExceptionOfType(PasswordPatternException.class).isThrownBy( () -> userService.save(user));
		
		verify(userRepository, Mockito.times(1)).existsByUsername(anyString());
	}
	
	@Test
	public void userSaveWithExistingUsername_shouldThrowUsernameExistException() {
		when(userRepository.existsByUsername(anyString())).thenReturn(true);
		
		User user = new User();
		user.setFullname("tester");
		user.setUsername("admin");
		user.setPassword("Test");
		user.setRole("USER");
		
		Assertions.assertThatExceptionOfType(UsernameExistException.class).isThrownBy( () -> userService.save(user));
		
		verify(userRepository, Mockito.times(1)).existsByUsername(anyString());
	}
}
