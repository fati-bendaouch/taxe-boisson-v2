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
@ManyToOne
	private Categorie categorie;
	
	/**
 * @return the categorie
 */
public Categorie getCategorie() {
	return categorie;
}
/**
 * @param categorie the categorie to set
 */
public void setCategorie(Categorie categorie) {
	this.categorie = categorie;
}
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dernierAnneePaye;
		result = prime * result + dernierTrimPaye;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((redevable == null) ? 0 : redevable.hashCode());
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
		result = prime * result + ((rue == null) ? 0 : rue.hashCode());
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
		Locale other = (Locale) obj;
		if (dernierAnneePaye != other.dernierAnneePaye)
			return false;
		if (dernierTrimPaye != other.dernierTrimPaye)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (redevable == null) {
			if (other.redevable != null)
				return false;
		} else if (!redevable.equals(other.redevable))
			return false;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		if (rue == null) {
			if (other.rue != null)
				return false;
		} else if (!rue.equals(other.rue))
			return false;
		return true;
	}
	
	
}
