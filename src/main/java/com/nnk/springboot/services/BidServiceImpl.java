package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.Bid;
import com.nnk.springboot.repositories.BidRepository;

@Service
public class BidServiceImpl implements IBidService {
	
	private BidRepository bidRepo;
	
	@Autowired
	public BidServiceImpl(BidRepository p_bidRepo) {
		bidRepo = p_bidRepo;
	}
	
	/**
	 * List all Bids
	 * @return List<bid> bid list
	 * @author Mathias Lauer
	 * 28 mars 2021
	 */
	public List<Bid> findAll(){
		return bidRepo.findAll();
	}

	/**
	 * Save a bid in data base
	 * @param bid to save
	 * @return bid saved if successful
	 * @author Mathias Lauer
	 * 28 mars 2021
	 */
	@Override
	public Bid save(Bid bid) {
		
		return bidRepo.save(bid);
	}

	/**
	 * Get a specific bid
	 * @param id Bid ID
	 * @return bid found or null otherwise
	 * @author Mathias Lauer
	 * 28 mars 2021
	 */
	@Override
	public Bid findById(Integer id) {
		Optional<Bid> bid = bidRepo.findById(id);
		if(bid.isPresent())
		{
			return bid.get();
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
		Bid bid = findById(id);
		if(bid != null) {
			bidRepo.delete(bid);
		}
		
	}

}
