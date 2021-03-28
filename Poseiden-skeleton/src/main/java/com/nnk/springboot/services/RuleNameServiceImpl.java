package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;

@Service
public class RuleNameServiceImpl implements IRuleNameService {

	private RuleNameRepository ruleNameRepository;
	
	public RuleNameServiceImpl(RuleNameRepository p_ruleNameRepository) {
		ruleNameRepository = p_ruleNameRepository;
	}
	
	/**
	 * Save a rule name in data base
	 * @param rule name to save
	 * @return RuleName saved if successful
	 * @author Mathias Lauer
	 * 28 mars 2021
	 */
	@Override
	public RuleName save(RuleName rule) {
		return ruleNameRepository.save(rule);
	}

	/**
	 * List all rule names
	 * @return List<RuleName> rule name list
	 * @author Mathias Lauer
	 * 28 mars 2021
	 */
	@Override
	public List<RuleName> findAll() {
		return ruleNameRepository.findAll();
	}

	/**
	 * Delete a specific rule name
	 * @param id rule name ID to delete
	 * @author Mathias Lauer
	 * 28 mars 2021
	 */
	@Override
	public void delete(Integer id) {
		RuleName ruleName = findById(id);
		if(ruleName != null) {
			ruleNameRepository.delete(ruleName);
		}

	}

	/**
	 * Get a specific rule name
	 * @param id rule name ID
	 * @return RuleName object if found, null otherwise
	 * @author Mathias Lauer
	 * 28 mars 2021
	 */
	@Override
	public RuleName findById(Integer id) {
		Optional<RuleName> ruleName = ruleNameRepository.findById(id);
		if(ruleName.isPresent()) {
			return ruleName.get();
		}
		return null;
	}

}
