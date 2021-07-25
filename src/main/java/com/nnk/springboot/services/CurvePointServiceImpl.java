package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.controllers.BidController;
import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;

@Service
public class CurvePointServiceImpl implements ICurvePointService {

	private static Logger log = LoggerFactory.getLogger(CurvePointServiceImpl.class);
	
	private CurvePointRepository curvePointRepository;
	
	@Autowired
	public CurvePointServiceImpl(CurvePointRepository p_curvePointRepo) {
		curvePointRepository = p_curvePointRepo;
	}
	
	/**
	 * Save a curve point in data base
	 * @param curve point to save
	 * @return curve point saved if successful
	 * @author Mathias Lauer
	 * 28 mars 2021
	 */
	@Override
	public CurvePoint save(CurvePoint curvePoint) {
		return curvePointRepository.save(curvePoint);
	}

	/**
	 * List all curve points
	 * @return List<CurvePoint> curve point list
	 * @author Mathias Lauer
	 * 28 mars 2021
	 */
	@Override
	public List<CurvePoint> findAll() {
		return curvePointRepository.findAll();
	}

	/**
	 * Delete a specific curve point
	 * @param id curve point ID to delete
	 * @author Mathias Lauer
	 * 28 mars 2021
	 */
	@Override
	public void delete(Integer id) {
		Optional<CurvePoint> curvePoint = curvePointRepository.findById(id);
		if(curvePoint.isPresent()) {
			log.info("Deleting CurvePoint id:" + id);
			curvePointRepository.delete(curvePoint.get());
		} else {
			log.error("Error deleting CurvePoint id not found: " + id);
		}
	}

	/**
	 * Get a specific curve point
	 * @param id curve point ID
	 * @return CurvePoint object or null if not found
	 * @author Mathias Lauer
	 * 28 mars 2021
	 */
	@Override
	public CurvePoint findById(Integer id) {
		Optional<CurvePoint> curvePoint = curvePointRepository.findById(id);
		if(curvePoint.isPresent()) {
			return curvePoint.get();
		} else {
			return null;
		}
	}

}
