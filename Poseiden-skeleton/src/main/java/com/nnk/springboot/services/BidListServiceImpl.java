package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;

@Service
public class BidListServiceImpl implements IBidListService {
	
	
	private BidListRepository bidListRepo;
	
	@Autowired
	public BidListServiceImpl(BidListRepository p_bidListRepo) {
		bidListRepo = p_bidListRepo;
	}
	
	/**
	 * List all Bids
	 * @return List<BidList> bid list
	 * @author Mathias Lauer
	 * 28 mars 2021
	 */
	public List<BidList> findAll(){
		return bidListRepo.findAll();
	}

	/**
	 * Save a bid in data base
	 * @param bid to save
	 * @return bid saved if successful
	 * @author Mathias Lauer
	 * 28 mars 2021
	 */
	@Override
	public BidList save(BidList bid) {
		
		return bidListRepo.save(bid);
	}

	/**
	 * Get a specific bid
	 * @param id Bid ID
	 * @return BidList found or null otherwise
	 * @author Mathias Lauer
	 * 28 mars 2021
	 */
	@Override
	public BidList findById(Integer id) {
		Optional<BidList> bidList = bidListRepo.findById(id);
		if(bidList.isPresent())
		{
			return bidList.get();
		}
		
		return null;
	}

	/**
	 * Delete a specific bid
	 * @param id Bid ID to delete
	 * @author Mathias Lauer
	 * 28 mars 2021
	 */
	@Override
	public void delete(Integer id) {
		BidList bid = findById(id);
		if(bid != null) {
			bidListRepo.delete(bid);
		}
		
	}

}
