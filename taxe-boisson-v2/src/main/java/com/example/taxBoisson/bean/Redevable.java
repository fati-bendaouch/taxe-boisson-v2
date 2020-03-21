package com.example.taxBoisson.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
public class Redevable  implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nom;
	private String identifiant;
	@ManyToOne
	private TypeRedevable typeRedevable;
	
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	public TypeRedevable getTypeRedevable() {
		return typeRedevable;
	}
	public void setTypeRedevable(TypeRedevable typeRedevable) {
		this.typeRedevable = typeRedevable;
	}


	
	public Redevable(long id, String nom, String identifiant, TypeRedevable typeRedevable) {
		this.id = id;
		this.nom = nom;
		this.identifiant = identifiant;
		this.typeRedevable = typeRedevable;
	}
	public Redevable() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((identifiant == null) ? 0 : identifiant.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((typeRedevable == null) ? 0 : typeRedevable.hashCode());
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
		Redevable other = (Redevable) obj;
		if (id != other.id)
			return false;
		if (identifiant == null) {
			if (other.identifiant != null)
				return false;
		} else if (!identifiant.equals(other.identifiant))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (typeRedevable == null) {
			if (other.typeRedevable != null)
				return false;
		} else if (!typeRedevable.equals(other.typeRedevable))
			return false;
		return true;
	}
	
	
}
