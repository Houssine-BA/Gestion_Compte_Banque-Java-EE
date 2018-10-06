package com.elhaouari.bank.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE", discriminatorType=DiscriminatorType.STRING, length=2)

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="type")
@JsonSubTypes({
	@Type(name="CC", value=CompteCourant.class),
	@Type(name="CE", value=CompteEpargne.class)
})
public abstract class Compte implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4619617186150838577L;
	@Id 
	private String code;
	private Date dateCreateion;
	private double solde;
	@ManyToOne
	private Client client;
	@ManyToOne
	private Employe employe;
	@JsonIgnore
	@OneToMany(mappedBy="compte")
	private Collection<Operation> operations;
	
	public Compte() {
		super();
	}
	

	public Compte(Date dateCreateion, double solde) {
		super();
		this.dateCreateion = dateCreateion;
		this.solde = solde;
	}


	public Compte(String code, Date dateCreateion, double solde) {
		super();
		this.code = code;
		this.dateCreateion = dateCreateion;
		this.solde = solde;
	}


	public Compte(String code, Date dateCreateion, double solde, Client client, Employe employe,
			Collection<Operation> operations) {
		super();
		this.code = code;
		this.dateCreateion = dateCreateion;
		this.solde = solde;
		this.client = client;
		this.employe = employe;
		this.operations = operations;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public Date getDateCreateion() {
		return dateCreateion;
	}


	public void setDateCreateion(Date dateCreateion) {
		this.dateCreateion = dateCreateion;
	}


	public double getSolde() {
		return solde;
	}


	public void setSolde(double solde) {
		this.solde = solde;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Employe getEmploye() {
		return employe;
	}


	public void setEmploye(Employe employe) {
		this.employe = employe;
	}


	public Collection<Operation> getOperations() {
		return operations;
	}


	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}
	
	
}
