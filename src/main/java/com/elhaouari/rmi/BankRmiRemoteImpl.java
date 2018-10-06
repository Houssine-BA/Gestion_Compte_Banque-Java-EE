package com.elhaouari.rmi;

import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.elhaouari.bank.entity.Compte;
import com.elhaouari.bank.metier.CompteMetier;
import com.elhaouari.bank.metier.OperationMetier;

@Component("rmiService")
public class BankRmiRemoteImpl implements BankRmiRemote{

	@Autowired
	private CompteMetier compteMetier;
	@Autowired
	private OperationMetier operationMetier;
	
	@Override
	public Compte saveCompte(Compte c) throws RemoteException {
		// TODO Auto-generated method stub
		return compteMetier.save(c);
	}

	@Override
	public Compte getCompte(String c) throws RemoteException {
		// TODO Auto-generated method stub
		return compteMetier.findOne(c);
	}

	@Override
	public boolean verser(String code, double montant, Long codeEmp) throws RemoteException {
		// TODO Auto-generated method stub
		return operationMetier.verser(code, montant, codeEmp);
	}

	@Override
	public boolean retirer(String code, double montant, Long codeEmp) throws RemoteException {
		// TODO Auto-generated method stub
		return operationMetier.retirer(code, montant, codeEmp);
	}

	@Override
	public boolean virement(String code1, String code2, double montant, Long codeEmp) throws RemoteException {
		// TODO Auto-generated method stub
		return operationMetier.virement(code1, code2, montant, codeEmp);
	}

}
