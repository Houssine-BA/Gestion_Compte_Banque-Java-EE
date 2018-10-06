package com.elhaouari.bank.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

@Entity
@DiscriminatorValue(value="V")
@XmlType(name="V")
public class Versement extends Operation{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1222227602775687210L;

	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Versement(Date date, double montant, Compte compte, Employe employe) {
		super(date, montant, compte, employe);
		// TODO Auto-generated constructor stub
	}

	public Versement(Date date, double montant) {
		super(date, montant);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Versement";
	}

}
