package com.nnk.springboot.services;

import java.util.List;

import com.nnk.springboot.domain.Trade;

public interface ITradeService {

	Trade save(Trade trade);

	List<Trade> findAll();

	Trade findById(Integer id);
	
	void delete(Integer id);
}
