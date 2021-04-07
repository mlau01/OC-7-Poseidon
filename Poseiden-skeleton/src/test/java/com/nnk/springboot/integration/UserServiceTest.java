package com.nnk.springboot.integration;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.exceptions.PasswordPatternException;
import com.nnk.springboot.exceptions.UsernameExistException;
import com.nnk.springboot.services.IUserService;

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
		
		user = userService.save(user);

		Assert.assertNotNull(user.getId());
		
		userService.delete(user);
	}
	
	@Test
	public void userListTest_shouldReturnListOfUsers() {
		List<User> userList = userService.findAll();
		
		Assert.assertFalse(userList.isEmpty());
	}

}
