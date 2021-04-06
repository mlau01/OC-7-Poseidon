package com.nnk.springboot.integration;

import java.sql.Date;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotBlank;

import org.assertj.core.api.Assertions;
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
	
	@Test
	public void tradeConstraintTest_shouldThrowConstrainViolationException() {
		
		Trade trade1 = new Trade("", "test");
		Trade trade2 = new Trade("test", "");
		
		Assertions.assertThatExceptionOfType(ConstraintViolationException.class).isThrownBy( () -> tradeService.save(trade1));
		Assertions.assertThatExceptionOfType(ConstraintViolationException.class).isThrownBy( () -> tradeService.save(trade2));
	}
	
	@Test
	public void tradeSaveAllAttrTest_shouldSaveAllAttrCorrectly() {
		String account = "Account test";
		String type = "Type test";
		Double buyQuantity = 10d;
		Double sellQuantity = 11d;
		Double buyPrice = 12d;
		Double sellPrice = 13d;
		String benchmark = "Bench test";
		Date tradeDate = new Date(2000,5,30);
		String security = "Secu Test";
		String status = "STAT";
		String trader = "Trader  test";
		String book = "Book test";
		String creationName = "Creation";
		Date creationDate =  new Date(2000,1,30);
		String revisionName = "Rev test";
		Date revisionDate = new Date(2000,5,30);
		String dealName = "Deal test";
		String dealType = "Deal type";
		String sourceListId = "SourceId";
		String side = "Side";
		
		Trade trade = new Trade();
		
		trade.setAccount(account);
		trade.setType(type);
		trade.setBuyQuantity(buyQuantity);
		trade.setSellQuantity(sellQuantity);
		trade.setBuyPrice(buyPrice);
		trade.setSellPrice(sellPrice);
		trade.setBenchmark(benchmark);
		trade.setTradeDate(tradeDate);
		trade.setSecurity(security);
		trade.setStatus(status);
		trade.setTrader(trader);
		trade.setBook(book);
		trade.setCreationName(creationName);
		trade.setCreationDate(creationDate);
		trade.setRevisionName(revisionName);
		trade.setRevisionDate(revisionDate);
		trade.setDealName(dealName);
		trade.setDealType(dealType);
		trade.setSourceListId(sourceListId);
		trade.setSide(side);
		
		Trade savedTrade = tradeService.save(trade);
		
		Assert.assertNotNull(savedTrade.getId());
		Assert.assertEquals("account", account, savedTrade.getAccount());
		Assert.assertEquals("type", type, savedTrade.getType());
		Assert.assertEquals("buyQuantity", buyQuantity, savedTrade.getBuyQuantity());
		Assert.assertEquals("sellQuantity", sellQuantity, savedTrade.getSellQuantity());
		Assert.assertEquals("buyPrice", buyPrice, savedTrade.getBuyPrice());
		Assert.assertEquals("sellPrice", sellPrice, savedTrade.getSellPrice());
		Assert.assertEquals("benchmark", benchmark, savedTrade.getBenchmark());
		Assert.assertEquals("tradeDate", tradeDate, savedTrade.getTradeDate());
		Assert.assertEquals("security", security, savedTrade.getSecurity());
		Assert.assertEquals("status", status, savedTrade.getStatus());
		Assert.assertEquals("trader", trader, savedTrade.getTrader());
		Assert.assertEquals("book", book, savedTrade.getBook());
		Assert.assertEquals("creationName", creationName, savedTrade.getCreationName());
		Assert.assertEquals("creationDate", creationDate, savedTrade.getCreationDate());
		Assert.assertEquals("revisionName", revisionName, savedTrade.getRevisionName());
		Assert.assertEquals("revisionDate", revisionDate, savedTrade.getRevisionDate());
		Assert.assertEquals("dealName", dealName, savedTrade.getDealName());
		Assert.assertEquals("dealType", dealType, savedTrade.getDealType());
		Assert.assertEquals("sourceIdList", sourceListId, savedTrade.getSourceListId());
		Assert.assertEquals("side", side, savedTrade.getSide());
		
		tradeService.delete(savedTrade.getId());
		
	}
}
