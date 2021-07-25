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

import com.nnk.springboot.controllers.TradeController;
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.services.ITradeService;

@RunWith(MockitoJUnitRunner.class)
public class TradeControllerTest {
	
	@Mock
	private ITradeService tradeService;
	
	@Mock
	private Model model;
	
	@Mock
	private Trade trade;
	
	@Mock
	private BindingResult bindingResult;
	
	@InjectMocks
	private TradeController controller = new TradeController(tradeService);
	

	@Test
	public void tradeTest_shouldCallServiceList() {
		when(tradeService.findAll()).thenReturn(null);
		
		controller.home(model);
		
		verify(tradeService, Mockito.times(1)).findAll();
	}
	
	@Test
	public void tradeAddValidate_shouldCallServiceSave() {
		when(tradeService.save(trade)).thenReturn(trade);
		
		controller.validate(trade, bindingResult, model);
		
		verify(tradeService, Mockito.times(1)).save(trade);
	}
	
	@Test
	public void tradeUpdateForm_shouldCallServiceFindById() {
		when(tradeService.findById(anyInt())).thenReturn(trade);
		
		controller.showUpdateForm(anyInt(), model);
		
		verify(tradeService, Mockito.times(1)).findById(anyInt());
	}
	
	@Test
	public void tradeUpdateBid_shouldCallServiceSave() {
		when(tradeService.save(trade)).thenReturn(trade);
		
		controller.updateTrade(0, trade, bindingResult, model);
		
		verify(tradeService, Mockito.times(1)).save(trade);
	}
	
	@Test
	public void tradeDelete_shouldCallServiceDelete() {
		
		controller.deleteTrade(anyInt(), model);

		verify(tradeService, Mockito.times(1)).delete(anyInt());
	}
}
