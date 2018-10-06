package com.elhaouari.bank.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Employe implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2376919349937770350L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long code;
	private String nom;
	@ManyToOne
	@JoinColumn(name="CODE_EMP_SUP")
	private Employe employeSup;
	@ManyToMany
	@JoinTable(
			name="EMPL_GR",
			joinColumns=@JoinColumn(name="CODE_EMP"),
			inverseJoinColumns=@JoinColumn(name="CODE_GR")
	)
	private Collection<Groupe> groupes;
	
	public Employe() {
		super();
	}
	public Employe(String nom) {
		this.nom = nom;
	}
	public Employe(String nom, Employe employeSup, Collection<Groupe> groupes) {
		super();
		this.nom = nom;
		this.employeSup = employeSup;
		this.groupes = groupes;
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
	public Employe getEmployeSup() {
		return employeSup;
	}
	public void setEmployeSup(Employe employeSup) {
		this.employeSup = employeSup;
	}
	public Collection<Groupe> getGroupes() {
		return groupes;
	}
	public void setGroupes(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}
	
	
}
