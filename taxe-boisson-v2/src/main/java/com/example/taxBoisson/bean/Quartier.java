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
public class Quartier  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nom;
	@OneToMany(mappedBy = "quartier")
	private List<Rue> rues;
	@ManyToOne
	private Secteur secteur;
	
	public Secteur getSecteur() {
		return secteur;
	}
	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Rue> getRues() {
		return rues;
	}
	public void setRues(List<Rue> rues) {
		this.rues = rues;
	}
	
	public Quartier(long id, String nom, List<Rue> rues, Secteur secteur) {
		super();
		this.id = id;
		this.nom = nom;
		this.rues = rues;
		this.secteur = secteur;
	}
	public Quartier() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Quartier [id=" + id + ", nom=" + nom + ", rues=" + rues + ", secteur=" + secteur + "]";
	}
	
	
	
}
