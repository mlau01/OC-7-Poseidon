package com.nnk.springboot;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.nnk.springboot.controllers.UserController;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.services.IUserService;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
	
	@Mock
	private IUserService userService;
	
	@Mock
	private Model model;
	
	@Mock
	private User user;
	
	@Mock
	private BindingResult bindingResult;
	
	@InjectMocks
	private UserController controller = new UserController(userService);
	
	@Before
	public void setUp() {
	}
	
	@Test
	public void userControllerListTest_shouldCallServiceList() {
		when(userService.findAll()).thenReturn(null);
		
		controller.home(model);
		
		verify(userService, Mockito.times(1)).findAll();
	}
	
	@Test
	public void userControllerValidateAddTest_shouldCallServiceSave() throws PasswordPatternException, UsernameExistException {
		when(userService.save(any(User.class))).thenReturn(null);
		
		controller.validate(user, bindingResult, model);
		
		verify(userService, Mockito.times(1)).save(any(User.class));
	}
	
	@Test
	public void userControllerUpdateFormTest_shouldCallServiceUpdateForm()  {
		when(userService.findById(anyInt())).thenReturn(user);
		
		controller.showUpdateForm(anyInt(), model);
		
		verify(userService, Mockito.times(1)).findById(anyInt());
	}
	
	@Test
	public void userControllerUpdateTest_shouldCallServiceUpdateUser() throws PasswordPatternException, UsernameExistException  {
		when(userService.save(user)).thenReturn(user);
		
		controller.updateUser(0, user, bindingResult, model);
		
		verify(userService, Mockito.times(1)).save(user);
	}
	
	@Test
	public void userControllereDeleteTest_shouldCallServiceUpdateUser() throws PasswordPatternException, UsernameExistException  {
		when(userService.findById(anyInt())).thenReturn(user);
		
		controller.deleteUser(0, model);
		
		verify(userService, Mockito.times(1)).delete(user);
	}
}
