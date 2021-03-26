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
	
	public List<BidList> list(){
		return bidListRepo.findAll();
	}

	@Override
	public BidList save(BidList bid) {
		
		return bidListRepo.save(bid);
	}

	@Override
	public Optional<BidList> get(Integer id) {
		return bidListRepo.findById(id);
	}

	@Override
	public void delete(Integer id) {
		Optional<BidList> bid = get(id);
		if(bid.isPresent()) {
			bidListRepo.delete(bid.get());
		}
		
	}

}
