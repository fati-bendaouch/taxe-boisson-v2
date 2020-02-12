package com.example.taxBoisson.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class TauxTaxeBoisson implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Categorie categorie;
	private double pourcentageBase;
	private double pourcentageRetard;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getPourcentageBase() {
		return pourcentageBase;
	}
	public void setPourcentageBase(double pourcentageBase) {
		this.pourcentageBase = pourcentageBase;
	}
	public double getPourcentageRetard() {
		return pourcentageRetard;
	}
	public void setPourcentageRetard(double pourcentageRetard) {
		this.pourcentageRetard = pourcentageRetard;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
	public TauxTaxeBoisson() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
