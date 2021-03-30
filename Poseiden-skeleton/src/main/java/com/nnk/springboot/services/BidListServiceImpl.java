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
	public List<BidList> list(){
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
	 * @return Optional<BidList>
	 * @author Mathias Lauer
	 * 28 mars 2021
	 */
	@Override
	public Optional<BidList> get(Integer id) {
		return bidListRepo.findById(id);
	}

	/**
	 * Delete a specific bid
	 * @param id Bid ID to delete
	 * @author Mathias Lauer
	 * 28 mars 2021
	 */
	@Override
	public void delete(Integer id) {
		Optional<BidList> bid = get(id);
		if(bid.isPresent()) {
			bidListRepo.delete(bid.get());
		}
		
	}

}
