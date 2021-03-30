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
	
	/**
	 * Save a rating in data base
	 * @param rating to save
	 * @return rating saved if successful
	 * @author Mathias Lauer
	 * 28 mars 2021
	 */
	@Override
	public Rating save(Rating rating) {
		return ratingRepository.save(rating);
	}

	/**
	 * List all ratings
	 * @return List<Rating> rating list
	 * @author Mathias Lauer
	 * 28 mars 2021
	 */
	@Override
	public List<Rating> findAll() {
		return ratingRepository.findAll();
	}

	/**
	 * Delete a specific rating
	 * @param id rating ID to delete
	 * @author Mathias Lauer
	 * 28 mars 2021
	 */
	@Override
	public void delete(Integer id) {
		Rating rating = findById(id);
		if(rating != null) {
			ratingRepository.delete(rating);
		}

	}

	/**
	 * Get a specific rating
	 * @param id rating ID
	 * @return Rating object if successful or null otherwise.
	 * @author Mathias Lauer
	 * 28 mars 2021
	 */
	@Override
	public Rating findById(Integer id) {
		Optional<Rating> rating = ratingRepository.findById(id);
		if(rating.isPresent()) {
			return rating.get();
		}
		return null;
	}

}
