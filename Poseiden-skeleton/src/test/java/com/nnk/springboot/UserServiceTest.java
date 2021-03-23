package com.nnk.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.services.IUserService;

import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	IUserService userService;
	
	@Test
	public void userSaveTest_shouldReturnCreatedUser() {
		User user = new User();
		user.setFullname("tester");
		user.setUsername("test");
		user.setPassword("test");
		user.setRole("USER");
		
		User savedUser = userService.save(user);
		
		Assert.assertNotNull(savedUser.getId());
		
		userService.delete(savedUser);
	}

}
