package com.example.taxBoisson.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Secteur implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	@OneToMany(mappedBy = "secteur")
	//private List<Quartier> quartiers;
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
	/*public List<Quartier> getQuartiers() {
		return quartiers;
	}*/
	/*public void setQuartiers(List<Quartier> quartiers) {
		this.quartiers = quartiers;
	}*/
	public Secteur(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
		//this.quartiers = quartiers;
	}
	public Secteur() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Secteur [id=" + id + ", nom=" + nom + ", quartiers=" +"]";
	}
	}
