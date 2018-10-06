package com.elhaouari.bank.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

@Entity
@DiscriminatorValue(value="R")
@XmlType(name="R")
public class Retrait extends Operation{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3490783262923727176L;

	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retrait(Date date, double montant, Compte compte, Employe employe) {
		super(date, montant, compte, employe);
		// TODO Auto-generated constructor stub
	}

	public Retrait(Date date, double montant) {
		super(date, montant);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getType() {
		return "Retrait";
	}

}
