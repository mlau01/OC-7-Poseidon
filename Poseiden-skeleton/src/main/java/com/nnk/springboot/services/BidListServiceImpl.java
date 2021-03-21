package com.nnk.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;

import java.util.List;

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

}
