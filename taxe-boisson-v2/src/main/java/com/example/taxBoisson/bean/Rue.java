package com.example.taxBoisson.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class Rue  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	@ManyToOne
	private Quartier quartier;
	@OneToMany(mappedBy = "rue")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((locales == null) ? 0 : locales.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((quartier == null) ? 0 : quartier.hashCode());
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
		Rue other = (Rue) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (locales == null) {
			if (other.locales != null)
				return false;
		} else if (!locales.equals(other.locales))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (quartier == null) {
			if (other.quartier != null)
				return false;
		} else if (!quartier.equals(other.quartier))
			return false;
		return true;
	}
	
	
	
}
