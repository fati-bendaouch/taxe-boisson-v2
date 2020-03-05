package com.example.taxBoisson.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class TauxTaxeBoisson implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categorie == null) ? 0 : categorie.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(pourcentageBase);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(pourcentageRetard);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		TauxTaxeBoisson other = (TauxTaxeBoisson) obj;
		if (categorie == null) {
			if (other.categorie != null)
				return false;
		} else if (!categorie.equals(other.categorie))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(pourcentageBase) != Double.doubleToLongBits(other.pourcentageBase))
			return false;
		if (Double.doubleToLongBits(pourcentageRetard) != Double.doubleToLongBits(other.pourcentageRetard))
			return false;
		return true;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
