package com.elhaouari.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.elhaouari.bank.entity.Employe;
import com.elhaouari.bank.metier.EmployeMetier;

@RestController
public class EmployeService {

	@Autowired
	private EmployeMetier metier;

	@RequestMapping(value="/employes", method=RequestMethod.POST)
	public Employe save(@RequestBody Employe e) {
		return metier.save(e);
	}

	@RequestMapping(value="/employes", method=RequestMethod.GET)
	public List<Employe> list() {
		return metier.list();
	}
	
	
}
