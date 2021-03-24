package com.nnk.springboot.services;

import java.util.List;

import com.nnk.springboot.domain.BidList;

public interface IBidListService {

	public List<BidList> list();

	public BidList add(BidList bid);
}
