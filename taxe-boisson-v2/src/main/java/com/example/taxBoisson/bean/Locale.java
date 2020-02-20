package com.example.taxBoisson.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Locale implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String reference;
	@ManyToOne
	private Redevable redevable;
	@ManyToOne
	private Rue rue;
	private int dernierTrimPaye;
	private int dernierAnneePaye;

	
	public int getDernierTrimPaye() {
		return dernierTrimPaye;
	}
	public void setDernierTrimPaye(int dernierTrimPaye) {
		this.dernierTrimPaye = dernierTrimPaye;
	}
	public int getDernierAnneePaye() {
		return dernierAnneePaye;
	}
	public void setDernierAnneePaye(int dernierAnneePaye) {
		this.dernierAnneePaye = dernierAnneePaye;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public Redevable getRedevable() {
		return redevable;
	}
	public void setRedevable(Redevable redevable) {
		this.redevable = redevable;
	}
	public Rue getRue() {
		return rue;
	}
	public void setRue(Rue rue) {
		this.rue = rue;
	}
	
	
}
