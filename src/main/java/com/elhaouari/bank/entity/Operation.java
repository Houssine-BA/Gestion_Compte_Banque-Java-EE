package com.elhaouari.bank.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;



@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_COMPTE", discriminatorType=DiscriminatorType.STRING, length=1)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="type")
@JsonSubTypes({
	@Type(name="V", value=Versement.class),
	@Type(name="R", value=Retrait.class)
})
@XmlSeeAlso({ Versement.class, Retrait.class })
public abstract class Operation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8001934757934821877L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numero;
	private Date date;
	private double montant;
	@JsonIgnore
	@XmlTransient
	@ManyToOne
	private Compte compte;
	@ManyToOne
	private Employe employe;
	
	public Operation() {
		super();
	}
	
	public Operation(Date date, double montant) {
		super();
		this.date = date;
		this.montant = montant;
	}

	public Operation(Date date, double montant, Compte compte, Employe employe) {
		super();
		this.date = date;
		this.montant = montant;
		this.compte = compte;
		this.employe = employe;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	
	public abstract String getType();
}
