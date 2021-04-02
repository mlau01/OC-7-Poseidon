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
import com.nnk.springboot.controllers.RatingController;
import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.services.IBidListService;
import com.nnk.springboot.services.IRatingService;

@RunWith(MockitoJUnitRunner.class)
public class RatingControllerTest {
	
	@Mock
	private IRatingService ratingService;
	
	@Mock
	private Model model;
	
	@Mock
	private Rating rating;
	
	@Mock
	private BindingResult bindingResult;
	
	@InjectMocks
	private RatingController controller = new RatingController(ratingService);
	

	@Test
	public void ratingTest_shouldCallServiceList() {
		when(ratingService.findAll()).thenReturn(null);
		
		controller.home(model);
		
		verify(ratingService, Mockito.times(1)).findAll();
	}
	
	@Test
	public void ratingAddValidate_shouldCallServiceSave() {
		when(ratingService.save(rating)).thenReturn(rating);
		
		controller.validate(rating, bindingResult, model);
		
		verify(ratingService, Mockito.times(1)).save(rating);
	}
	
	@Test
	public void ratingUpdateForm_shouldCallServiceFindById() {
		when(ratingService.findById(anyInt())).thenReturn(rating);
		
		controller.showUpdateForm(anyInt(), model);
		
		verify(ratingService, Mockito.times(1)).findById(anyInt());
	}
	
	@Test
	public void ratingUpdateBid_shouldCallServiceSave() {
		when(ratingService.save(rating)).thenReturn(rating);
		
		controller.updateRating(0, rating, bindingResult, model);
		
		verify(ratingService, Mockito.times(1)).save(rating);
	}
	
	@Test
	public void ratingDelete_shouldCallServiceDelete() {
		
		controller.deleteRating(anyInt(), model);

		verify(ratingService, Mockito.times(1)).delete(anyInt());
	}
}
