package com.elhaouari.bank.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="CC")
public class CompteCourant extends Compte{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6185593297279324828L;
	private double decouvert;

	public CompteCourant() {
	}

	public CompteCourant(String code, Date dateCreateion, double solde, double decouvert) {
		super(code, dateCreateion, solde);
		this.decouvert = decouvert;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	
	
}
