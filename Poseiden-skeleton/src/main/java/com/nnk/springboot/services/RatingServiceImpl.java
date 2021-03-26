package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;

@Service
public class RatingServiceImpl implements IRatingService {

	private RatingRepository ratingRepository;
	
	@Autowired
	public RatingServiceImpl(RatingRepository p_ratingRepository) {
		ratingRepository = p_ratingRepository;
	}
	
	@Override
	public Rating save(Rating rating) {
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> findAll() {
		return ratingRepository.findAll();
	}

	@Override
	public void delete(Integer id) {
		Rating rating = findById(id);
		if(rating != null) {
			ratingRepository.delete(rating);
		}

	}

	@Override
	public Rating findById(Integer id) {
		Optional<Rating> rating = ratingRepository.findById(id);
		if(rating.isPresent()) {
			return rating.get();
		}
		return null;
	}

}
