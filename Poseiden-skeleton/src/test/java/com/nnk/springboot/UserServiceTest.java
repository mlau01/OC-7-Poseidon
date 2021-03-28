package com.nnk.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.domain.UserForm;
import com.nnk.springboot.services.IUserService;

import java.util.List;

import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	IUserService userService;
	
	@Test
	public void userSaveTest_shouldReturnCreatedUser() {
		UserForm userForm = new UserForm();
		userForm.setFullname("tester");
		userForm.setUsername("test");
		userForm.setPassword("test");
		userForm.setRole("USER");
		
		User savedUser = userService.save(userForm);
		
		
		
		Assert.assertNotNull(savedUser.getId());
		
		userService.delete(savedUser);
	}
	
	@Test
	public void userListTest_shouldReturnListOfUsers() {
		List<User> userList = userService.findAll();
		
		Assert.assertFalse(userList.isEmpty());
	}

}
