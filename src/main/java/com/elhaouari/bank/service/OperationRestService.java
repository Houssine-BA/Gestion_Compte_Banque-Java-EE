package com.elhaouari.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elhaouari.bank.metier.OperationMetier;
import com.elhaouari.bank.metier.PageOperation;

@RestController
public class OperationRestService {

	@Autowired
	private OperationMetier operationMetier;

	@RequestMapping(value="/operations/{compte}", method=RequestMethod.GET)
	public PageOperation operations(
			@PathVariable String compte, 
			@RequestParam int page, 
			@RequestParam int size) {
		return operationMetier.operations(compte, page, size);
	}

	@RequestMapping(value="/versement", method=RequestMethod.PUT)
	public boolean verser(
			@RequestParam String code,
			@RequestParam double montant,
			@RequestParam Long codeEmp) {
		return operationMetier.verser(code, montant, codeEmp);
	}

	@RequestMapping(value="/retrait", method=RequestMethod.PUT)
	public boolean retirer(
			@RequestParam String code,
			@RequestParam double montant,
			@RequestParam Long codeEmp) {
		
		return operationMetier.retirer(code, montant, codeEmp);
	}

	@RequestMapping(value="/virement", method=RequestMethod.PUT)
	public boolean virement(
			@RequestParam String code1,
			@RequestParam String code2,
			@RequestParam double montant,
			@RequestParam Long codeEmp) {
		
		return operationMetier.virement(code1, code2, montant, codeEmp);
		
	}
	
	
}
