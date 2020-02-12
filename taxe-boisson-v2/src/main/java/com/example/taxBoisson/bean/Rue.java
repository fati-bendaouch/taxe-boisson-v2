package com.example.taxBoisson.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Rue  implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	@ManyToOne
	private Quartier quartier;
	@OneToMany(mappedBy = "locale")
	private List<Locale> locales;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Quartier getQuartier() {
		return quartier;
	}
	public void setQuartier(Quartier quartier) {
		this.quartier = quartier;
	}
	public List<Locale> getLocales() {
		return locales;
	}
	public void setLocales(List<Locale> locales) {
		this.locales = locales;
	}
	public Rue(Long id, String nom, Quartier quartier, List<Locale> locales) {
		super();
		this.id = id;
		this.nom = nom;
		this.quartier = quartier;
		this.locales = locales;
	}
	public Rue() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Rue [id=" + id + ", nom=" + nom + ", quartier=" + quartier + ", locales=" + locales + "]";
	}
	
	
}
