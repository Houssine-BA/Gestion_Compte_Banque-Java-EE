package com.elhaouari.bank.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.elhaouari.bank.entity.Compte;
import com.elhaouari.bank.metier.CompteMetier;
import com.elhaouari.bank.metier.OperationMetier;
import com.elhaouari.bank.metier.PageOperation;

@Component
@WebService
public class BankSoapService {

	@Autowired
	private CompteMetier compteMetier;
	@Autowired
	private OperationMetier operationMetier;
	
	@WebMethod
	public boolean verser(
			@WebParam(name="code") String code, 
			@WebParam(name="montant") double montant, 
			@WebParam(name="codeEmp") Long codeEmp) {
		return operationMetier.verser(code, montant, codeEmp);
	}
	@WebMethod
	public boolean retirer(
			@WebParam(name="code") String code, 
			@WebParam(name="montant") double montant, 
			@WebParam(name="codeEmp") Long codeEmp) {
		return operationMetier.retirer(code, montant, codeEmp);
	}
	@WebMethod
	public boolean virement(
			@WebParam(name="code1") String code1, 
			@WebParam(name="code2") String code2, 
			@WebParam(name="montant") double montant, 
			@WebParam(name="codeEmp") Long codeEmp) {
		return operationMetier.virement(code1, code2, montant, codeEmp);
	}
	@WebMethod
	public PageOperation operations(
			@WebParam(name="compte") String compte, 
			@WebParam(name="page") int page, 
			@WebParam(name="size") int size) {
		return operationMetier.operations(compte, page, size);
	}
	
	
	
	public Compte save(Compte e) {
		return compteMetier.save(e);
	}
	public List<Compte> list() {
		return compteMetier.list();
	}
	@WebMethod
	public Compte findOne(String code) {
		return compteMetier.findOne(code);
	}
	
	
}
