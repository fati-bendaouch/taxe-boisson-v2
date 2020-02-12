package com.example.taxBoisson.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Redevable  implements Serializable {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nom;
	private String identientant;
	@ManyToOne
	private TypeRedevable typeRedevable;
	
	private String ref; 
	
	
	public String getIdentientant() {
		return identientant;
	}
	public void setIdentientant(String identientant) {
		this.identientant = identientant;
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

	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	
	
	public Redevable(long id, String nom, TypeRedevable typeRedevable, String ref) {
		super();
		this.id = id;
		this.nom = nom;
		this.typeRedevable = typeRedevable;
		this.ref = ref;
	}
	
	public Redevable() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
