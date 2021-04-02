package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import com.nnk.springboot.domain.BidList;

public interface IBidListService {

	public List<BidList> findAll();

	public BidList save(BidList bid);

	public BidList findById(Integer id);

	public void delete(Integer id);
}
