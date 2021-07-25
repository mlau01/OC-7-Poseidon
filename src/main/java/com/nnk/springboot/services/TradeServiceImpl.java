package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;

@Service
public class TradeServiceImpl implements ITradeService {

	private TradeRepository tradeRepository;
	
	@Autowired
	public TradeServiceImpl(TradeRepository p_tradeRepository) {
		tradeRepository = p_tradeRepository;
	}
	
	/**
	 * Save a trade in data base
	 * @param trade to save
	 * @return Trade object saved if successful
	 * @author Mathias Lauer
	 * 28 mars 2021
	 */
	@Override
	public Trade save(Trade trade) {
		return tradeRepository.save(trade);
	}

	/**
	 * List all trades
	 * @return List<Trade> trade list
	 * @author Mathias Lauer
	 * 28 mars 2021
	 */
	@Override
	public List<Trade> findAll() {
		return tradeRepository.findAll();
	}

	/**
	 * Get a specific trade
	 * @param id trade ID
	 * @return Trade object if found, null otherwise.
	 * @author Mathias Lauer
	 * 28 mars 2021
	 */
	@Override
	public Trade findById(Integer id) {
		Optional<Trade> trade = tradeRepository.findById(id);
		if(trade.isPresent()) {
			return trade.get();
		}
		return null;
	}

	/**
	 * Delete a specific trade
	 * @param id trade ID to delete
	 * @author Mathias Lauer
	 * 28 mars 2021
	 */
	@Override
	public void delete(Integer id) {
		Trade trade = findById(id);
		if(trade != null) {
			tradeRepository.delete(trade);
		}

	}

}
