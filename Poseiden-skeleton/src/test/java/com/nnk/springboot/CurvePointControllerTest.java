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

import com.nnk.springboot.controllers.BidListController;
import com.nnk.springboot.controllers.CurveController;
import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.services.IBidListService;
import com.nnk.springboot.services.ICurvePointService;

@RunWith(MockitoJUnitRunner.class)
public class CurvePointControllerTest {
	
	@Mock
	private ICurvePointService curvePointService;
	
	@Mock
	private Model model;
	
	@Mock
	private CurvePoint curvePoint;
	
	@Mock
	private BindingResult bindingResult;
	
	@InjectMocks
	private CurveController controller = new CurveController(curvePointService);
	

	@Test
	public void curveListTest_shouldCallServiceList() {
		when(curvePointService.findAll()).thenReturn(null);
		
		controller.home(model);
		
		verify(curvePointService, Mockito.times(1)).findAll();
	}
	
	@Test
	public void curveAddValidateTest_shouldCallServiceSave() {
		when(curvePointService.save(curvePoint)).thenReturn(curvePoint);
		
		controller.validate(curvePoint, bindingResult, model);
		
		verify(curvePointService, Mockito.times(1)).save(curvePoint);
	}
	
	@Test
	public void curvePointUpdateFormTest_shouldCallServiceFindById() {
		when(curvePointService.findById(anyInt())).thenReturn(curvePoint);
		
		controller.showUpdateForm(anyInt(), model);
		
		verify(curvePointService, Mockito.times(1)).findById(anyInt());
	}
	
	@Test
	public void curveUpdateValidateTest_shouldCallServiceSave() {
		when(curvePointService.save(curvePoint)).thenReturn(curvePoint);
		
		controller.updateCurve(0, curvePoint, bindingResult, model);
		
		verify(curvePointService, Mockito.times(1)).save(curvePoint);
	}
	
	@Test
	public void curvePointDeleteTest_shouldCallServiceFindById() {
		controller.deleteCurve(anyInt(), model);
		
		verify(curvePointService, Mockito.times(1)).delete(anyInt());
	}
}
