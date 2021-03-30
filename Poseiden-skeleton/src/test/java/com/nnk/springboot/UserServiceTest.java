package com.nnk.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.services.IUserService;

import org.assertj.core.api.Assertions;
import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	IUserService userService;
	
	@Test
	public void userSaveTest_shouldReturnCreatedUser() throws PasswordPatternException, UsernameExistException {
		User user = new User();
		user.setFullname("tester");
		user.setUsername("test");
		user.setPassword("Testtest1!");
		user.setRole("USER");
		
		User savedUser = userService.save(user);
		
		Assert.assertNotNull(savedUser.getId());
		
		userService.delete(savedUser);
	}
	
	@Test
	public void userSaveWithBadPasswordPattern_shouldThrowPasswordPatternException() throws PasswordPatternException {
		User user = new User();
		user.setFullname("tester");
		user.setUsername("test");
		user.setPassword("Test");
		user.setRole("USER");
		
		Assertions.assertThatExceptionOfType(PasswordPatternException.class).isThrownBy( () -> userService.save(user));
	}
	
	@Test
	public void userSaveWithExistingUsername_shouldThrowUsernameExistException() {
		User user = new User();
		user.setFullname("tester");
		user.setUsername("admin");
		user.setPassword("Test");
		user.setRole("USER");
		
		Assertions.assertThatExceptionOfType(UsernameExistException.class).isThrownBy( () -> userService.save(user));
	}
	
	
}
