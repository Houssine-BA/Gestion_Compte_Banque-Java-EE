package com.elhaouari.bank.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4611753133506918787L;
	private double taux;

	
	public CompteEpargne() {
		super();
	}

	public CompteEpargne(String code, Date dateCreateion, double solde, double taux) {
		super(code, dateCreateion, solde);
		this.taux = taux;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	
	
}
