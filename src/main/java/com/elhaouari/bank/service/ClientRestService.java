package com.elhaouari.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.elhaouari.bank.entity.Client;
import com.elhaouari.bank.metier.ClientMetier;

@RestController
public class ClientRestService {

	@Autowired
	private ClientMetier metier;

	@RequestMapping(value="/clients", method=RequestMethod.POST)
	public Client save(@RequestBody Client c) {
		return metier.save(c);
	}

	@RequestMapping(value="/clients", method=RequestMethod.GET)
	public List<Client> list() {
		return metier.list();
	}
	
	
}
