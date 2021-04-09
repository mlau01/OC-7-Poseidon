package com.nnk.springboot.controllers;

import javax.validation.Valid;

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

import com.nnk.springboot.domain.Bid;
import com.nnk.springboot.services.IBidService;


@Controller
public class BidController {
	
	private static Logger log = LoggerFactory.getLogger(BidController.class);
    
	private IBidService bidService;
	
	@Autowired
	public BidController(IBidService p_bidService) {
		bidService = p_bidService;
	}

    @RequestMapping("/bid/list")
    public String home(Model model)
    {
    	log.info("GET Request to /bid/list");
    	
        model.addAttribute("bids", bidService.findAll());
        
        return "bid/list";
    }

    @GetMapping("/bid/add")
    public String addBidForm(Bid bid) {
    	log.info("GET Request to /bid/add");
    	
        return "bid/add";
    }

    @PostMapping("/bid/validate")
    public String validate(@Valid Bid bid, BindingResult result, Model model) {
    	log.info("POST Request to /bid/validate");
    	
    	if(result.hasErrors()) {
    		return "bid/add";
    	}
    	else {
    		bidService.save(bid);
    	}
        
    	return "redirect:/bid/list";
    }

    @GetMapping("/bid/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
    	log.info("GET Request to /bid/update/" + id);
    	
        Bid obid = bidService.findById(id);
        if(obid != null) {
        	model.addAttribute("bid", obid);
        }
        
        return "bid/update";
    }

    @PostMapping("/bid/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid Bid bid,
                             BindingResult result, Model model) {
    	log.info("POST Request to /bid/update/" + id);
    	
        if( ! result.hasErrors()) {
        	bidService.save(bid);
        } else {
        	return "bid/update";
        }
        
        return "redirect:/bid/list";
    }

    @GetMapping("/bid/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
    	log.info("GET Request to /bid/delete/" + id);
    	
        bidService.delete(id);
        
        return "redirect:/bid/list";
    }
}
