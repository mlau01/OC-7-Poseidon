package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import com.nnk.springboot.domain.Bid;

public interface IBidService {

	public List<Bid> findAll();

	public Bid save(Bid bid);

	public Bid findById(Integer id);

	public void delete(Integer id);
}
