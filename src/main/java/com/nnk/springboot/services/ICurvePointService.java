package com.nnk.springboot.services;

import java.util.List;

import com.nnk.springboot.domain.CurvePoint;

public interface ICurvePointService {

	CurvePoint save(CurvePoint curvePoint);

	List<CurvePoint> findAll();

	void delete(Integer id);

	CurvePoint findById(Integer id);

}
