package com.nnk.springboot.integration;

import java.sql.Date;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.services.IBidListService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BidTests {

	@Autowired
	private IBidListService bidListService;

	@Test
	public void bidListCrudTest_shouldProcessAllCrudFeatures() {
		BidList bid = new BidList("Account Test", "Type Test", 10d);

		// Save
		bid = bidListService.save(bid);
		Assert.assertNotNull(bid.getId());
		Assert.assertEquals(bid.getBidQuantity(), 10d, 10d);

		// Update
		bid.setBidQuantity(20d);
		bid = bidListService.save(bid);
		Assert.assertEquals(bid.getBidQuantity(), 20d, 20d);

		// Find
		List<BidList> listResult = bidListService.findAll();
		Assert.assertTrue(listResult.size() > 0);

		// Delete
		Integer id = bid.getId();
		bidListService.delete(id);
		BidList bidList = bidListService.findById(id);
		Assert.assertNull(bidList);
	}
	
	@Test
	public void bidListConstrainTest_shouldThrowConstrainViolationException() {
		BidList bid1 = new BidList("test", "", 10d);
		BidList bid2 = new BidList("", "test", 10d);
		BidList bid3 = new BidList("test", "test", 10.001d);
		
		Assertions.assertThatExceptionOfType(ConstraintViolationException.class).isThrownBy( () -> bidListService.save(bid1));
		Assertions.assertThatExceptionOfType(ConstraintViolationException.class).isThrownBy( () -> bidListService.save(bid2));
		Assertions.assertThatExceptionOfType(ConstraintViolationException.class).isThrownBy( () -> bidListService.save(bid3));
		
	}
	
	
	@Test
	public void BidListAllAttrTest_shouldSaveAllAttrCorrectly() {
		// Prepare
		String account = "Account test";
		String type = "Type test";
		Double bidQuantity = 10d;
		Double askQuantity = 11d;
		Double bid = 12d;
		Double ask = 13d;
		String benchmark = "Bench test";
		Date bidListDate = new Date(2000,5,30);
		String commentary = "Comm test";
		String security = "Secu test";
		String status = "test_st";
		String trader = "Trader test";
		String book = "Book test";
		String creationName = "Test";
		Date creationDate = new Date(2000,5,30);
		String revisionName = "Test";
		Date revisionDate = new Date(2000,5,30);
		String dealName = "Deal test";
		String dealType = "Deal type";
		String sourceListId = "Source test";
		String side = "Side test";
		
		BidList bidList = new BidList(account, type, bidQuantity);
		bidList.setAskQuantity(askQuantity);
		bidList.setAsk(ask);
		bidList.setBid(bid);
		bidList.setBenchmark(benchmark);
		bidList.setBidListDate(bidListDate);
		bidList.setCommentary(commentary);
		bidList.setSecurity(security);
		bidList.setStatus(status);
		bidList.setTrader(trader);
		bidList.setBook(book);
		bidList.setCreationName(creationName);
		bidList.setCreationDate(creationDate);
		bidList.setRevisionName(revisionName);
		bidList.setRevisionDate(revisionDate);
		bidList.setDealName(dealName);
		bidList.setDealType(dealType);
		bidList.setSourceListId(sourceListId);
		bidList.setSide(side);

		// Save
		BidList bidSaved = bidListService.save(bidList);
		
		// Assert
		Assert.assertNotNull(bidSaved.getId());
		Assert.assertEquals("Account", account, bidSaved.getAccount());
		Assert.assertEquals("Type", type, bidSaved.getType());
		Assert.assertEquals("bidQuantity", bidQuantity, bidSaved.getBidQuantity());
		Assert.assertEquals("askQuantity", askQuantity, bidSaved.getAskQuantity());
		Assert.assertEquals("bid", bid, bidSaved.getBid());
		Assert.assertEquals("ask", ask, bidSaved.getAsk());
		Assert.assertEquals("benchmark", benchmark, bidSaved.getBenchmark());
		Assert.assertEquals("bidListDate", bidListDate, bidSaved.getBidListDate());
		Assert.assertEquals("commentary", commentary, bidSaved.getCommentary());
		Assert.assertEquals("security", security, bidSaved.getSecurity());
		Assert.assertEquals("status", status, bidSaved.getStatus());
		Assert.assertEquals("trader", trader, bidSaved.getTrader());
		Assert.assertEquals("book", book, bidSaved.getBook());
		Assert.assertEquals("creationName", creationName, bidSaved.getCreationName());
		Assert.assertEquals("creationDate", creationDate, bidSaved.getCreationDate());
		Assert.assertEquals("revisionName", revisionName, bidSaved.getRevisionName());
		Assert.assertEquals("revisionDate", revisionDate, bidSaved.getRevisionDate());
		Assert.assertEquals("dealName", dealName, bidSaved.getDealName());
		Assert.assertEquals("dealType", dealType, bidSaved.getDealType());
		Assert.assertEquals("sourceListId", sourceListId, bidSaved.getSourceListId());
		Assert.assertEquals("side", side, bidSaved.getSide());
		
		// Clean
		bidListService.delete(bidSaved.getId());
	}
}
