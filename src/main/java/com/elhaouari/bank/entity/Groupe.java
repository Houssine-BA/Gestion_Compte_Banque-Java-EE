package com.elhaouari.bank.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Groupe implements Serializable{
	private static final long serialVersionUID = 1755815567430668143L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numero;
	private String nom;
	@ManyToMany(mappedBy="groupes")
	private Collection<Employe> employes;
	
	public Groupe() {
		super();
	}
	
	public Groupe(String nom) {
		super();
		this.nom = nom;
	}

	public Groupe(String nom, Collection<Employe> employes) {
		super();
		this.nom = nom;
		this.employes = employes;
	}

	public Groupe(Long numero, String nom, Collection<Employe> employes) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.employes = employes;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(Collection<Employe> employes) {
		this.employes = employes;
	}
	
	
}
