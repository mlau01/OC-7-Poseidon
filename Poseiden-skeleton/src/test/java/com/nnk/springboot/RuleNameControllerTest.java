package com.nnk.springboot;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.nnk.springboot.controllers.RuleNameController;
import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.services.IRuleNameService;

@RunWith(MockitoJUnitRunner.class)
public class RuleNameControllerTest {
	
	@Mock
	private IRuleNameService ruleNameService;
	
	@Mock
	private Model model;
	
	@Mock
	private RuleName ruleName;
	
	@Mock
	private BindingResult bindingResult;
	
	@InjectMocks
	private RuleNameController controller = new RuleNameController(ruleNameService);
	

	@Test
	public void ruleNameTest_shouldCallServiceList() {
		when(ruleNameService.findAll()).thenReturn(null);
		
		controller.home(model);
		
		verify(ruleNameService, Mockito.times(1)).findAll();
	}
	
	@Test
	public void ruleNameAddValidate_shouldCallServiceSave() {
		when(ruleNameService.save(ruleName)).thenReturn(ruleName);
		
		controller.validate(ruleName, bindingResult, model);
		
		verify(ruleNameService, Mockito.times(1)).save(ruleName);
	}
	
	@Test
	public void ruleNameUpdateForm_shouldCallServiceFindById() {
		when(ruleNameService.findById(anyInt())).thenReturn(ruleName);
		
		controller.showUpdateForm(anyInt(), model);
		
		verify(ruleNameService, Mockito.times(1)).findById(anyInt());
	}
	
	@Test
	public void ruleNameUpdateBid_shouldCallServiceSave() {
		when(ruleNameService.save(ruleName)).thenReturn(ruleName);
		
		controller.updateRuleName(0, ruleName, bindingResult, model);
		
		verify(ruleNameService, Mockito.times(1)).save(ruleName);
	}
	
	@Test
	public void ruleNameDelete_shouldCallServiceDelete() {
		
		controller.deleteRuleName(anyInt(), model);

		verify(ruleNameService, Mockito.times(1)).delete(anyInt());
	}
}
