package com.elhaouari.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.elhaouari.bank.entity.Compte;

public interface BankRmiRemote extends Remote{

	public Compte saveCompte(Compte c) throws RemoteException;
	public Compte getCompte(String c) throws RemoteException;
	
	public boolean verser(String code, double montant, Long codeEmp) throws RemoteException;
	public boolean retirer(String code, double montant, Long codeEmp) throws RemoteException;
	public boolean virement(String code1, String code2, double montant, Long codeEmp) throws RemoteException;
}
