package com.example.taxBoisson.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((rues == null) ? 0 : rues.hashCode());
		result = prime * result + ((secteur == null) ? 0 : secteur.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quartier other = (Quartier) obj;
		if (id != other.id)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (rues == null) {
			if (other.rues != null)
				return false;
		} else if (!rues.equals(other.rues))
			return false;
		if (secteur == null) {
			if (other.secteur != null)
				return false;
		} else if (!secteur.equals(other.secteur))
			return false;
		return true;
	}
	
	
	
}
