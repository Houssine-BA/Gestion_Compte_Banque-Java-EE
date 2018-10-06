package com.elhaouari.bank.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.elhaouari.bank.entity.Compte;
import com.elhaouari.bank.metier.CompteMetier;

@RestController
public class CompteRestService {
	@Autowired
	private CompteMetier metier;

	@RequestMapping(value="/comptes", method=RequestMethod.POST)
	public Compte save(@RequestBody Compte e) {
		
		return metier.save(e);
	}

	@RequestMapping(value="/comptes", method=RequestMethod.GET)
	public List<Compte> list() {
		return metier.list();
	}

	@RequestMapping(value="/comptes/{code}", method=RequestMethod.GET)
	public Compte findOne(@PathVariable("code") String code) {
		return metier.findOne(code);
	}
	
}
