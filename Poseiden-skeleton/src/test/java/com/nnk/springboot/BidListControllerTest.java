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
import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.services.IBidListService;

@RunWith(MockitoJUnitRunner.class)
public class BidListControllerTest {
	
	@Mock
	private IBidListService bidListService;
	
	@Mock
	private Model model;
	
	@Mock
	private BidList bidList;
	
	@Mock
	private BindingResult bindingResult;
	
	@InjectMocks
	private BidListController controller = new BidListController(bidListService);
	

	@Test
	public void bidListTest_shouldCallServiceList() {
		when(bidListService.findAll()).thenReturn(null);
		
		controller.home(model);
		
		verify(bidListService, Mockito.times(1)).findAll();
	}
	
	@Test
	public void bidListAddValidate_shouldCallServiceSave() {
		when(bidListService.save(bidList)).thenReturn(bidList);
		
		controller.validate(bidList, bindingResult, model);
		
		verify(bidListService, Mockito.times(1)).save(bidList);
	}
	
	@Test
	public void bidListUpdateForm_shouldCallServiceFindById() {
		when(bidListService.findById(anyInt())).thenReturn(bidList);
		
		controller.showUpdateForm(anyInt(), model);
		
		verify(bidListService, Mockito.times(1)).findById(anyInt());
	}
	
	@Test
	public void bidListUpdateBid_shouldCallServiceSave() {
		when(bidListService.save(bidList)).thenReturn(bidList);
		
		controller.updateBid(0, bidList, bindingResult, model);
		
		verify(bidListService, Mockito.times(1)).save(bidList);
	}
	
	@Test
	public void bidListDelete_shouldCallServiceDelete() {
		
		controller.deleteBid(anyInt(), model);

		verify(bidListService, Mockito.times(1)).delete(anyInt());
	}
}
