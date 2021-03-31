package com.nnk.springboot.integration;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.services.ITradeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TradeTests {

	@Autowired
	private ITradeService tradeService;

	@Test
	public void tradeTest() {
		Trade trade = new Trade("Trade Account", "Type");

		// Save
		trade = tradeService.save(trade);
		Assert.assertNotNull(trade.getId());
		Assert.assertTrue(trade.getAccount().equals("Trade Account"));

		// Update
		trade.setAccount("Trade Account Update");
		trade = tradeService.save(trade);
		Assert.assertTrue(trade.getAccount().equals("Trade Account Update"));

		// Find
		List<Trade> listResult = tradeService.findAll();
		Assert.assertTrue(listResult.size() > 0);

		// Delete
		Integer id = trade.getId();
		tradeService.delete(id);
		trade = tradeService.findById(id);
		Assert.assertNull(trade);
	}
}
