package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.services.ICurvePointService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class CurveController {
    
	private static Logger log = LoggerFactory.getLogger(CurveController.class);
	
	private ICurvePointService curvePointService;
	
	@Autowired
	public CurveController(ICurvePointService p_curvePointService) {
		curvePointService = p_curvePointService;
	}

    @RequestMapping("/curvePoint/list")
    public String home(Model model)
    {
    	log.info("GET Request to /curvePoint/list");
    	
        model.addAttribute("curvePointList", curvePointService.findAll());
        
        return "curvePoint/list";
    }

    @GetMapping("/curvePoint/add")
    public String addCurveForm(CurvePoint bid) {
    	log.info("GET Request to /curvePoint/add");
    	
        return "curvePoint/add";
    }

    @PostMapping("/curvePoint/validate")
    public String validate(@Valid CurvePoint curvePoint, BindingResult result, Model model) {
    	log.info("POST Request to /curvePoint/validate");
    	
    	if( ! result.hasErrors()) {
    		curvePointService.save(curvePoint);
    		return "redirect:/curvePoint/list";
    	} else {
    		return "curvePoint/add";
    	}
    }

    @GetMapping("/curvePoint/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
    	log.info("GET Request to /curvePoint/update/" + id);
    	
        CurvePoint curvePoint = curvePointService.findById(id);
        if(curvePoint != null) {
        	model.addAttribute("curvePoint", curvePoint);
        }
        
        return "curvePoint/update";
    }

    @PostMapping("/curvePoint/update/{id}")
    public String updateCurve(@PathVariable("id") Integer id, @Valid CurvePoint curvePoint,
                             BindingResult result, Model model) {
    	log.info("POST Request to /curvePoint/update/" + id);
    	
    	if( ! result.hasErrors()) {
    		curvePointService.save(curvePoint);
    	} else {
    		return "curvePoint/update";
    	}
    	
        return "redirect:/curvePoint/list";
    }

    @GetMapping("/curvePoint/delete/{id}")
    public String deleteCurve(@PathVariable("id") Integer id, Model model) {
    	log.info("GET Request to /curvePoint/delete/" + id);
    	
        curvePointService.delete(id);
        
        return "redirect:/curvePoint/list";
    }
}
