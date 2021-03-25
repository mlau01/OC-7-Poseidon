package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.services.IBidListService;

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

import java.util.Optional;

import javax.validation.Valid;


@Controller
public class BidListController {
	
	private static Logger log = LoggerFactory.getLogger(BidListController.class);
    
	private IBidListService bidListService;
	
	@Autowired
	public BidListController(IBidListService p_bidListService) {
		bidListService = p_bidListService;
	}

    @RequestMapping("/bidList/list")
    public String home(Model model)
    {
    	log.info("GET Request to /bidList/list");
        model.addAttribute("bidlist", bidListService.list());
        return "bidList/list";
    }

    @GetMapping("/bidList/add")
    public String addBidForm(BidList bid) {
    	log.info("GET Request to /bidList/add");
        return "bidList/add";
    }

    @PostMapping("/bidList/validate")
    public String validate(@Valid BidList bid, BindingResult result, Model model) {
    	log.info("POST Request to /bidList/validate");
    	if(result.hasErrors()) {
    		return "bidList/add";
    	}
    	else {
    		bidListService.save(bid);
    	}
        
    	return "bidList/list";
    }

    @GetMapping("/bidList/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
    	log.info("GET Request to /bidList/update/" + id);
        Optional<BidList> obid = bidListService.get(id);
        if(obid.isPresent()) {
        	model.addAttribute("bidList", obid.get());
        }
        return "bidList/update";
    }

    @PostMapping("/bidList/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid BidList bidList,
                             BindingResult result, Model model) {
    	log.info("POST Request to /bidList/update/" + id);
        if( ! result.hasErrors()) {
        	bidListService.save(bidList);
        } else {
        	return "bidList/update";
        }
        return "redirect:/bidList/list";
    }

    @GetMapping("/bidList/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
    	log.info("GET Request to /bidList/delete/" + id);
        bidListService.delete(id);
        return "redirect:/bidList/list";
    }
}
