package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;

@Service
public class CurvePointServiceImpl implements ICurvePointService {

	private CurvePointRepository curvePointRepository;
	
	public CurvePointServiceImpl(CurvePointRepository p_curvePointRepo) {
		curvePointRepository = p_curvePointRepo;
	}
	
	@Override
	public CurvePoint save(CurvePoint curvePoint) {
		return curvePointRepository.save(curvePoint);
	}

	@Override
	public List<CurvePoint> findAll() {
		return curvePointRepository.findAll();
	}

	@Override
	public void delete(Integer id) {
		Optional<CurvePoint> curvePoint = curvePointRepository.findById(id);
		if(curvePoint.isPresent()) {
			curvePointRepository.delete(curvePoint.get());
		}
	}

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
