package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.services.ITradeService;

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
public class TradeController {
    
	private static Logger log = LoggerFactory.getLogger(TradeController.class);
	
	@Autowired
	ITradeService tradeService;

    @RequestMapping("/trade/list")
    public String home(Model model)
    {
    	log.info("GET Request to /trade/list");
        model.addAttribute("tradeList", tradeService.findAll());
        return "trade/list";
    }

    @GetMapping("/trade/add")
    public String addUser(Trade bid) {
    	log.info("GET Request to /trade/add");
        return "trade/add";
    }

    @PostMapping("/trade/validate")
    public String validate(@Valid Trade trade, BindingResult result, Model model) {
    	log.info("POST Request to /trade/validate");
        if(! result.hasErrors()) {
        	tradeService.save(trade);
        }
        else {
        	return "trade/add";	
        }
        
        return "redirect:/trade/list";
    }

    @GetMapping("/trade/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
    	log.info("GET Request to /trade/update/" + id);
    	Trade trade = tradeService.findById(id);
    	if(trade != null) {
    		model.addAttribute("trade", trade);
    	}
        return "trade/update";
    }

    @PostMapping("/trade/update/{id}")
    public String updateTrade(@PathVariable("id") Integer id, @Valid Trade trade,
                             BindingResult result, Model model) {
    	log.info("POST Request to /trade/update/" + id);
        if( ! result.hasErrors()) {
        	tradeService.save(trade);
        } else {
        	return "trade/update";
        }
        return "redirect:/trade/list";
    }

    @GetMapping("/trade/delete/{id}")
    public String deleteTrade(@PathVariable("id") Integer id, Model model) {
    	log.info("GET Request to /trade/delete/" + id);
        tradeService.delete(id);
        return "redirect:/trade/list";
    }
}
