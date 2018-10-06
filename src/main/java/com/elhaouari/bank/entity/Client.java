package com.elhaouari.bank.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7378279061848407862L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long code;
	private String nom;
	private String address;
	@JsonIgnore
	@XmlTransient
	@OneToMany(mappedBy="client", fetch=FetchType.LAZY)
	private Collection<Compte> comptes;
	
	public Client() {
		super();
	}

	public Client(String nom, String address) {
		super();
		this.nom = nom;
		this.address = address;
	}

	public Client(Long code, String nom, String address) {
		super();
		this.code = code;
		this.nom = nom;
		this.address = address;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Collection<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
	
	
}
