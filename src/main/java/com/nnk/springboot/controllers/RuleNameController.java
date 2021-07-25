package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.services.IRuleNameService;

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
public class RuleNameController {
    
	private static Logger log = LoggerFactory.getLogger(RuleNameController.class);
	
	private IRuleNameService ruleNameService;

	@Autowired
    public RuleNameController(IRuleNameService p_ruleNameService) {
		ruleNameService = p_ruleNameService;
	}

	@RequestMapping("/ruleName/list")
    public String home(Model model)
    {
    	log.info("GET Request to /ruleName/list");
    	
        model.addAttribute("ruleNameList", ruleNameService.findAll());
        
        return "ruleName/list";
    }

    @GetMapping("/ruleName/add")
    public String addRuleForm(RuleName bid) {
    	log.info("GET Request to /ruleName/add");
    	
        return "ruleName/add";
    }

    @PostMapping("/ruleName/validate")
    public String validate(@Valid RuleName ruleName, BindingResult result, Model model) {
    	log.info("POST Request to /ruleName/validate");
    	
        if(! result.hasErrors()) {
        	ruleNameService.save(ruleName);
        }
        else {
        	return "ruleName/add";
        }
        
        return "redirect:/ruleName/list";
    }

    @GetMapping("/ruleName/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
    	log.info("GET Request to /ruleName/update/" + id);
    	
        RuleName ruleName = ruleNameService.findById(id);
        if(ruleName != null) {
        	model.addAttribute("ruleName", ruleName);
        }
        
        return "ruleName/update";
    }

    @PostMapping("/ruleName/update/{id}")
    public String updateRuleName(@PathVariable("id") Integer id, @Valid RuleName ruleName,
                             BindingResult result, Model model) {
    	log.info("POST Request to /ruleName/update/" + id);
    	
        if(! result.hasErrors()) {
        	ruleNameService.save(ruleName);
        }
        else {
        	return "ruleName/update";
        }
        
        return "redirect:/ruleName/list";
    }

    @GetMapping("/ruleName/delete/{id}")
    public String deleteRuleName(@PathVariable("id") Integer id, Model model) {
    	log.info("GET Request to /ruleName/delete/" + id);
    	
        ruleNameService.delete(id);
        
        return "redirect:/ruleName/list";
    }
}
