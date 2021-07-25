package com.nnk.springboot.services;

import java.util.List;

import com.nnk.springboot.domain.Rating;

public interface IRatingService {

	Rating save(Rating rating);

	List<Rating> findAll();

	void delete(Integer id);

	Rating findById(Integer id);

}
